package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class UnbreakingEnchantment extends StableEnchantment {

	public UnbreakingEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.BREAKABLE, slotTypes);
	}
	
	@Override
	public int getMaxLevel() {
		return 3;
	}

}
