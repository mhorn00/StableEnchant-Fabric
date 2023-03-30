package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class BuffedOutEnchantment extends Enchantment {

	public BuffedOutEnchantment(int rarety, EnchantmentType type) {
		super(rarety, type);
	}
	
	@Override
	public int getMaxLevel() {
		return 3;
	}
	
	@Override
	public boolean isTreasure() {
		return true;
	}

}
