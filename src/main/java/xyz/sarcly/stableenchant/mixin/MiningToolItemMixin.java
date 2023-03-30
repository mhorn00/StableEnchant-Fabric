package xyz.sarcly.stableenchant.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.item.MiningToolItem;
import xyz.sarcly.stableenchant.enchantment.Enchantment;
import xyz.sarcly.stableenchant.enchantment.Enchantment.EnchantmentType;
import xyz.sarcly.stableenchant.enchantment.IEnchantable;

@Mixin(MiningToolItem.class)
public abstract class MiningToolItemMixin implements IEnchantable {

	@Override
	public boolean canApplyEnchant(Enchantment e) {
		return e.hasType(EnchantmentType.AllEnchantment) || e.hasType(EnchantmentType.ToolEnchantment);
	}

}
