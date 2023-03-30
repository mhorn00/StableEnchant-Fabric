package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class VanishingCurseEnchantment extends Enchantment {

	public VanishingCurseEnchantment(int rarety, EnchantmentType[] types) {
		super(rarety, types);
	}
	
	public int getMaxLevel() {
		return 4;
	}

	@Override
	public boolean isCurse() {
		return true;
	}
}
