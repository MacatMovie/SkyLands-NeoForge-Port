package net.deepcanion.skylands.item;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

/** Native smithing hints without constructing unregistered helper items. */
public final class SkyArmorTrimTemplateItem extends SmithingTemplateItem {
    private static final List<ResourceLocation> ARMOR_ICONS = List.of(
            icon("empty_armor_slot_helmet"), icon("empty_armor_slot_chestplate"),
            icon("empty_armor_slot_leggings"), icon("empty_armor_slot_boots"));
    private static final List<ResourceLocation> MATERIAL_ICONS = List.of(
            icon("empty_slot_ingot"), icon("empty_slot_redstone_dust"),
            icon("empty_slot_quartz"), icon("empty_slot_emerald"),
            icon("empty_slot_diamond"), icon("empty_slot_lapis_lazuli"),
            icon("empty_slot_amethyst_shard"));

    private static ResourceLocation icon(String name) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", "item/" + name);
    }
    public SkyArmorTrimTemplateItem(String pattern) {
        super(Component.translatable("item.minecraft.smithing_template.armor_trim.applies_to").withStyle(ChatFormatting.BLUE),
                Component.translatable("item.minecraft.smithing_template.armor_trim.ingredients").withStyle(ChatFormatting.BLUE),
                Component.translatable("trim_pattern.flying_stuff." + pattern).withStyle(ChatFormatting.GRAY),
                Component.translatable("item.minecraft.smithing_template.armor_trim.base_slot_description"),
                Component.translatable("item.minecraft.smithing_template.armor_trim.additions_slot_description"),
                ARMOR_ICONS, MATERIAL_ICONS);
    }
    @Override public boolean hasCraftingRemainingItem(ItemStack stack) { return true; }
    @Override public ItemStack getCraftingRemainingItem(ItemStack stack) { return new ItemStack(this); }
}
