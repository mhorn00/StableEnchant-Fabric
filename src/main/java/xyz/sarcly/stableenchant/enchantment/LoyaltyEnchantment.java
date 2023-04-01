package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class LoyaltyEnchantment extends StableEnchantment {

	public LoyaltyEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.TRIDENT, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}
}
