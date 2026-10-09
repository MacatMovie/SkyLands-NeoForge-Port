package net.mcreator.flyingstuff.procedures;

import net.minecraft.world.item.ItemStack;

public class GliderPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("canvas");
	}
}
