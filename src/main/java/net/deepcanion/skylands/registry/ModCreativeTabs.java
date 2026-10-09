package net.deepcanion.skylands.registry;

import net.deepcanion.skylands.SkyLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SkyLands.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SKY_LANDS_ITEMS = TABS.register("sky_lands_items",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.flying_stuff.sky_lands_items"))
                    .icon(() -> ModItems.CELESTIUM.get().getDefaultInstance()).withSearchBar()
                    .displayItems((parameters, output) -> ModItems.ITEMS.getEntries().forEach(item -> {
                        if (!(item.get() instanceof BlockItem)) output.accept(item.get());
                    })).build());
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FLOATY_STUFF = TABS.register("floaty_stuff",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.flying_stuff.floaty_stuff"))
                    .icon(() -> ModBlocks.SKYROCK.get().asItem().getDefaultInstance()).withSearchBar()
                    .displayItems((parameters, output) -> ModItems.BLOCK_ITEMS.forEach(item -> output.accept(item.get()))).build());
    private ModCreativeTabs() { }
}
