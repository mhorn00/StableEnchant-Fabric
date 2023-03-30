package xyz.sarcly.stableenchant.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.item.SwordItem;
import xyz.sarcly.stableenchant.enchantment.Enchantment;
import xyz.sarcly.stableenchant.enchantment.Enchantment.EnchantmentType;
import xyz.sarcly.stableenchant.enchantment.IEnchantable;

@Mixin(SwordItem.class)
public abstract class SwordItemMixin implements IEnchantable {

	@Override
	public boolean canApplyEnchant(Enchantment e) {
		return (e.hasType(EnchantmentType.AllEnchantment) || 
			e.hasType(EnchantmentType.WeaponEnchant) || 
			e.hasType(EnchantmentType.SwordEnchantment)) &&
			!(e.hasType(EnchantmentType.WeaponEnchant) && e.hasType(EnchantmentType.AxeEnchantment));
	}

}
