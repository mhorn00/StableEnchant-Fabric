package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class BrittleCurseEnchantment extends Enchantment {

	public BrittleCurseEnchantment(int rarety, EnchantmentType type) {
		super(rarety, type);
	}
	
	@Override
	public int getMaxLevel() {
		return 4;
	}
	
	@Override
	public boolean isCurse() {
		return true;
	}
	
}
