package xyz.sarcly.stableenchant.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.item.BowItem;
import xyz.sarcly.stableenchant.enchantment.Enchantment;
import xyz.sarcly.stableenchant.enchantment.Enchantment.EnchantmentType;
import xyz.sarcly.stableenchant.enchantment.IEnchantable;

@Mixin(BowItem.class)
public abstract class BowItemMixin implements IEnchantable {

	@Override
	public boolean canApplyEnchant(Enchantment e) {
		return e.hasType(EnchantmentType.AllEnchantment) || e.hasType(EnchantmentType.BowEnchantment);
	}

}
