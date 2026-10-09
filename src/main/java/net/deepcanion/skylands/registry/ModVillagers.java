package net.deepcanion.skylands.registry;
import com.google.common.collect.ImmutableSet;
import net.deepcanion.skylands.SkyLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
public final class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, SkyLands.MOD_ID);
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, SkyLands.MOD_ID);
    public static final DeferredHolder<PoiType, PoiType> COOL_POI = POI_TYPES.register("cool",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.CELESTIUM_ANVIL.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> COOL = PROFESSIONS.register("cool",
            () -> new VillagerProfession("flying_stuff:cool", poi -> poi.is(COOL_POI.getKey()), poi -> poi.is(COOL_POI.getKey()), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_TRADE));
    public static void trades(VillagerTradesEvent event) {
        if (event.getType() != COOL.get()) return;
        event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ModItems.CELESTIUM.get(), 10), new ItemStack(ModBlocks.CLOUD_BLOCK.get()), 10, 5, 0.05F));
        event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 2), new ItemStack(ModItems.CELESTIUM.get(), 8), new ItemStack(ModItems.ISLAND_GLIDER_DESIGN.get()), 10, 9, 0.05F));
        event.getTrades().get(2).add(new BasicItemListing(new ItemStack(ModItems.GOLDENLEVEL_1_KEY.get()), new ItemStack(ModBlocks.CELESTIUM_BLOCK.get()), new ItemStack(ModItems.HEADSET_ARMOR_TRIM_SMITHING_TEMPLATE.get()), 10, 11, 0.05F));
    }
    private ModVillagers() { }
}
