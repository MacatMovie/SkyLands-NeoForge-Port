package net.deepcanion.skylands.client;

import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.inventory.StarterGuideMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public final class StarterGuideScreen extends AbstractContainerScreen<StarterGuideMenu> {
    private static final String[] PAGES = {"islands", "glider", "freefall", "chests", "arenas", "village", "rewards", "equipment"};
    private static final ResourceLocation COVER = SkyLands.id("textures/screens/book_page0.png");
    private static final ResourceLocation PAPER = SkyLands.id("textures/screens/page.png");
    private int page;
    private Button previous, next;
    public StarterGuideScreen(StarterGuideMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        imageWidth = 128; imageHeight = 196;
    }
    @Override protected void init() {
        super.init();
        previous = addRenderableWidget(Button.builder(Component.translatable("guide.flying_stuff.previous"), button -> turn(-1))
                .bounds(leftPos - 24, topPos + 174, 20, 20).build());
        next = addRenderableWidget(Button.builder(Component.translatable("guide.flying_stuff.next"), button -> turn(1))
                .bounds(leftPos + imageWidth + 4, topPos + 174, 20, 20).build());
        updateButtons();
    }
    private void turn(int direction) { page = Math.clamp(page + direction, 0, PAGES.length); updateButtons(); }
    private void updateButtons() { previous.active = page > 0; next.active = page < PAGES.length; }
    @Override protected void renderBg(GuiGraphics graphics, float partial, int mouseX, int mouseY) {
        graphics.blit(page == 0 ? COVER : PAPER, leftPos, topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
    }
    @Override protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        if (page == 0) return;
        String key = "guide.flying_stuff." + PAGES[page - 1];
        graphics.drawWordWrap(font, Component.translatable(key + ".title"), 9, 9, 110, 0x153b21);
        graphics.drawWordWrap(font, Component.translatable(key + ".body"), 9, 36, 110, 0x153b21);
        graphics.drawCenteredString(font, Component.literal(page + " / " + PAGES.length), imageWidth / 2, 180, 0x153b21);
    }
}
