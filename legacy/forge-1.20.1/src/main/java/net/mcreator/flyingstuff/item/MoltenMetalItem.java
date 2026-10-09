
package net.mcreator.flyingstuff.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.flyingstuff.init.FlyingStuffModFluids;

public class MoltenMetalItem extends BucketItem {
	public MoltenMetalItem() {
		super(FlyingStuffModFluids.MOLTEN_METAL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
	}
}
