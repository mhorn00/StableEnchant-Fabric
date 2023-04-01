package xyz.sarcly.stableenchant.enchantment;

import java.util.EnumMap;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.Maps;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

public class StableEnchantment extends Enchantment {

	private final EquipmentSlot[] slotTypes;
	private final int enchantRarity;
	private final int stability;
	public final EnchantmentTarget type;
	@Nullable protected String translationKey;

	protected StableEnchantment(int rarity, int stability, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
		super(Rarity.COMMON, type, slotTypes); // not using this ctor
		this.enchantRarity = rarity;
		this.stability = stability;
		this.type = type;
		this.slotTypes = slotTypes;
	}

	public int getEnchantRarity() {
		return this.enchantRarity;
	}
	
	public int getStability() {
		return this.stability;
	}
	
	@Override
	public int getMinLevel() {
		return 1;
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
	
	@Override
	public boolean isTreasure() {
		return false;
	}
	
	@Override
	public boolean isCursed() {
		return false;
	}
	
	@Override
	protected boolean canAccept(Enchantment other) {
		return this != other;
	}
	
	@Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }

	@Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }
	
	@Override
    public boolean isAcceptableItem(ItemStack stack) {
        return this.type.isAcceptableItem(stack.getItem());
    }
	
	@Override
    public Map<EquipmentSlot, ItemStack> getEquipment(LivingEntity entity) {
        EnumMap<EquipmentSlot, ItemStack> map = Maps.newEnumMap(EquipmentSlot.class);
        for (EquipmentSlot slot : this.slotTypes) {
            ItemStack item = entity.getEquippedStack(slot);
            if (!item.isEmpty()) map.put(slot, item);
        }
        return map;
    }

	@Override
	public Text getName(int level) {
        MutableText mutableText = Text.translatable(this.getTranslationKey());
        if (this.isCursed()) {
            mutableText.formatted(Formatting.RED);
        } else if (this.isTreasure()) {
        	mutableText.formatted(Formatting.GOLD);
        } else {
            mutableText.formatted(Formatting.GRAY);
        }
        if (level != 1 || this.getMaxLevel() != 1) {
            mutableText.append(" ").append(Text.translatable("enchantment.level." + level));
        }
        return mutableText;
    }
	
	@Override
    protected String getOrCreateTranslationKey() {
        if (this.translationKey == null) {
            this.translationKey = Util.createTranslationKey("enchantment", Registry.ENCHANTMENT.getId(this));
        }
        return this.translationKey;
    }

	@Override
    public String getTranslationKey() {
        return this.getOrCreateTranslationKey();
    }
	
}
