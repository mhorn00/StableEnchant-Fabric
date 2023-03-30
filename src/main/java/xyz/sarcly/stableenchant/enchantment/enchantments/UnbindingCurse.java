package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class UnbindingCurse extends Enchantment {

	public UnbindingCurse(int rarety, EnchantmentType type) {
		super(rarety, type);
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
