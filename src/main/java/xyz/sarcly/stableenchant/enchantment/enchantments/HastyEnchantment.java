package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class HastyEnchantment extends Enchantment {

	public HastyEnchantment(int rarety, EnchantmentType[] types) {
		super(rarety, types);
	}

	public int getMaxLevel() {
		return 3;
	}
	
}
