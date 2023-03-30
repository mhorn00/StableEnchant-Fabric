package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class StoneboundEnchantment extends Enchantment {

	public StoneboundEnchantment(int rarety, EnchantmentType[] types) {
		super(rarety, types);
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}
}
