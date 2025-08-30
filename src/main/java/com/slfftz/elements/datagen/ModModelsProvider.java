package com.slfftz.elements.datagen;

import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPODUMENE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMBLYGONITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEPIDOLITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SPODUMENE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_AMBLYGONITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEPIDOLITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPODUMENE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMBLYGONITE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LITHIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.LITHIUM_ORE_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEPIDOLITE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.LITHIUM_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.LITHIUM_BATTERY, Models.GENERATED);
        itemModelGenerator.register(ModItems.IMPURITY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPODUMENE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMBLYGONITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LITHIUM_INGOT_BILLET, Models.GENERATED);
    }
}