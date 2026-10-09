
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.flyingstuff.client.gui.St1Screen;
import net.mcreator.flyingstuff.client.gui.St0Screen;
import net.mcreator.flyingstuff.client.gui.ProtoChestGuiScreen;
import net.mcreator.flyingstuff.client.gui.GoldenChestScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FlyingStuffModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(FlyingStuffModMenus.GOLDEN_CHEST.get(), GoldenChestScreen::new);
			MenuScreens.register(FlyingStuffModMenus.ST_0.get(), St0Screen::new);
			MenuScreens.register(FlyingStuffModMenus.ST_1.get(), St1Screen::new);
			MenuScreens.register(FlyingStuffModMenus.PROTO_CHEST_GUI.get(), ProtoChestGuiScreen::new);
		});
	}
}
