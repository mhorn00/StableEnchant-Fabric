package xyz.sarcly.stableenchant.enchantment.enchantments;

import xyz.sarcly.stableenchant.enchantment.Enchantment;

public class NethersbaneEnchantment extends Enchantment {

	public NethersbaneEnchantment(int rarety, EnchantmentType[] types) {
		super(rarety, types);
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}

}
