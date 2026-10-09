package net.deepcanion.skylands.client.renderer;
import net.deepcanion.skylands.block.entity.SkyChestBlockEntity;
import net.deepcanion.skylands.client.model.SkyChestModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
public final class SkyChestRenderer extends GeoBlockRenderer<SkyChestBlockEntity> {
    public SkyChestRenderer(BlockEntityRendererProvider.Context context) { super(new SkyChestModel()); }
    @Override public RenderType getRenderType(SkyChestBlockEntity chest, ResourceLocation texture, MultiBufferSource buffers, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(chest));
    }
}
