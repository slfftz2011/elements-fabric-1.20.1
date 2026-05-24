package com.slfftz.elements.datagen;

import com.slfftz.elements.Elements;
import com.slfftz.elements.blocks.ModBlockFamilies;
import com.slfftz.elements.blocks.customs.MulberryLeavesBlock;
import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.blocks.ModBlocks;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    private static final TextureKey BASE_KEY = TextureKey.of("base");
    private static final TextureKey OVERLAY_KEY = TextureKey.of("overlay");

    private static final Model MULBERRY_LEAVES_MODEL = new Model(
            Optional.ofNullable(Identifier.of(Elements.MOD_ID, "block/mulberry_leaves_template")),
            Optional.empty(),
            BASE_KEY,
            OVERLAY_KEY
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

        registerMulberryLeaves(blockStateModelGenerator);
    }


    public void registerMulberryLeaves(BlockStateModelGenerator blockStateModelGenerator) {
        Int2ObjectMap<Identifier> int2ObjectMap = new Int2ObjectOpenHashMap<>();
        Identifier baseTexture = Identifier.of(Elements.MOD_ID, "block/mulberry_leaves/gray");

        BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap
                .create(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE)
                .register(integer -> {
                    int i = integer;
                    Identifier identifier = int2ObjectMap.computeIfAbsent(i, j -> {
                        TextureMap textureMap = new TextureMap();
                        textureMap.put(BASE_KEY, baseTexture);
                        textureMap.put(OVERLAY_KEY,
                                Identifier.of(Elements.MOD_ID, "block/mulberry_leaves/stage_" + j)
                        );
                        return MULBERRY_LEAVES_MODEL.upload(
                                ModBlocks.MULBERRY_LEAVES,
                                "_stage_" + j,
                                textureMap,
                                blockStateModelGenerator.modelCollector
                        );
                    });
                    return BlockStateVariant.create().put(VariantSettings.MODEL, identifier);
                });

        Identifier itemModelId = int2ObjectMap.get(0);
        if (itemModelId != null) {
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.MULBERRY_LEAVES, itemModelId);
        }

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.MULBERRY_LEAVES)
                        .coordinate(blockStateVariantMap)
        );
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