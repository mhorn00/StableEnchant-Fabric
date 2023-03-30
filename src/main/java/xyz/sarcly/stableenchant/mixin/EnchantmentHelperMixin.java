package xyz.sarcly.stableenchant.mixin;

import java.util.Map;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Identifier;
import xyz.sarcly.stableenchant.enchantment.Enchantment;
import xyz.sarcly.stableenchant.enchantment.EnchantmentHelper;

@Mixin(net.minecraft.enchantment.EnchantmentHelper.class)
public class EnchantmentHelperMixin {
	
	@Overwrite
	public static NbtCompound createNbt(@Nullable Identifier id, int lvl) {
		return EnchantmentHelper.createNbt(id, lvl);
    }
	
	@Overwrite
    public static void writeLevelToNbt(NbtCompound nbt, int lvl) {
		EnchantmentHelper.writeLevelToNbt(nbt, lvl);
    }

	@Overwrite
    public static int getLevelFromNbt(NbtCompound nbt) {
		return EnchantmentHelper.getLevelFromNbt(nbt);
    }

	@Overwrite
    public static Identifier getIdFromNbt(NbtCompound nbt) {
		return EnchantmentHelper.getIdFromNbt(nbt);
    }
//
//	@Overwrite
//    public static Identifier getEnchantmentId(Enchantment enchantment) {
//		return EnchantmentHelper.getEnchantmentId(enchantment);
//    }
//
//	@Overwrite
//    public static int getLevel(Enchantment enchantment, ItemStack stack) {
//		return EnchantmentHelper.getLevel(enchantment, stack);
//    }

//	@Overwrite
//    public static Map<Enchantment, Integer> get(ItemStack stack) {
//
//    }

	@Overwrite
    public static Map<Enchantment, Integer> fromNbt(NbtList list) {
		return EnchantmentHelper.fromNbt(list);
    }

//	@Overwrite
//    public static void set(Map<Enchantment, Integer> enchantments, ItemStack stack) {
//
//    }
//
//	@Overwrite
//    private static void forEachEnchantment(Consumer consumer, ItemStack stack) {
//
//    }
//
//	@Overwrite
//    private static void forEachEnchantment(Consumer consumer, Iterable<ItemStack> stacks) {
//
//    }
//
//	@Overwrite
//    public static int getProtectionAmount(Iterable<ItemStack> equipment, DamageSource source) {
//
//    }
//
//	@Overwrite
//    public static float getAttackDamage(ItemStack stack, EntityGroup group) {
//
//    }
//
//	@Overwrite
//    public static float getSweepingMultiplier(LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static void onUserDamaged(LivingEntity user, Entity attacker) {
//
//    }
//
//	@Overwrite
//    public static void onTargetDamaged(LivingEntity user, Entity target) {
//
//    }
//
//	@Overwrite
//    public static int getEquipmentLevel(Enchantment enchantment, LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static float getSwiftSneakSpeedBoost(LivingEntity livingEntity) {
//
//    }
//
//	@Overwrite
//    public static int getKnockback(LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static int getFireAspect(LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static int getRespiration(LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static int getDepthStrider(LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static int getEfficiency(LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static int getLuckOfTheSea(ItemStack stack) {
//
//    }
//
//	@Overwrite
//    public static int getLure(ItemStack stack) {
//
//    }
//
//	@Overwrite
//    public static int getLooting(LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static boolean hasAquaAffinity(LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static boolean hasFrostWalker(LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static boolean hasSoulSpeed(LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static boolean hasBindingCurse(ItemStack stack) {
//
//    }
//
//	@Overwrite
//    public static boolean hasVanishingCurse(ItemStack stack) {
//
//    }
//
//	@Overwrite
//    public static int getLoyalty(ItemStack stack) {
//
//    }
//
//	@Overwrite
//    public static int getRiptide(ItemStack stack) {
//
//    }
//
//	@Overwrite
//    public static boolean hasChanneling(ItemStack stack) {
//        
//    }
//
//	@Overwrite
//    public static Map.Entry<EquipmentSlot, ItemStack> chooseEquipmentWith(Enchantment enchantment, LivingEntity entity) {
//
//    }
//
//	@Overwrite
//    public static Map.Entry<EquipmentSlot, ItemStack> chooseEquipmentWith(Enchantment enchantment, LivingEntity entity, Predicate<ItemStack> condition) {
//
//    }
//
//	@Overwrite
//    public static int calculateRequiredExperienceLevel(Random random, int slotIndex, int bookshelfCount, ItemStack stack) {
//
//    }
//
//	@Overwrite
//    public static ItemStack enchant(Random random, ItemStack target, int level, boolean treasureAllowed) {
//
//    }
//
//	@Overwrite
//    public static List<EnchantmentLevelEntry> generateEnchantments(Random random, ItemStack stack, int level, boolean treasureAllowed) {
//
//    }
//
//	@Overwrite
//    public static void removeConflicts(List<EnchantmentLevelEntry> possibleEntries, EnchantmentLevelEntry pickedEntry) {
//
//    }
//
//	@Overwrite
//    public static boolean isCompatible(Collection<Enchantment> existing, Enchantment candidate) {
//
//    }
//
//	@Overwrite
//    public static List<EnchantmentLevelEntry> getPossibleEntries(int power, ItemStack stack, boolean treasureAllowed) {
//    
//    }
}
