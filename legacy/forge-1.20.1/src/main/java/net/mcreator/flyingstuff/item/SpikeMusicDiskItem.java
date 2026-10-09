
package net.mcreator.flyingstuff.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class SpikeMusicDiskItem extends RecordItem {
	public SpikeMusicDiskItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("flying_stuff:diskice")), new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), 3800);
	}
}
