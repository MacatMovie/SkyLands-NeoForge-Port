
package net.mcreator.flyingstuff.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class SkyRiverMusicDiskItem extends RecordItem {
	public SkyRiverMusicDiskItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("flying_stuff:sky_river_disk")), new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), 2550);
	}
}
