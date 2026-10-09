
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.flyingstuff.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.flyingstuff.world.inventory.St1Menu;
import net.mcreator.flyingstuff.world.inventory.St0Menu;
import net.mcreator.flyingstuff.world.inventory.ProtoChestGuiMenu;
import net.mcreator.flyingstuff.world.inventory.GoldenChestMenu;
import net.mcreator.flyingstuff.FlyingStuffMod;

public class FlyingStuffModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, FlyingStuffMod.MODID);
	public static final RegistryObject<MenuType<GoldenChestMenu>> GOLDEN_CHEST = REGISTRY.register("golden_chest", () -> IForgeMenuType.create(GoldenChestMenu::new));
	public static final RegistryObject<MenuType<St0Menu>> ST_0 = REGISTRY.register("st_0", () -> IForgeMenuType.create(St0Menu::new));
	public static final RegistryObject<MenuType<St1Menu>> ST_1 = REGISTRY.register("st_1", () -> IForgeMenuType.create(St1Menu::new));
	public static final RegistryObject<MenuType<ProtoChestGuiMenu>> PROTO_CHEST_GUI = REGISTRY.register("proto_chest_gui", () -> IForgeMenuType.create(ProtoChestGuiMenu::new));
}
