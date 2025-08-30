package com.slfftz.elements.datagen;

import com.slfftz.elements.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SPODUMENE_ORE)
                .add(ModBlocks.AMBLYGONITE_ORE)
                .add(ModBlocks.LEPIDOLITE_ORE)
                .add(ModBlocks.DEEPSLATE_SPODUMENE_ORE)
                .add(ModBlocks.DEEPSLATE_AMBLYGONITE_ORE)
                .add(ModBlocks.LEPIDOLITE_BLOCK)
                .add(ModBlocks.SPODUMENE_BLOCK)
                .add(ModBlocks.AMBLYGONITE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SPODUMENE_ORE)
                .add(ModBlocks.AMBLYGONITE_ORE)
                .add(ModBlocks.DEEPSLATE_SPODUMENE_ORE)
                .add(ModBlocks.DEEPSLATE_AMBLYGONITE_ORE)
                .add(ModBlocks.SPODUMENE_BLOCK)
                .add(ModBlocks.AMBLYGONITE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.LEPIDOLITE_ORE)
                .add(ModBlocks.LEPIDOLITE_BLOCK);
    }
}