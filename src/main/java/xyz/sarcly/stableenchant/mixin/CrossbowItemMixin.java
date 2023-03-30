package xyz.sarcly.stableenchant.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.item.CrossbowItem;
import xyz.sarcly.stableenchant.enchantment.Enchantment;
import xyz.sarcly.stableenchant.enchantment.Enchantment.EnchantmentType;
import xyz.sarcly.stableenchant.enchantment.IEnchantable;

@Mixin(CrossbowItem.class)
public abstract class CrossbowItemMixin implements IEnchantable{

	@Override
	public boolean canApplyEnchant(Enchantment e) {
		return e.hasType(EnchantmentType.AllEnchantment) || e.hasType(EnchantmentType.CrossbowEnchantment);
	}

}
