package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class ChannelingEnchantment extends StableEnchantment {

	public ChannelingEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.TRIDENT, slotTypes);
	}
	
	@Override
	public boolean isTreasure() {
		return true;
	}

}
