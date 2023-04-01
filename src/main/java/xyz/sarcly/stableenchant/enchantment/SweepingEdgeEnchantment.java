package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class SweepingEdgeEnchantment extends StableEnchantment {

	public SweepingEdgeEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.WEAPON, slotTypes); //TODO: differentiate sword and weapon
	}
	
	@Override
	public int getMaxLevel() {
		return 3;
	}
}
