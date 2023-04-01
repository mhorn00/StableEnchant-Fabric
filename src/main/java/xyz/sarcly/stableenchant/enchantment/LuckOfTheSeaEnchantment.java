package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class LuckOfTheSeaEnchantment extends StableEnchantment {

	public LuckOfTheSeaEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.FISHING_ROD, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}
	
}
