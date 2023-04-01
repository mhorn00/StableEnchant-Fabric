package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class BindingCurseEnchantment extends StableEnchantment {

	public BindingCurseEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.WEARABLE, slotTypes);
	}
	
	@Override
	public boolean isCursed() {
		return true;
	}

}
