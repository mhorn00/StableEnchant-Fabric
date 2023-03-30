package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class UnbreakingEnchantment extends Enchantment {

	public UnbreakingEnchantment(int rarety, EnchantmentType[] types) {
		super(rarety, types);
	}
	
	@Override
	public int getMaxLevel() {
		return 3;
	}

}
