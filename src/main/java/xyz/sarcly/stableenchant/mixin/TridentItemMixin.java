package xyz.sarcly.stableenchant.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.item.TridentItem;
import xyz.sarcly.stableenchant.enchantment.Enchantment;
import xyz.sarcly.stableenchant.enchantment.Enchantment.EnchantmentType;
import xyz.sarcly.stableenchant.enchantment.IEnchantable;

@Mixin(TridentItem.class)
public abstract class TridentItemMixin implements IEnchantable {

	@Override
	public boolean canApplyEnchant(Enchantment e) {
		return e.hasType(EnchantmentType.AllEnchantment) || e.hasType(EnchantmentType.TridentEnchantment);
	}

}
