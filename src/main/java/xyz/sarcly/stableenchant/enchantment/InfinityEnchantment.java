package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class InfinityEnchantment extends StableEnchantment {

	public InfinityEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.BOW, slotTypes);
	}
	
	@Override
	public boolean isTreasure() {
		return true;
	}

}
