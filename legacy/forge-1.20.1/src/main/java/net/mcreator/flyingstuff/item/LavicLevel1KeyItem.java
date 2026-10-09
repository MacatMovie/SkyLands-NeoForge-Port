
package net.mcreator.flyingstuff.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class LavicLevel1KeyItem extends Item {
	public LavicLevel1KeyItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
