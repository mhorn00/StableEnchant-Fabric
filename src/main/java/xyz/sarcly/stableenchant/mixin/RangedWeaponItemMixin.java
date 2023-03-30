package xyz.sarcly.stableenchant.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.item.RangedWeaponItem;
import xyz.sarcly.stableenchant.enchantment.Enchantment;
import xyz.sarcly.stableenchant.enchantment.IEnchantable;
import xyz.sarcly.stableenchant.enchantment.Enchantment.EnchantmentType;

@Mixin(RangedWeaponItem.class)
public abstract class RangedWeaponItemMixin implements IEnchantable {

	@Override
	public boolean canApplyEnchant(Enchantment e) {
		return e.hasType(EnchantmentType.AllEnchantment) || e.hasType(EnchantmentType.CrossbowEnchantment) || e.hasType(EnchantmentType.BowEnchantment);
	}

}
