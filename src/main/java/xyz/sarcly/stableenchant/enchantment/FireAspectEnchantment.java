package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class FireAspectEnchantment extends StableEnchantment {

	public FireAspectEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.WEAPON, slotTypes);
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}
	
}
