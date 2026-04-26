package com.slfftz.elements.blocks;

import com.slfftz.elements.Elements;
import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.world.tree.MulberryGeneration;
import com.terraformersmc.terraform.sign.TerraformHangingSign;
import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final Block SPODUMENE_ORE = register(
            "spodumene_ore",
            new Block(
                    AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(3.5F, 3.5F)
            )
    );
    public static final Block AMBLYGONITE_ORE = register(
            "amblygonite_ore",
            new Block(
                    AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(3.0F, 3.0F)
            )
    );
    public static final Block LEPIDOLITE_ORE = register(
            "lepidolite_ore", new Block(
                    AbstractBlock.Settings.create()
                    .mapColor(MapColor.DIRT_BROWN)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F,3.5F)
            )
    );
    public static final Block DEEPSLATE_SPODUMENE_ORE = register(
            "deepslate_spodumene_ore", new Block(
                    AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(5.0F, 4.5F)
            )
    );
    public static final Block DEEPSLATE_AMBLYGONITE_ORE = register(
            "deepslate_amblygonite_ore", new Block(
                    AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .instrument(Instrument.BASEDRUM)
                    .requiresTool()
                    .strength(4.5F, 4.5F)
            )
    );
    public static final Block LEPIDOLITE_BLOCK = register(
            "lepidolite_block", new Block(
                    AbstractBlock.Settings.create()
                    .mapColor(MapColor.DULL_PINK)
                    .instrument(Instrument.HARP)
                    .requiresTool()
                    .strength(1.5F, 1.5F)
            )
    );
    public static final Block SPODUMENE_BLOCK = register(
            "spodumene_block", new Block(
                    AbstractBlock.Settings.create()
                    .mapColor(MapColor.PINK)
                    .instrument(Instrument.IRON_XYLOPHONE)
                    .nonOpaque()
                    .strength(4.0F, 3.5F)
            )
    );
    public static final Block AMBLYGONITE_BLOCK = register(
            "amblygonite_block", new Block(
                    AbstractBlock.Settings.create()
                    .mapColor(MapColor.ORANGE)
                    .instrument(Instrument.IRON_XYLOPHONE)
                    .nonOpaque()
                    .strength(3.5F, 3.5F)
            )
    );

    private static final AbstractBlock.Settings WOOD = FabricBlockSettings.copyOf(Blocks.OAK_LOG);
    private static final AbstractBlock.Settings PLANKS = FabricBlockSettings.copyOf(Blocks.OAK_PLANKS);
    private static final AbstractBlock.Settings LEAVES = FabricBlockSettings.copyOf(Blocks.OAK_LEAVES);
    // 原木 / 去皮原木
    public static final Block MULBERRY_LOG = register("mulberry_log", new PillarBlock(WOOD));
    public static final Block STRIPPED_MULBERRY_LOG = register("stripped_mulberry_log", new PillarBlock(WOOD));
    public static final Block MULBERRY_WOOD = register("mulberry_wood", new PillarBlock(WOOD));
    public static final Block STRIPPED_MULBERRY_WOOD = register("stripped_mulberry_wood", new PillarBlock(WOOD));
    // 木板
    public static final Block MULBERRY_PLANKS = register("mulberry_planks", new Block(PLANKS));
    // 楼梯 / 台阶
    public static final Block MULBERRY_STAIRS = register("mulberry_stairs", new StairsBlock(MULBERRY_PLANKS.getDefaultState(), PLANKS));
    public static final Block MULBERRY_SLAB = register("mulberry_slab", new SlabBlock(PLANKS));
    // 栅栏 / 栅栏门
    public static final Block MULBERRY_FENCE = register("mulberry_fence", new FenceBlock(AbstractBlock.Settings.copy(MULBERRY_PLANKS)));
    public static final Block MULBERRY_FENCE_GATE = register("mulberry_fence_gate", new FenceGateBlock(
            AbstractBlock.Settings.copy(MULBERRY_PLANKS),
            WoodType.OAK
    ));
    // 门 / 活板门
    public static final Block MULBERRY_DOOR = register("mulberry_door", new DoorBlock(PLANKS.nonOpaque(), BlockSetType.OAK));
    public static final Block MULBERRY_TRAPDOOR = register("mulberry_trapdoor", new TrapdoorBlock(PLANKS.nonOpaque(), BlockSetType.OAK));
    // 按钮 / 压力板
    public static final Block MULBERRY_BUTTON = register("mulberry_button", new ButtonBlock(PLANKS, BlockSetType.OAK, 30, true));
    public static final Block MULBERRY_PRESSURE_PLATE = register("mulberry_pressure_plate", new PressurePlateBlock(
            PressurePlateBlock.ActivationRule.EVERYTHING,
            PLANKS,
            BlockSetType.OAK
    ));
    // 树叶 / 树苗
    public static final Block MULBERRY_LEAVES = register("mulberry_leaves", new LeavesBlock(LEAVES));
    public static final Block MULBERRY_SAPLING = register("mulberry_sapling", new SaplingBlock(
            new MulberryGeneration(),
            FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
    ));
    // 告示牌 / 墙上的告示牌 / 悬挂式告示牌 / 墙上的悬挂式告示牌
    public static final Identifier MULBERRY_SIGN_TEXTURE = new Identifier(Elements.MOD_ID, "entity/signs/mulberry");
    public static final Identifier MULBERRY_HANGING_SIGN_TEXTURE = new Identifier(Elements.MOD_ID, "entity/signs/hanging/mulberry");
    public static final Identifier MULBERRY_HANGING_SIGN_GUI = new Identifier(Elements.MOD_ID, "textures/gui/hanging_signs/mulberry");

    public static final Block MULBERRY_SIGN = register0("mulberry_sign",
            new TerraformSignBlock(MULBERRY_HANGING_SIGN_TEXTURE, PLANKS));
    public static final Block MULBERRY_WALL_SIGN = register0("mulberry_wall_sign",
            new TerraformWallSignBlock(MULBERRY_SIGN_TEXTURE, PLANKS));
    public static final Block MULBERRY_HANGING_SIGN = register0("mulberry_hanging_sign",
            new TerraformHangingSignBlock(MULBERRY_HANGING_SIGN_TEXTURE, MULBERRY_HANGING_SIGN_GUI, PLANKS));
    public static final Block MULBERRY_WALL_HANGING_SIGN = register0("mulberry_wall_hanging_sign",
            new TerraformWallHangingSignBlock(MULBERRY_HANGING_SIGN_TEXTURE, MULBERRY_HANGING_SIGN_GUI, PLANKS));


    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        Block block_item = register0(id, block);
        ModItems.elements_mod_blocks.add(block_item);
        return block_item;
    }

    public static Block register0(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Elements.MOD_ID, id), block);
    }

    public static void registerBlockItems(String id, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Elements.MOD_ID, id), new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks() {
        // 可剥离注册
        StrippableBlockRegistry.register(MULBERRY_LOG, STRIPPED_MULBERRY_LOG);
        StrippableBlockRegistry.register(MULBERRY_WOOD, STRIPPED_MULBERRY_WOOD);

        // 可燃注册
        FlammableBlockRegistry.getDefaultInstance().add(MULBERRY_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_MULBERRY_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(MULBERRY_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_MULBERRY_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(MULBERRY_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(MULBERRY_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(MULBERRY_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(MULBERRY_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(MULBERRY_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(MULBERRY_LEAVES, 30, 60);
    }

    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return state -> state.get(Properties.LIT) ? litLevel : 0;
    }
}
