
package net.mcreator.flyingstuff.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class UndergroundMusicDiskItem extends RecordItem {
	public UndergroundMusicDiskItem() {
		super(10, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("flying_stuff:underground_music_disk")), new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), 1900);
	}
}
