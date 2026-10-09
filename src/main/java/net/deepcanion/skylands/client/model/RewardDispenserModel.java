package net.deepcanion.skylands.client.model;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.block.entity.RewardDispenserBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
public final class RewardDispenserModel extends GeoModel<RewardDispenserBlockEntity> {
    @Override public ResourceLocation getModelResource(RewardDispenserBlockEntity dispenser) { return SkyLands.id("geo/gambling_machine.geo.json"); }
    @Override public ResourceLocation getTextureResource(RewardDispenserBlockEntity dispenser) { return SkyLands.id(dispenser.kind().texture); }
    @Override public ResourceLocation getAnimationResource(RewardDispenserBlockEntity dispenser) { return SkyLands.id("animations/gambling_machine.animation.json"); }
}
