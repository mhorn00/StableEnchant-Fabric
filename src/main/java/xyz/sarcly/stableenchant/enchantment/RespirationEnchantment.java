package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class RespirationEnchantment extends StableEnchantment {

	public RespirationEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.ARMOR_HEAD, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}
	
}
