package xyz.sarcly.stableenchant.enchantment;

public abstract class Enchantment {

	private EnchantmentType[] types;
	private int rarety;

	public Enchantment(int rarety, EnchantmentType[] types) {
		this.types = types;
		this.rarety = rarety;
	}

	public Enchantment(int rarety, EnchantmentType type) {
		this.types = new EnchantmentType[] { type };
		this.rarety = rarety;
	}

	public EnchantmentType[] getTypes() {
		return this.types;
	}

	public boolean hasType(EnchantmentType type) {
		for (int i = 0; i < this.types.length; i++) {
			if (this.types[i] == type) return true; 
		}
		return false;
	}

	public int getMinLevel() {
		return 1;
	}

	public int getMaxLevel() {
		return 1;
	}

	public int getRarety() {
		return rarety;
	}

	public boolean isTreasure() {
		return false;
	}

	public boolean isCurse() {
		return false;
	}

	public boolean canApplyWith(Enchantment e) {
		return e != this;
	}

	public enum EnchantmentType {
		AllEnchantment,
		WeaponEnchant,
		ToolEnchantment,
		PickaxeEnchantment,
		ShovelEnchantment,
		AxeEnchantment,
		HoeEnchantment,
		SwordEnchantment, 
		ArmorEnchantment, 
		ElytraEnchantment,
		FishingEnchantment, 
		BowEnchantment, 
		CrossbowEnchantment, 
		TridentEnchantment,
		ShulkerboxEnchantment,
		MiscEnchantment
	}

}
