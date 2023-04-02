package xyz.sarcly.stableenchant.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.enchantment.Enchantment;
import xyz.sarcly.stableenchant.enchantment.StableEnchantments;

@Mixin(net.minecraft.enchantment.Enchantments.class)
public abstract class EnchantmentsMixin {
	
	@Inject(method = "register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;", at = @At("HEAD"), cancellable = true)
	private static void cancelRegister(String name, Enchantment enchantment, CallbackInfoReturnable<Enchantment> cir) {
		cir.setReturnValue(StableEnchantments.getById(name));
	}
}
