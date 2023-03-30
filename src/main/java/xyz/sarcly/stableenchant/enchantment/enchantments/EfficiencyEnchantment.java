package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class EfficiencyEnchantment extends Enchantment {

	public EfficiencyEnchantment(int rarety, EnchantmentType type) {
		super(rarety, type);
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}
}
