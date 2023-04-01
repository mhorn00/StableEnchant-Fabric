package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class SmiteEnchantment extends StableEnchantment {

	public SmiteEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.WEAPON, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
	
}
