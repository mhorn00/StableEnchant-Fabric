package xyz.sarcly.stableenchant.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.item.ToolItem;
import xyz.sarcly.stableenchant.enchantment.Enchantment;
import xyz.sarcly.stableenchant.enchantment.IEnchantable;

@Mixin(ToolItem.class)
public abstract class ToolItemMixin implements IEnchantable{

	@Override 
	public boolean canApplyEnchant(Enchantment e) {
		return false;
	}

}
