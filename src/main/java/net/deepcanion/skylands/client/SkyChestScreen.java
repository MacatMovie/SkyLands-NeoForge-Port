package net.deepcanion.skylands.client;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.inventory.SkyChestMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
public final class SkyChestScreen extends AbstractContainerScreen<SkyChestMenu> {
    private final ResourceLocation texture;
    public SkyChestScreen(SkyChestMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        imageWidth = menu.size == 44 ? 220 : 190; imageHeight = menu.size == 44 ? 192 : 178;
        texture = SkyLands.id("textures/screens/" + (menu.size == 44 ? "proto_chest_gui" : "golden_chest") + ".png");
        titleLabelX = menu.size == 44 ? 83 : 15; titleLabelY = 2;
    }
    @Override public void render(GuiGraphics graphics, int x, int y, float partial) { super.render(graphics, x, y, partial); renderTooltip(graphics, x, y); }
    @Override protected void renderBg(GuiGraphics graphics, float partial, int x, int y) { graphics.blit(texture, leftPos, topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight); }
    @Override protected void renderLabels(GuiGraphics graphics, int x, int y) { graphics.drawString(font, font.plainSubstrByWidth(title.getString(), imageWidth - titleLabelX - 8), titleLabelX, titleLabelY, 0x3c3c3c, false); }
}
