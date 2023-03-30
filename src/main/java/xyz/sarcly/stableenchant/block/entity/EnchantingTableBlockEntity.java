package xyz.sarcly.stableenchant.block.entity;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import xyz.sarcly.stableenchant.StableEnchant;
import xyz.sarcly.stableenchant.screen.handler.EnchantingTableScreenHandler;

public class EnchantingTableBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, Inventory {

	private final DefaultedList<ItemStack> inv = DefaultedList.ofSize(3, ItemStack.EMPTY);
	public boolean hasBook = false;
    public int ticks;
    public float nextPageAngle;
    public float pageAngle;
    public float flipRandom;
    public float flipTurn;
    public float nextPageTurningSpeed;
    public float pageTurningSpeed;
    public float bookRotation;
    public float lastBookRotation;
    public float targetBookRotation;
    private static final Random RANDOM = Random.create();
	
	public EnchantingTableBlockEntity(BlockPos pos, BlockState state) {
		super(StableEnchant.ENCHANTING_TABLE_BLOCK_ENTITY, pos, state);
	}
	
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inv);
        this.hasBook = nbt.getBoolean("hasBook");
    }
 
    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inv);
        nbt.putBoolean("hasBook", this.hasBook);
        super.writeNbt(nbt);
    }
	
	public DefaultedList<ItemStack> getItems() {
		return inv;
	}

	@Override
	public ItemStack getStack(int slot) {
		return getItems().get(slot);
	}

	@Override
	public ItemStack removeStack(int slot, int count) {
        ItemStack result = Inventories.splitStack(getItems(), slot, count);
        if (!result.isEmpty()) {
            markDirty();
        }
        return result;
	}

    @Override
	public ItemStack removeStack(int slot) {
        return Inventories.removeStack(getItems(), slot);
    }

	@Override
	public void setStack(int slot, ItemStack stack) {
        getItems().set(slot, stack);
        if (stack.getCount() > stack.getMaxCount()) {
            stack.setCount(stack.getMaxCount());
        }
	}

	@Override
	public boolean canPlayerUse(PlayerEntity ply) {
		return true;
	}
	
	@Override
	public void clear() {
		getItems().clear();
	}

	@Override
	public int size() {
		return getItems().size();
	}

	@Override
	public boolean isEmpty() {
		for (int i = 0; i < size(); i++) {
            ItemStack stack = getStack(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
	}

	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory plyInv, PlayerEntity ply) {
		return new EnchantingTableScreenHandler(syncId, plyInv, this);
	}

	@Override
	public Text getDisplayName() {
		return Text.translatable(getCachedState().getBlock().getTranslationKey());
	}

	@Override
	public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) { //Server side
		buf.writeBlockPos(pos);
	}
	
	@Override
    public void onOpen(PlayerEntity player) {
		
    }

    @Override
    public void onClose(PlayerEntity player) {
    	
    }
    
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
      return BlockEntityUpdateS2CPacket.create(this);
    }
   
    @Override
    public NbtCompound toInitialChunkDataNbt() {
      return createNbt();
    }
    
    public static void tick(World world, BlockPos pos, BlockState state, EnchantingTableBlockEntity blockEntity) {
    	if (blockEntity.hasBook) {
	    	float g;
	        blockEntity.pageTurningSpeed = blockEntity.nextPageTurningSpeed;
	        blockEntity.lastBookRotation = blockEntity.bookRotation;
	        PlayerEntity playerEntity = world.getClosestPlayer((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, 3.0, false);
	        if (playerEntity != null) {
	            double d = playerEntity.getX() - ((double)pos.getX() + 0.5);
	            double e = playerEntity.getZ() - ((double)pos.getZ() + 0.5);
	            blockEntity.targetBookRotation = (float)MathHelper.atan2(e, d);
	            blockEntity.nextPageTurningSpeed += 0.1f;
	            if (blockEntity.nextPageTurningSpeed < 0.5f || RANDOM.nextInt(40) == 0) {
	                float f = blockEntity.flipRandom;
	                do {
	                    blockEntity.flipRandom += (float)(RANDOM.nextInt(4) - RANDOM.nextInt(4));
	                } while (f == blockEntity.flipRandom);
	            }
	        } else {
	            blockEntity.targetBookRotation += 0.02f;
	            blockEntity.nextPageTurningSpeed -= 0.1f;
	        }
	        while (blockEntity.bookRotation >= (float)Math.PI) {
	            blockEntity.bookRotation -= (float)Math.PI * 2;
	        }
	        while (blockEntity.bookRotation < (float)(-Math.PI)) {
	            blockEntity.bookRotation += (float)Math.PI * 2;
	        }
	        while (blockEntity.targetBookRotation >= (float)Math.PI) {
	            blockEntity.targetBookRotation -= (float)Math.PI * 2;
	        }
	        while (blockEntity.targetBookRotation < (float)(-Math.PI)) {
	            blockEntity.targetBookRotation += (float)Math.PI * 2;
	        }
	        for (g = blockEntity.targetBookRotation - blockEntity.bookRotation; g >= (float)Math.PI; g -= (float)Math.PI * 2) {
	        }
	        while (g < (float)(-Math.PI)) {
	            g += (float)Math.PI * 2;
	        }
	        blockEntity.bookRotation += g * 0.4f;
	        blockEntity.nextPageTurningSpeed = MathHelper.clamp(blockEntity.nextPageTurningSpeed, 0.0f, 1.0f);
	        ++blockEntity.ticks;
	        blockEntity.pageAngle = blockEntity.nextPageAngle;
	        float h = (blockEntity.flipRandom - blockEntity.nextPageAngle) * 0.4f;
	        h = MathHelper.clamp(h, -0.2f, 0.2f);
	        blockEntity.flipTurn += (h - blockEntity.flipTurn) * 0.9f;
	        blockEntity.nextPageAngle += blockEntity.flipTurn;
    	}
    }
}
