package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class OtherworldlyEnchantment extends Enchantment {

	public OtherworldlyEnchantment(int rarety, EnchantmentType type) {
		super(rarety, type);
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}
}
