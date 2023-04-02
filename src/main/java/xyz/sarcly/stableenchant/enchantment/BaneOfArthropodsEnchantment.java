package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class BaneOfArthropodsEnchantment extends StableEnchantment {

	public BaneOfArthropodsEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.WEAPON, slotTypes);
	}
	
	@Override
	public boolean isCursed() {
		return true;
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}

}
