package xyz.sarcly.stableenchant.screen.handler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import xyz.sarcly.stableenchant.StableEnchant;

public class EnchantingTableScreenHandler extends ScreenHandler {

	private BlockPos pos;
	private final Inventory inv;
	
	public EnchantingTableScreenHandler(int syncId, PlayerInventory plyInv, PacketByteBuf buf) { //Client Constructor
		this(syncId, plyInv, new SimpleInventory(3));
		pos = buf.readBlockPos();
	}

	public EnchantingTableScreenHandler(int syncId, PlayerInventory plyInv, Inventory inv) { //Server Constructor
		super(StableEnchant.ENCHANTING_TABLE_SCREEN_HANDLER, syncId);
		this.inv = inv;
		inv.onOpen(plyInv.player);

		this.addSlot(new Slot(inv, 1, 76, 39)); //Modifier Slot
		this.addSlot(new Slot(inv, 2, 121, 39)); //Enchant Slot
		// The player inventory
		int m;
		for (m = 0; m < 3; ++m) {
			for (int l = 0; l < 9; ++l) {
				this.addSlot(new Slot(plyInv, l + m * 9 + 9, 8 + l * 18, 94 + m * 18));
			}
		}
		// The player Hotbar
		for (m = 0; m < 9; ++m) {
			this.addSlot(new Slot(plyInv, m, 8 + m * 18, 152));
		}
	}
	
	public BlockPos getPos() {
		return this.pos;
	}

	@Override
	public ItemStack transferSlot(PlayerEntity ply, int invSlot) {
		 ItemStack newStack = ItemStack.EMPTY;
	        Slot slot = this.slots.get(invSlot);
	        if (slot != null && slot.hasStack()) {
	            ItemStack originalStack = slot.getStack();
	            newStack = originalStack.copy();
	            if (invSlot < this.inv.size()) {
	                if (!this.insertItem(originalStack, this.inv.size(), this.slots.size(), true)) {
	                    return ItemStack.EMPTY;
	                }
	            } else if (!this.insertItem(originalStack, 0, this.inv.size(), false)) {
	                return ItemStack.EMPTY;
	            }
	 
	            if (originalStack.isEmpty()) {
	                slot.setStack(ItemStack.EMPTY);
	            } else {
	                slot.markDirty();
	            }
	        }
	        return newStack;
	}

	@Override
	public boolean canUse(PlayerEntity ply) {
		return this.inv.canPlayerUse(ply);
	}
}
