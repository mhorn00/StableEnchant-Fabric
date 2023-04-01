package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class PowerEnchantment extends StableEnchantment {

	public PowerEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.BOW, slotTypes);
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}

}
