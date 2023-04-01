package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class FeatherFallingEnchantment extends StableEnchantment {

	public FeatherFallingEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.ARMOR_FEET, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}
	
}
