package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class PunchEnchantment extends StableEnchantment {

	public PunchEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.BOW, slotTypes);
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}

}
