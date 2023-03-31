package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class ChannelingEnchantment extends Enchantment {

	public ChannelingEnchantment(int rarety, EnchantmentType[] types) {
		super(rarety, types);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean isTreasure() {
		return true;
	}
	
}
