package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class MultishotEnchantment extends StableEnchantment {

	public MultishotEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.CROSSBOW, slotTypes);	
	}
	
	@Override
	public boolean isTreasure() {
		return true;
	}
	
}
