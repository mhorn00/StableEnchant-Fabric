package xyz.sarcly.stableenchant.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.enchantment.Enchantment;
import xyz.sarcly.stableenchant.enchantment.StableEnchantments;

@Mixin(net.minecraft.enchantment.Enchantments.class)
public abstract class EnchantmentsMixin {
	
	@Inject(method = "register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;", at = @At("HEAD"), cancellable = true)
	private static void cancelRegister(String name, Enchantment enchantment, CallbackInfoReturnable<Enchantment> cir) {
		cir.setReturnValue(null);
		cir.cancel();
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;PROTECTION:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getProtection(Enchantment enchantment) {
		enchantment = StableEnchantments.PROTECTION;
	}

	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;FIRE_PROTECTION:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getFireProtection(Enchantment enchantment) {
		enchantment = StableEnchantments.FIRE_PROTECTION;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;FEATHER_FALLING:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getFeatherFalling(Enchantment enchantment) {
		enchantment = StableEnchantments.FEATHER_FALLING;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;BLAST_PROTECTION:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getBlastProtection(Enchantment enchantment) {
		enchantment = StableEnchantments.BLAST_PROTECTION;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;RESPIRATION:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getRespiration(Enchantment enchantment) {
		enchantment = StableEnchantments.RESPIRATION;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;AQUA_AFFINITY:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getAquaAffinity(Enchantment enchantment) {
		enchantment = StableEnchantments.AQUA_AFFINITY;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;THORNS:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getThorns(Enchantment enchantment) {
		enchantment = StableEnchantments.THORNS;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;DEPTH_STRIDER:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getDepthStrider(Enchantment enchantment) {
		enchantment = StableEnchantments.DEPTH_STRIDER;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;FROST_WALKER:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getFrostWalker(Enchantment enchantment) {
		enchantment = StableEnchantments.FROST_WALKER;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;BINDING_CURSE:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getBindingCurse(Enchantment enchantment) {
		enchantment = StableEnchantments.BINDING_CURSE;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;SOUL_SPEED:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getSoulSpeed(Enchantment enchantment) {
		enchantment = StableEnchantments.SOUL_SPEED;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;SWIFT_SNEAK:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getSwiftSneak(Enchantment enchantment) {
		enchantment = StableEnchantments.SWIFT_SNEAK;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;SHARPNESS:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getSharpness(Enchantment enchantment) {
		enchantment = StableEnchantments.SHARPNESS;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;SMITE:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getSmite(Enchantment enchantment) {
		enchantment = StableEnchantments.SMITE;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;BANE_OF_ARTHROPODS:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getBaneOfArthropods(Enchantment enchantment) {
		enchantment = StableEnchantments.BANE_OF_ARTHROPODS;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;KNOCKBACK:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getKnockback(Enchantment enchantment) {
		enchantment = StableEnchantments.KNOCKBACK;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;FIRE_ASPECT:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getFireAspect(Enchantment enchantment) {
		enchantment = StableEnchantments.FIRE_ASPECT;
	}	
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;LOOTING:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getLooting(Enchantment enchantment) {
		enchantment = StableEnchantments.LOOTING;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;SWEEPING:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getSweeping(Enchantment enchantment) {
		enchantment = StableEnchantments.SWEEPING;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;EFFICIENCY:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getEfficiency(Enchantment enchantment) {
		enchantment = StableEnchantments.EFFICIENCY;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;SILK_TOUCH:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getSilkTouch(Enchantment enchantment) {
		enchantment = StableEnchantments.SILK_TOUCH;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;UNBREAKING:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getUnbreaking(Enchantment enchantment) {
		enchantment = StableEnchantments.UNBREAKING;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;FORTUNE:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getFortune(Enchantment enchantment) {
		enchantment = StableEnchantments.FORTUNE;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;POWER:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getPower(Enchantment enchantment) {
		enchantment = StableEnchantments.POWER;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;PUNCH:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getPunch(Enchantment enchantment) {
		enchantment = StableEnchantments.PUNCH;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;FLAME:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getFlame(Enchantment enchantment) {
		enchantment = StableEnchantments.FLAME;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;INFINITY:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getInfinity(Enchantment enchantment) {
		enchantment = StableEnchantments.INFINITY;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;LUCK_OF_THE_SEA:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getLuckOfTheSea(Enchantment enchantment) {
		enchantment = StableEnchantments.LUCK_OF_THE_SEA;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;LURE:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getLure(Enchantment enchantment) {
		enchantment = StableEnchantments.LURE;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;LOYALTY:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getLoyalty(Enchantment enchantment) {
		enchantment = StableEnchantments.LOYALTY;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;IMPALING:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getImplaing(Enchantment enchantment) {
		enchantment = StableEnchantments.IMPALING;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;RIPTIDE:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getRiptide(Enchantment enchantment) {
		enchantment = StableEnchantments.RIPTIDE;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;CHANNELING:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getChanneling(Enchantment enchantment) {
		enchantment = StableEnchantments.CHANNELING;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;MULTISHOT:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getMultishot(Enchantment enchantment) {
		enchantment = StableEnchantments.MULTISHOT;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;QUICK_CHARGE:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getQuickCharge(Enchantment enchantment) {
		enchantment = StableEnchantments.QUICK_CHARGE;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;PIERCING:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getPiercing(Enchantment enchantment) {
		enchantment = StableEnchantments.PIERCING;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;MENDING:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getMending(Enchantment enchantment) {
		enchantment = StableEnchantments.MENDING;
	}
	
	@Redirect(
		method = "<clinit>",
	    slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantments;register(Ljava/lang/String;Lnet/minecraft/enchantment/Enchantment;)Lnet/minecraft/enchantment/Enchantment;")),
	    at = @At(value = "FIELD", target = "Lnet/minecraft/enchantment/Enchantments;VANISHING_CURSE:Lnet/minecraft/enchantment/Enchantment;", opcode = Opcodes.PUTSTATIC))
	private static void getVanishingCurse(Enchantment enchantment) {
		enchantment = StableEnchantments.VANISHING_CURSE;
	}
}
