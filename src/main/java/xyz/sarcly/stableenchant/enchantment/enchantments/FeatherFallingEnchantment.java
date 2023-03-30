package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class FeatherFallingEnchantment extends Enchantment {

	public FeatherFallingEnchantment(int rarety, EnchantmentType type) {
		super(rarety, type);
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}
	
}