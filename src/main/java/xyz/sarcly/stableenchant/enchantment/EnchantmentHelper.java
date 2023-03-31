package xyz.sarcly.stableenchant.enchantment;

import java.util.LinkedHashMap;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.Maps;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import xyz.sarcly.stableenchant.StableEnchant;

public class EnchantmentHelper {
	private static final String ID_KEY = "id";
	private static final String LEVEL_KEY = "lvl";

	public static NbtCompound createNbt(@Nullable Identifier id, int lvl) {
		NbtCompound nbtCompound = new NbtCompound();
		nbtCompound.putString(ID_KEY, String.valueOf(id));
		nbtCompound.putInt(LEVEL_KEY, lvl);
		return nbtCompound;
	}

	public static void writeLevelToNbt(NbtCompound nbt, int lvl) {
		nbt.putInt(LEVEL_KEY, lvl);
	}

	public static int getLevelFromNbt(NbtCompound nbt) {
		return MathHelper.clamp(nbt.getInt(LEVEL_KEY), 0, Integer.MAX_VALUE);
	}

	@Nullable
	public static Identifier getIdFromNbt(NbtCompound nbt) {
		return Identifier.tryParse(nbt.getString(ID_KEY));
	}

	@Nullable
	public static Identifier getEnchantmentId(Enchantment enchantment) {
		return StableEnchant.STABLE_ENCHANTMENT.getId(enchantment);
	}

	public static int getLevel(Enchantment enchantment, ItemStack stack) {
		if (stack.isEmpty()) return 0;
		NbtList nbt = stack.getEnchantments();
		for (int i = 0; i < nbt.size(); i++) {
			NbtCompound nbtEnchant = nbt.getCompound(i);
			if (getIdFromNbt(nbtEnchant).equals(getEnchantmentId(enchantment))) return getLevelFromNbt(nbtEnchant);
		}
		return 0;
	}

	public static Map<Enchantment, Integer> fromNbt(NbtList list) {
		LinkedHashMap<Enchantment, Integer> map = Maps.newLinkedHashMap();
		for (int i = 0; i < list.size(); ++i) {
			NbtCompound nbtCompound = list.getCompound(i);
			StableEnchant.STABLE_ENCHANTMENT.getOrEmpty(EnchantmentHelper.getIdFromNbt(nbtCompound)).ifPresent(enchantment -> map.put((Enchantment) enchantment, EnchantmentHelper.getLevelFromNbt(nbtCompound)));
		}
		return map;
	}

	public static boolean hasAquaAffinity(LivingEntity ent) {
		ItemStack stack = ent.getEquippedStack(EquipmentSlot.HEAD);
		return getLevel(Enchantments.AQUA_AFFINITY, stack) > 0;
	}
	
	public static boolean hasBindingCurse(ItemStack stack) {
		return getLevel(Enchantments.BINDING_CURSE, stack) > 0;
	}
	
	public static boolean hasChanneling(ItemStack stack) {
		System.out.println("FUCKFUCKFUCKFUCKFUCKFUCKUFCKUFCKUFCKFUCKFUFCKFUCK");
		return getLevel(Enchantments.CHANNELING, stack) > 0;
	}

}
