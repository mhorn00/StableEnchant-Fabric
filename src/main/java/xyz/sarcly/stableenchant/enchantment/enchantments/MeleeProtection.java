package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class MeleeProtection extends Enchantment {

	public MeleeProtection(int rarety, EnchantmentType type) {
		super(rarety, type);
	}
	
	public int getMaxLevel() {
		return 4;
	}
}
