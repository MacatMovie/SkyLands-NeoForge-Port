
package net.mcreator.flyingstuff.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class ColdDesertMusicDiscItem extends RecordItem {
	public ColdDesertMusicDiscItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("flying_stuff:desert_disc")), new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), 1665);
	}
}
