package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class SlaughteringEnchantment extends Enchantment {

	public SlaughteringEnchantment(int rarety, EnchantmentType type) {
		super(rarety, type);
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}

}
