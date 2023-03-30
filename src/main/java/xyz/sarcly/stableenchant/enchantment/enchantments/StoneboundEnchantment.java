package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class StoneboundEnchantment extends Enchantment {

	public StoneboundEnchantment(int rarety, EnchantmentType type) {
		super(rarety, type);
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}
}
