package com.slfftz.elements.datagen;

import com.slfftz.elements.blocks.ModBlocks;
import com.slfftz.elements.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.MULBERRY_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(ModBlocks.MULBERRY_LOG.asItem())
                .add(ModBlocks.STRIPPED_MULBERRY_LOG.asItem())
                .add(ModBlocks.MULBERRY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MULBERRY_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MULBERRY_LOG.asItem())
                .add(ModBlocks.STRIPPED_MULBERRY_LOG.asItem())
                .add(ModBlocks.MULBERRY_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MULBERRY_WOOD.asItem());
    }
}