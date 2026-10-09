package net.deepcanion.skylands.client.model;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.block.entity.SkyChestBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
public final class SkyChestModel extends GeoModel<SkyChestBlockEntity> {
    @Override public ResourceLocation getModelResource(SkyChestBlockEntity chest) { return SkyLands.id("geo/" + chest.kind().asset() + ".geo.json"); }
    @Override public ResourceLocation getTextureResource(SkyChestBlockEntity chest) { return SkyLands.id(chest.kind().texture(chest.unlocked())); }
    @Override public ResourceLocation getAnimationResource(SkyChestBlockEntity chest) { return SkyLands.id("animations/" + chest.kind().asset() + ".animation.json"); }
}
