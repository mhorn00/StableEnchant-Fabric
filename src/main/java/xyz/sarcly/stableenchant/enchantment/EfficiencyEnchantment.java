package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class EfficiencyEnchantment extends StableEnchantment {

	public EfficiencyEnchantment(int rarity, int stability, EquipmentSlot[] slotTypes) {
		super(rarity, stability, EnchantmentTarget.DIGGER, slotTypes);
	}
	
	@Override
	public int getMaxLevel() {
		return 10;
	}

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (stack.isOf(Items.SHEARS)) return true;
        return super.isAcceptableItem(stack);
    }
	
}
