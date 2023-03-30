package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.util.registry.Registry;
import xyz.sarcly.stableenchant.StableEnchant;
import xyz.sarcly.stableenchant.enchantment.Enchantment.EnchantmentType;
import xyz.sarcly.stableenchant.enchantment.enchantments.BrittleCurseEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.BuffedOutEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.ButterfingersCurseEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.DepthsStriderEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.DepthsSwimmerEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.EfficiencyEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.FeatherFallingEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.FrostWalkerEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.GrasswalkerEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.HastyEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.MeleeProtection;
import xyz.sarcly.stableenchant.enchantment.enchantments.NethersbaneEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.OtherworldlyEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.ProtectionEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.SharpnessEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.SlaughteringEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.SoulSpeedEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.StoneboundEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.UnbindingCurse;
import xyz.sarcly.stableenchant.enchantment.enchantments.UnbreakableEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.UnbreakingEnchantment;
import xyz.sarcly.stableenchant.enchantment.enchantments.VanishingCurseEnchantment;

public class Enchantments {
	public static final Enchantment BRITTLE_CURSE = Enchantments.register("brittle_curse", new BrittleCurseEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment BUFFED_OUT = Enchantments.register("buffed_out", new BuffedOutEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment BUTTERFINGERS_CURSE = Enchantments.register("butterfingers_curse", new ButterfingersCurseEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment DEPTHS_STRIDER = Enchantments.register("depths_strider", new DepthsStriderEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment DEPTHS_SWIMMER = Enchantments.register("depths_swimmer", new DepthsSwimmerEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment EFFICIENCY = Enchantments.register("efficiency", new EfficiencyEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment FEATHER_FALLER = Enchantments.register("feather_faller", new FeatherFallingEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment FROST_WALKER = Enchantments.register("frost_walker", new FrostWalkerEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment GRASSWALKER = Enchantments.register("grasswalker", new GrasswalkerEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment HASTY = Enchantments.register("hasty", new HastyEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment MELEE_PROTECTION = Enchantments.register("melee_protection", new MeleeProtection(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment NETHERSBANE = Enchantments.register("nethersbane", new NethersbaneEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment OTHERWORLDLY = Enchantments.register("otherworldy", new OtherworldlyEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment PROTECTION = Enchantments.register("protection", new ProtectionEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment SHARPNESS = Enchantments.register("sharpness", new SharpnessEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment SLAUGHTERING = Enchantments.register("slaughtering", new SlaughteringEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment SOUL_SPEED = Enchantments.register("soul_speed", new SoulSpeedEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment STONEBOUND = Enchantments.register("stonebound", new StoneboundEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment UNBINDING_CURSE = Enchantments.register("unbinding_curse", new UnbindingCurse(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment UNBREAKABLE = Enchantments.register("unbreakable", new UnbreakableEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment UNBREAKING = Enchantments.register("unbreaking", new UnbreakingEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	public static final Enchantment VANISHING_CURSE = Enchantments.register("vanishing_curse", new VanishingCurseEnchantment(0, new EnchantmentType[] {EnchantmentType.AllEnchantment}));
	
	public static Enchantment register(String name, Enchantment enchantment) {
		return Registry.register(StableEnchant.STABLE_ENCHANTMENT, name, enchantment);
	}
}
