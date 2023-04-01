package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class QuickChargeEnchantment extends StableEnchantment {

	public QuickChargeEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.CROSSBOW, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}
	
}
