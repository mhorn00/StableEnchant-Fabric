package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class SharpnessEnchantment extends Enchantment {

	public SharpnessEnchantment(int rarety, EnchantmentType type) {
		super(rarety, type);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}
	
	@Override
	public boolean isTreasure() {
		return true;
	}
	
}