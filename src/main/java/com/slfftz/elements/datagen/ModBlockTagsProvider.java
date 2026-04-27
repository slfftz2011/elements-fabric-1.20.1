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

        //getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);

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

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MULBERRY_LOG)
                .add(ModBlocks.MULBERRY_WOOD)
                .add(ModBlocks.STRIPPED_MULBERRY_LOG)
                .add(ModBlocks.STRIPPED_MULBERRY_WOOD);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.MULBERRY_LOG)
                .add(ModBlocks.MULBERRY_WOOD)
                .add(ModBlocks.STRIPPED_MULBERRY_LOG)
                .add(ModBlocks.STRIPPED_MULBERRY_WOOD);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.MULBERRY_PLANKS);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.MULBERRY_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.MULBERRY_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.MULBERRY_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.MULBERRY_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.MULBERRY_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.MULBERRY_STAIRS);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.MULBERRY_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.MULBERRY_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.SIGNS)
                .add(ModBlocks.MULBERRY_SIGN)
                .add(ModBlocks.MULBERRY_WALL_SIGN);
        getOrCreateTagBuilder(BlockTags.ALL_SIGNS)
                .add(ModBlocks.MULBERRY_SIGN)
                .add(ModBlocks.MULBERRY_WALL_SIGN);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.MULBERRY_SAPLING);

        getOrCreateTagBuilder(BlockTags.ALL_HANGING_SIGNS)
                .add(ModBlocks.MULBERRY_HANGING_SIGN)
                .add(ModBlocks.MULBERRY_WALL_HANGING_SIGN);
    }
}