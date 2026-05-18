package com.slfftz.elements.datagen;

import com.slfftz.elements.Elements;
import com.slfftz.elements.blocks.ModBlockFamilies;
import com.slfftz.elements.blocks.MulberryLeavesBlock;
import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    public static final Model LEAVES_MODEL = new Model(
            Optional.ofNullable(Identifier.of("minecraft","block/leaves")),
            Optional.empty(),
            TextureKey.ALL
    );

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
        blockStateModelGenerator.registerTintableCross(ModBlocks.MULBERRY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_MULBERRY_LOG, ModBlocks.MULBERRY_HANGING_SIGN, ModBlocks.MULBERRY_WALL_HANGING_SIGN);

        ModBlockFamilies.getFamilies()
                .filter(BlockFamily::shouldGenerateModels)
                .forEach(family ->
                        blockStateModelGenerator.
                                registerCubeAllModelTexturePool(family.getBaseBlock())
                                .family(family));

        Identifier mulberryLeavesModelId = LEAVES_MODEL.upload(
                ModBlocks.MULBERRY_LEAVES,
                TextureMap.all(Identifier.of(Elements.MOD_ID, "block/mulberry_leaves")),
                blockStateModelGenerator.modelCollector
        );
        Identifier mulberryLeavesModelId1 = ModelIds.getBlockSubModelId(ModBlocks.MULBERRY_LEAVES, "_stage_1");
        Identifier mulberryLeavesModelId2 = ModelIds.getBlockSubModelId(ModBlocks.MULBERRY_LEAVES, "_stage_2");
        Identifier mulberryLeavesModelId3 = ModelIds.getBlockSubModelId(ModBlocks.MULBERRY_LEAVES, "_stage_3");
        Identifier mulberryLeavesModelId4 = ModelIds.getBlockSubModelId(ModBlocks.MULBERRY_LEAVES, "_stage_4");
        Identifier mulberryLeavesModelId5 = ModelIds.getBlockSubModelId(ModBlocks.MULBERRY_LEAVES, "_stage_5");
        Identifier mulberryLeavesModelId6 = ModelIds.getBlockSubModelId(ModBlocks.MULBERRY_LEAVES, "_stage_6");
        Identifier mulberryLeavesModelId7 = ModelIds.getBlockSubModelId(ModBlocks.MULBERRY_LEAVES, "_stage_7");
        Identifier mulberryLeavesModelId8 = ModelIds.getBlockSubModelId(ModBlocks.MULBERRY_LEAVES, "_stage_8");
        Identifier mulberryLeavesModelId9 = ModelIds.getBlockSubModelId(ModBlocks.MULBERRY_LEAVES, "_stage_9");
        blockStateModelGenerator.blockStateCollector
                .accept(
                        MultipartBlockStateSupplier.create(ModBlocks.MULBERRY_LEAVES)
                                .with(BlockStateVariant.create().put(VariantSettings.MODEL, mulberryLeavesModelId))
                                .with(
                                        When.create().set(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 1),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, mulberryLeavesModelId1)
                                )
                                .with(
                                        When.create().set(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 2),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, mulberryLeavesModelId2)
                                )
                                .with(
                                        When.create().set(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 3),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, mulberryLeavesModelId3)
                                )
                                .with(
                                        When.create().set(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 4),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, mulberryLeavesModelId4)
                                )
                                .with(
                                        When.create().set(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 5),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, mulberryLeavesModelId5)
                                )
                                .with(
                                        When.create().set(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 6),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, mulberryLeavesModelId6)
                                ).with(
                                        When.create().set(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 7),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, mulberryLeavesModelId7)
                                ).with(
                                        When.create().set(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 8),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, mulberryLeavesModelId8)
                                ).with(
                                        When.create().set(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 9),
                                        BlockStateVariant.create().put(VariantSettings.MODEL, mulberryLeavesModelId9)
                                )
                );
        blockStateModelGenerator.registerParentedItemModel(ModBlocks.MULBERRY_LEAVES, mulberryLeavesModelId);
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

        itemModelGenerator.register(ModItems.MULBERRY_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MULBERRY_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MULBERRY, Models.GENERATED);
    }
}