package xyz.sarcly.stableenchant.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.item.AxeItem;
import xyz.sarcly.stableenchant.enchantment.Enchantment;
import xyz.sarcly.stableenchant.enchantment.IEnchantable;
import xyz.sarcly.stableenchant.enchantment.Enchantment.EnchantmentType;

@Mixin(AxeItem.class)
public abstract class AxeItemMixin implements IEnchantable {

	@Override
	public boolean canApplyEnchant(Enchantment e) {
		return (e.hasType(EnchantmentType.AllEnchantment) || 
			e.hasType(EnchantmentType.ToolEnchantment) ||
			e.hasType(EnchantmentType.WeaponEnchant) ||
			e.hasType(EnchantmentType.AxeEnchantment)) &&
			!(e.hasType(EnchantmentType.WeaponEnchant) && e.hasType(EnchantmentType.SwordEnchantment));
	}

}
