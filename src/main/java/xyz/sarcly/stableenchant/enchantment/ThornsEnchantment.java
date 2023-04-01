package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class ThornsEnchantment extends StableEnchantment {

	public ThornsEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.ARMOR, slotTypes);
	}
	
	@Override
	public int getMaxLevel() {
		return 3;
	}

}
