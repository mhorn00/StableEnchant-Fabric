package xyz.sarcly.stableenchant.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public class StableEnchantments { //TODO: equip slots
	private static final EquipmentSlot[] ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
	public static final StableEnchantment AQUA_AFFINITY = StableEnchantments.register("aqua_affinity", new AquaAffinityEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment BANE_OF_ARTHROPODS = StableEnchantments.register("bane_of_arthropods", new BaneOfArthropodsEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment BINDING_CURSE = StableEnchantments.register("binding_curse", new BindingCurseEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment BLAST_PROTECTION = StableEnchantments.register("blast_protection", new BlastProtectionEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment CHANNELING = StableEnchantments.register("channeling", new ChannelingEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment DEPTH_STRIDER = StableEnchantments.register("depth_strider", new DepthStriderEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment EFFICIENCY = StableEnchantments.register("efficiency", new EfficiencyEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment FEATHER_FALLING = StableEnchantments.register("feather_falling", new FeatherFallingEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment FIRE_ASPECT = StableEnchantments.register("fire_aspect", new FireAspectEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment FIRE_PROTECTION = StableEnchantments.register("fire_protection", new FireProtectionEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment FLAME = StableEnchantments.register("flame", new FlameEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment FORTUNE = StableEnchantments.register("fortune", new FortuneEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment FROST_WALKER = StableEnchantments.register("frost_walker", new FrostWalkerEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment IMPALING = StableEnchantments.register("impaling", new ImpalingEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment INFINITY = StableEnchantments.register("infinity", new InfinityEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment KNOCKBACK = StableEnchantments.register("knockback", new KnockbackEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment LOOTING = StableEnchantments.register("looting", new LootingEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment LOYALTY = StableEnchantments.register("loyalty", new LoyaltyEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment LUCK_OF_THE_SEA = StableEnchantments.register("luck_of_the_sea", new LuckOfTheSeaEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment LURE = StableEnchantments.register("lure", new LureEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment MENDING = StableEnchantments.register("mending", new MendingEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment MULTISHOT = StableEnchantments.register("multishot", new MultishotEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment PIERCING = StableEnchantments.register("piercing", new PiercingEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment POWER = StableEnchantments.register("power", new PowerEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment PROJECTILE_PROTECTION = StableEnchantments.register("projectile_protection", new ProjectileProtectionEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment PROTECTION = StableEnchantments.register("protection", new ProtectionEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment PUNCH = StableEnchantments.register("punch", new PunchEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment QUICK_CHARGE = StableEnchantments.register("quick_charge", new QuickChargeEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment RESPIRATION = StableEnchantments.register("respiration", new RespirationEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment RIPTIDE = StableEnchantments.register("riptide", new RiptideEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment SHARPNESS = StableEnchantments.register("sharpness", new SharpnessEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment SILK_TOUCH = StableEnchantments.register("silk_touch", new SilkTouchEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment SMITE = StableEnchantments.register("smite", new SmiteEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment SOUL_SPEED = StableEnchantments.register("soul_speed", new SoulSpeedEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment SWEEPING = StableEnchantments.register("sweeping", new SweepingEdgeEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment SWIFT_SNEAK = StableEnchantments.register("swift_sneak", new SwiftSneakEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment THORNS = StableEnchantments.register("thorns", new ThornsEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment UNBREAKING = StableEnchantments.register("unbreaking", new UnbreakingEnchantment(0, 0, ALL_ARMOR));
	public static final StableEnchantment VANISHING_CURSE = StableEnchantments.register("vanishing_curse", new VanishingCurseEnchantment(0, 0, ALL_ARMOR));
	
	private static StableEnchantment register(String name, Enchantment enchantment) {
		return (StableEnchantment)Registry.register(Registry.ENCHANTMENT, name, enchantment);
	}
}
