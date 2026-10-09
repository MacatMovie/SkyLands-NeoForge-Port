package net.deepcanion.skylands.client.renderer;
import net.deepcanion.skylands.block.entity.RewardDispenserBlockEntity;
import net.deepcanion.skylands.client.model.RewardDispenserModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.*;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
public final class RewardDispenserRenderer extends GeoBlockRenderer<RewardDispenserBlockEntity> {
    public RewardDispenserRenderer(BlockEntityRendererProvider.Context context) { this(); }
    public RewardDispenserRenderer() { super(new RewardDispenserModel()); }
    @Override public RenderType getRenderType(RewardDispenserBlockEntity dispenser, ResourceLocation texture, MultiBufferSource buffers, float partialTick) { return RenderType.entityTranslucent(getTextureLocation(dispenser)); }
}
