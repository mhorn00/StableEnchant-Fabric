package xyz.sarcly.stableenchant.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import xyz.sarcly.stableenchant.StableEnchant;

@Mixin(net.minecraft.util.registry.Registry.class)
public abstract class RegistryMixin {
	
	//TOOD: this is dumb find a better way potentially 
	@Inject(method = "createRegistryKey(Ljava/lang/String;)Lnet/minecraft/util/registry/RegistryKey;", at = @At("HEAD"), cancellable = true)
	private static void modifyEnchantmentRegistry(String regisrtyId, CallbackInfoReturnable<RegistryKey<Registry<Object>>> cir) {
		if (regisrtyId.equals("enchantment")) {
			cir.setReturnValue(RegistryKey.ofRegistry(new Identifier(StableEnchant.MODID, regisrtyId)));
		}
	}
	
}
