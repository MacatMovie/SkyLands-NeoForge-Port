
package net.mcreator.flyingstuff.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CelestiumItem extends Item {
	public CelestiumItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
