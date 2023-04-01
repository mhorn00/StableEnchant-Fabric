package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class FortuneEnchantment extends StableEnchantment {

	public FortuneEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.DIGGER, slotTypes);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}
}
