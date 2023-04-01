package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class SoulSpeedEnchantment extends StableEnchantment {

	public SoulSpeedEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.ARMOR_FEET, slotTypes);
	}

    @Override
    public int getMaxLevel() {
        return 3;
    }
	
    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }
	
}
