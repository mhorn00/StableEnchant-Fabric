package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

public class FrostWalkerEnchantment extends StableEnchantment {

	public FrostWalkerEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.ARMOR_FEET, slotTypes);
	}
	
	@Override
	public int getMaxLevel() {
		return 2;
	}
	
	@Override
	public boolean isTreasure() {
		return true;
	}
	
	@Override
	public boolean canAccept(Enchantment other) {
		return super.canAccept(other);//TODO: mutual exclusion with other enchants
	}
	
}
