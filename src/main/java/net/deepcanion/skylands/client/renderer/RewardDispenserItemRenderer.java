package net.deepcanion.skylands.client.renderer;

import java.util.HashMap;
import java.util.Map;
import com.mojang.blaze3d.vertex.PoseStack;
import net.deepcanion.skylands.block.RewardDispenserBlock;
import net.deepcanion.skylands.block.entity.RewardDispenserBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

/** Client-only display instances reuse the authored geometry without a world or payment state. */
public final class RewardDispenserItemRenderer extends BlockEntityWithoutLevelRenderer {
    private final Map<RewardDispenserBlock, RewardDispenserBlockEntity> displays = new HashMap<>();
    private final RewardDispenserRenderer renderer = new RewardDispenserRenderer();

    public RewardDispenserItemRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack pose,
            MultiBufferSource buffers, int light, int overlay) {
        if (stack.getItem() instanceof BlockItem item && item.getBlock() instanceof RewardDispenserBlock block) {
            RewardDispenserBlockEntity display = displays.computeIfAbsent(block,
                b -> new RewardDispenserBlockEntity(BlockPos.ZERO, b.defaultBlockState()));
            renderer.render(display, 0f, pose, buffers, light, overlay);
        }
    }
}
