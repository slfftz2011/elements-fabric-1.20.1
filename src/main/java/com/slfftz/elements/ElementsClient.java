package com.slfftz.elements;

import com.slfftz.elements.blocks.ModBlocks;
import com.slfftz.elements.client.renderer.CauldronItemRenderer;
import com.slfftz.elements.entities.ModBoats;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;

public class ElementsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient()
    {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MULBERRY_DOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MULBERRY_TRAPDOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MULBERRY_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MULBERRY_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMBLYGONITE_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPODUMENE_BLOCK, RenderLayer.getTranslucent());

        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> {
                    if (tintIndex == 0) {
                        if (view != null && pos != null) {
                            return BiomeColors.getFoliageColor(view, pos);
                        }
                        return FoliageColors.getDefaultColor();
                    }
                    return -1;
                },
                ModBlocks.MULBERRY_LEAVES
        );
        ColorProviderRegistry.ITEM.register(
                (stack, count) -> 4764952,
                ModBlocks.MULBERRY_LEAVES.asItem()
        );

        TerraformBoatClientHelper.registerModelLayers(ModBoats.MULBERRY_BOAT, false);
        CauldronItemRenderer.init();
    }
}
