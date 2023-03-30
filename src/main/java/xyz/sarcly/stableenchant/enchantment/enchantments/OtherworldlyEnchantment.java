package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class OtherworldlyEnchantment extends Enchantment {

	public OtherworldlyEnchantment(int rarety, EnchantmentType[] types) {
		super(rarety, types);
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}
}
