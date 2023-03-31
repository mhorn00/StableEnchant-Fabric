package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class BindingCurseEnchantment extends Enchantment {

	public BindingCurseEnchantment(int rarety, EnchantmentType[] types) {
		super(rarety, types);
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
	
	@Override
	public boolean isCurse() {
		return true;
	}

}
