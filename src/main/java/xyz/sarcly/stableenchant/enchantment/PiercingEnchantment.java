package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class PiercingEnchantment extends StableEnchantment {

	public PiercingEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.CROSSBOW, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}
	
}
