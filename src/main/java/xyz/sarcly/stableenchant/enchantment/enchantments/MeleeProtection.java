package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class MeleeProtection extends Enchantment {

	public MeleeProtection(int rarety, EnchantmentType[] types) {
		super(rarety, types);
	}
	
	public int getMaxLevel() {
		return 4;
	}
}
