package com.slfftz.elements.client.renderer;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.ItemRenderer;
import net.minecraft.client.render.item.ItemRenderContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.entity.BlockEntity;
import com.slfftz.elements.blocks.entity.ModCauldronBlockEntity;
import com.slfftz.elements.component.CauldronDataComponent;
import com.slfftz.elements.component.ModComponents;
import com.slfftz.elements.items.ModItems;

public class CauldronItemRenderer {
    public static void init() {
        WorldRenderEvents.AFTER_ENTITIES.register(context -> {
            var camera = context.camera();
            var matrixStack = context.matrixStack();  // MatrixStack
            var buffer = context.consumers();         // VertexConsumerProvider
            var world = context.world();

            BlockPos center = camera.getBlockPos();
            int radius = 8;
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    for (int y = -4; y <= 4; y++) {
                        BlockPos pos = center.add(x, y, z);
                        BlockState state = world.getBlockState(pos);
                        if (state.isOf(Blocks.WATER_CAULDRON) &&
                                state.get(LeveledCauldronBlock.LEVEL) > 0) {
                            BlockEntity be = world.getBlockEntity(pos);
                            if (be instanceof ModCauldronBlockEntity) {
                                var comp = ModComponents.CAULDRON_DATA.getNullable(be);
                                if (comp != null && !comp.getStoredItem().isEmpty()) {
                                    renderItem(world, pos, comp, matrixStack, buffer, context.tickDelta());
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    private static void renderItem(World world, BlockPos pos, CauldronDataComponent comp,
                                   MatrixStack matrixStack, VertexConsumerProvider buffer, float partialTick) {
        var stack = comp.getStoredItem();
        if (stack.isEmpty()) return;

        int count = (stack.getItem() == ModItems.COCOON) ? comp.getCocoonCount() : stack.getCount();
        int renderLimit = Math.min(count, 4);
        float progress = Math.min(1f, comp.getProcessTime() / 800f);
        float yBase = 0.3f - progress * 0.15f;

        var itemRenderer = Minecraft.getInstance().getItemRenderer();

        for (int i = 0; i < renderLimit; i++) {
            matrixStack.push();

            // 移到炼药锅中心
            matrixStack.translate(pos.getX() + 0.5, pos.getY() + yBase, pos.getZ() + 0.5);

            // 在水平面上分散
            double angle = (i * 90) + (pos.hashCode() * 37 % 360);
            double radius = 0.15;
            matrixStack.translate(Math.cos(Math.toRadians(angle)) * radius, 0,
                    Math.sin(Math.toRadians(angle)) * radius);

            // ✅ 使用 RotationAxis 进行旋转（Yarn 映射）
            float angleX = 45f * (1 - progress);
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(angleX));
            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(
                    (pos.hashCode() * 37 + i * 101) % 360
            ));

            // 缩放
            boolean isBlock = itemRenderer.getModel(stack, world, null, 0).hasDepth();
            float scale = isBlock ? 0.5f : 0.4f;
            matrixStack.scale(scale, scale, scale);

            // 获取光照
            int light = world.getLightLevel(pos);

            // 渲染物品
            itemRenderer.renderItem(stack, ItemRenderContext.FIXED, light, 0,
                    matrixStack, buffer, world, 0);

            matrixStack.pop();
        }
    }
}