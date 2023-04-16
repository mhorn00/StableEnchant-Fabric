package xyz.sarcly.stableenchant.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EnchantingBookItem extends Item {

	public EnchantingBookItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity ply, Hand hand) {
		ply.useBook(ply.getStackInHand(hand), hand);
		ply.incrementStat(Stats.USED.getOrCreateStat(this));
		return TypedActionResult.success(ply.getStackInHand(hand), world.isClient());
	}

}
