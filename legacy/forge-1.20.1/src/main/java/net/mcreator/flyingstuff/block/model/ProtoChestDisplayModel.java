package net.mcreator.flyingstuff.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.block.display.ProtoChestDisplayItem;

public class ProtoChestDisplayModel extends GeoModel<ProtoChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(ProtoChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "animations/proto_chest.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ProtoChestDisplayItem animatable) {
		return new ResourceLocation("flying_stuff", "geo/proto_chest.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ProtoChestDisplayItem entity) {
		return new ResourceLocation("flying_stuff", "textures/block/protochest.png");
	}
}
