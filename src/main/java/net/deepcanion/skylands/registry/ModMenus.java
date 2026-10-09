package net.deepcanion.skylands.registry;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.inventory.SkyChestMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.*;
public final class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, SkyLands.MOD_ID);
    public static final DeferredHolder<MenuType<?>, MenuType<SkyChestMenu>> SKY_CHEST = MENUS.register("golden_chest", () -> new MenuType<>((id, inv) -> new SkyChestMenu(id, inv, 27), FeatureFlags.DEFAULT_FLAGS));
    public static final DeferredHolder<MenuType<?>, MenuType<SkyChestMenu>> PROTO_CHEST = MENUS.register("proto_chest_gui", () -> new MenuType<>((id, inv) -> new SkyChestMenu(id, inv, 44), FeatureFlags.DEFAULT_FLAGS));
    public static final DeferredHolder<MenuType<?>, MenuType<net.deepcanion.skylands.inventory.StarterGuideMenu>> STARTER_GUIDE = MENUS.register("sky_lands_starter_guide", () -> new MenuType<>((id, inv) -> new net.deepcanion.skylands.inventory.StarterGuideMenu(id), FeatureFlags.DEFAULT_FLAGS));
    private ModMenus() { }
}
