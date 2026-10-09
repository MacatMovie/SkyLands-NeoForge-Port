
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.flyingstuff.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FlyingStuffModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == FlyingStuffModVillagerProfessions.COOL.get()) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(FlyingStuffModItems.GOLDENLEVEL_1_KEY.get()), new ItemStack(FlyingStuffModBlocks.CELESTIUM_BLOCK.get()),
					new ItemStack(FlyingStuffModItems.HEADSET_ARMOR_TRIM_SMITHING_TEMPLATE.get()), 10, 11, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(FlyingStuffModItems.CELESTIUM.get(), 10),

					new ItemStack(FlyingStuffModBlocks.CLOUD_BLOCK.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 2), new ItemStack(FlyingStuffModItems.CELESTIUM.get(), 8), new ItemStack(FlyingStuffModItems.ISLAND_GLIDER_DESIGN.get()), 10, 9, 0.05f));
		}
	}
}
