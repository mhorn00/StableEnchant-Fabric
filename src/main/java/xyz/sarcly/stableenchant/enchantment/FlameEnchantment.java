package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class FlameEnchantment extends StableEnchantment {

	public FlameEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.BOW, slotTypes);
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}
}
