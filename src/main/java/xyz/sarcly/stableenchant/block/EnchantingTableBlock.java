package xyz.sarcly.stableenchant.block;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import xyz.sarcly.stableenchant.StableEnchant;
import xyz.sarcly.stableenchant.block.entity.EnchantingTableBlockEntity;

public class EnchantingTableBlock extends Block implements BlockEntityProvider {

	protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 12.0, 16.0);
	
	
	public EnchantingTableBlock(Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new EnchantingTableBlockEntity(pos, state);
	}
	
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient) return ActionResult.SUCCESS; //return if client
		//Server Side
		EnchantingTableBlockEntity blockEnt = (EnchantingTableBlockEntity)world.getBlockEntity(pos);
		Inventory blockEntInv = (Inventory) blockEnt;
		if (player.getStackInHand(hand).isEmpty()) { //if players hand is empty
			if (player.isSneaking() && !blockEnt.getStack(0).isEmpty() && blockEnt.getStack(0).isOf(StableEnchant.ENCHANTING_BOOK)) {
				//if the player is sneaking and the table has a book in it
				player.setStackInHand(hand, blockEntInv.getStack(0).copy()); 
				blockEntInv.setStack(0, ItemStack.EMPTY); //remove the book from the table and give it to the player
				blockEnt.hasBook = false;
				blockEnt.markDirty();
				world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
				return ActionResult.SUCCESS;
			}
		}else {//else player is holding item
			if (player.getStackInHand(hand).isOf(StableEnchant.ENCHANTING_BOOK) && blockEnt.getStack(0).isEmpty()) {
				//if the player is holding the book and the table does not have the book
				blockEntInv.setStack(0, player.getStackInHand(hand).copy());
				player.getStackInHand(hand).setCount(0); //take the book from the player and put it in the table
				blockEnt.hasBook = true;
				blockEnt.markDirty();
				world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
				return ActionResult.SUCCESS; //return so we dont open the UI when putting the book in
			}	
		}
		if (!player.getStackInHand(hand).isOf(StableEnchant.ENCHANTING_BOOK)) {
			NamedScreenHandlerFactory shf = createScreenHandlerFactory(state, world, pos);
			if (shf != null) {
				player.openHandledScreen(shf);
			}	
		}
		return ActionResult.SUCCESS;
	}
	
    @SuppressWarnings("deprecation")
	@Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
    	//drop items when block is broken
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof EnchantingTableBlockEntity) {
                ItemScatterer.spawn(world, pos, (EnchantingTableBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
    
    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) { //Client Side
    	return world.isClient ? EnchantingTableBlock.checkType(type, StableEnchant.ENCHANTING_TABLE_BLOCK_ENTITY, EnchantingTableBlockEntity::tick) : null;
    }

	@SuppressWarnings("unchecked")
	@Nullable
    protected static <E extends BlockEntity, G extends BlockEntity> BlockEntityTicker<G> checkType(BlockEntityType<G> givenType, BlockEntityType<E> expectedType, BlockEntityTicker<E> ticker) {
        return expectedType == givenType ? (BlockEntityTicker<G>)ticker : null;
    }
    
    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }
 
    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }
    
	@Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity instanceof NamedScreenHandlerFactory ? (NamedScreenHandlerFactory)((Object)blockEntity) : null;
    }
	
    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    
    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

}
