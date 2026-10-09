package net.mcreator.flyingstuff.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.flyingstuff.world.inventory.St0Menu;
import net.mcreator.flyingstuff.network.St0ButtonMessage;
import net.mcreator.flyingstuff.FlyingStuffMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class St0Screen extends AbstractContainerScreen<St0Menu> {
	private final static HashMap<String, Object> guistate = St0Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_arrowr;

	public St0Screen(St0Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 128;
		this.imageHeight = 196;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("flying_stuff:textures/screens/book_page0.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 128, 196, 128, 196);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrowr = new ImageButton(this.leftPos + 120, this.topPos + 178, 22, 18, 0, 0, 18, new ResourceLocation("flying_stuff:textures/screens/atlas/imagebutton_arrowr.png"), 22, 36, e -> {
			if (true) {
				FlyingStuffMod.PACKET_HANDLER.sendToServer(new St0ButtonMessage(0, x, y, z));
				St0ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrowr", imagebutton_arrowr);
		this.addRenderableWidget(imagebutton_arrowr);
	}
}
