package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class MendingEnchantment extends StableEnchantment {

	public MendingEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.BREAKABLE, slotTypes);
	}
	
	@Override
	public boolean isTreasure() {
		return true;
	}
	
}
