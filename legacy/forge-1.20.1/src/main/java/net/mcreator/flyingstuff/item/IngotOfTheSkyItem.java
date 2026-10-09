
package net.mcreator.flyingstuff.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class IngotOfTheSkyItem extends Item {
	public IngotOfTheSkyItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
