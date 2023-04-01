package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class ImpalingEnchantment extends StableEnchantment {

	public ImpalingEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.TRIDENT, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
	
}
