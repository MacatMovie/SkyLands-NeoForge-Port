
package net.mcreator.flyingstuff.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PaleCelestiumItem extends Item {
	public PaleCelestiumItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
