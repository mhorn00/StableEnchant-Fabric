package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class AquaAffinityEnchantment extends StableEnchantment {

	protected AquaAffinityEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.ARMOR_HEAD, slotTypes);
	}

    @Override
    public int getMaxLevel() {
        return 1;
    }
	
}
