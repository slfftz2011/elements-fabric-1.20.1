package com.slfftz.elements.datagen;

import com.slfftz.elements.blocks.ModBlockFamilies;
import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

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

        blockStateModelGenerator.registerLog(ModBlocks.MULBERRY_LOG).log(ModBlocks.MULBERRY_LOG).wood(ModBlocks.MULBERRY_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MULBERRY_LOG).log(ModBlocks.STRIPPED_MULBERRY_LOG).wood(ModBlocks.STRIPPED_MULBERRY_WOOD);
        ModBlockFamilies.getFamilies()
                .filter(BlockFamily::shouldGenerateModels)
                .forEach(family ->
                        blockStateModelGenerator.
                                registerCubeAllModelTexturePool(family.getBaseBlock())
                                .family(family));

        blockStateModelGenerator.registerTintableCross(ModBlocks.MULBERRY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MULBERRY_LEAVES);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_MULBERRY_LOG, ModBlocks.MULBERRY_HANGING_SIGN, ModBlocks.MULBERRY_WALL_HANGING_SIGN);
    }

    public Identifier id(Block block) {
        return Registries.BLOCK.getId(block);
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