package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class UnbreakableEnchantment extends Enchantment {

	public UnbreakableEnchantment(int rarety, EnchantmentType type) {
		super(rarety, type);
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}

}
