package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class UnbindingCurse extends Enchantment {

	public UnbindingCurse(int rarety, EnchantmentType[] types) {
		super(rarety, types);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}
	
	@Override
	public boolean isCurse() {
		return true;
	}
	
}
