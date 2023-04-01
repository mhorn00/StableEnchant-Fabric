package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class RiptideEnchantment extends StableEnchantment {

	public RiptideEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.TRIDENT, slotTypes);
	}
	
	@Override
	public int getMaxLevel() {
		return 3;
	}

}
