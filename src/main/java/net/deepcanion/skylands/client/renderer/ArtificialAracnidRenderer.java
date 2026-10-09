
package net.deepcanion.skylands.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.deepcanion.skylands.entity.model.ArtificialAracnidModel;
import net.deepcanion.skylands.entity.layer.ArtificialAracnidLayer;
import net.deepcanion.skylands.entity.ArtificialAracnidEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ArtificialAracnidRenderer extends GeoEntityRenderer<ArtificialAracnidEntity> {
	public ArtificialAracnidRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ArtificialAracnidModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new ArtificialAracnidLayer(this));
	}

	@Override
	public RenderType getRenderType(ArtificialAracnidEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ArtificialAracnidEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}
}
