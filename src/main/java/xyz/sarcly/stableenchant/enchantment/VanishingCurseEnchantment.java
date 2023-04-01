package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class VanishingCurseEnchantment extends StableEnchantment {

	public VanishingCurseEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.VANISHABLE, slotTypes);
	}
	
	@Override
	public boolean isCursed() {
		return true;
	}

}
