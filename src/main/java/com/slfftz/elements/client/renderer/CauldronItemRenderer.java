package com.slfftz.elements.client.renderer;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.render.model.BakedModel;
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
            var matrixStack = context.matrixStack();
            var buffer = context.consumers();
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

        var itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        for (int i = 0; i < renderLimit; i++) {
            matrixStack.push();

            matrixStack.translate(pos.getX() + 0.5, pos.getY() + yBase, pos.getZ() + 0.5);

            double angle = (i * 90) + (pos.hashCode() * 37 % 360);
            double radius = 0.15;
            matrixStack.translate(Math.cos(Math.toRadians(angle)) * radius, 0,
                    Math.sin(Math.toRadians(angle)) * radius);

            float angleX = 45f * (1 - progress);
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(angleX));
            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(
                    (pos.hashCode() * 37 + i * 101) % 360
            ));

            boolean isBlock = itemRenderer.getModel(stack, world, null, 0).hasDepth();
            float scale = isBlock ? 0.5f : 0.4f;
            matrixStack.scale(scale, scale, scale);

            int light = world.getLightLevel(pos);

            BakedModel model = itemRenderer.getModel(stack, world, null, 0);
            itemRenderer.renderItem(stack, ModelTransformationMode.FIXED, false, matrixStack, buffer, light, 0, model);

            matrixStack.pop();
        }
    }
}