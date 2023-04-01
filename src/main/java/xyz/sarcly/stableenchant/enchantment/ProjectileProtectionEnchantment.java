package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class ProjectileProtectionEnchantment extends StableEnchantment {

	public ProjectileProtectionEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.ARMOR, slotTypes);
	}
	
	@Override
	public int getMaxLevel() {
		return 4;
	}

}
