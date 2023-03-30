package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class FrostWalkerEnchantment extends Enchantment {

	public FrostWalkerEnchantment(int rarety, EnchantmentType type) {
		super(rarety, type);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}
	
	@Override
	public boolean isTreasure() {
		return true;
	}
	
}
