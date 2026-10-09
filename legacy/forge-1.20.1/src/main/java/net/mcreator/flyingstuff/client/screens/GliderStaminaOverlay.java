
package net.mcreator.flyingstuff.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.flyingstuff.procedures.GliderStaminaDisplayOverlayIngameProcedure;
import net.mcreator.flyingstuff.procedures.GliderStamina5Procedure;
import net.mcreator.flyingstuff.procedures.GliderStamina4Procedure;
import net.mcreator.flyingstuff.procedures.GliderStamina3Procedure;
import net.mcreator.flyingstuff.procedures.GliderStamina2Procedure;
import net.mcreator.flyingstuff.procedures.GliderFirstStaminaProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class GliderStaminaOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (GliderStaminaDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(new ResourceLocation("flying_stuff:textures/screens/stamina_under.png"), w / 2 + -47, h - 70, 0, 0, 96, 16, 96, 16);

			if (GliderFirstStaminaProcedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("flying_stuff:textures/screens/stamina_over.png"), w / 2 + -49, h - 70, 0, 0, 16, 16, 16, 16);
			}
			if (GliderStamina2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("flying_stuff:textures/screens/stamina_over.png"), w / 2 + -28, h - 70, 0, 0, 16, 16, 16, 16);
			}
			if (GliderStamina3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("flying_stuff:textures/screens/stamina_over.png"), w / 2 + -7, h - 70, 0, 0, 16, 16, 16, 16);
			}
			if (GliderStamina4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("flying_stuff:textures/screens/stamina_over.png"), w / 2 + 14, h - 70, 0, 0, 16, 16, 16, 16);
			}
			if (GliderStamina5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("flying_stuff:textures/screens/stamina_over.png"), w / 2 + 36, h - 70, 0, 0, 16, 16, 16, 16);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
