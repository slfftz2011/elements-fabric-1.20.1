package com.slfftz.elements.blocks;

import com.slfftz.elements.Elements;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block SPODUMENE_ORE = register("spodumene_ore", new Block(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).requiresTool().strength(3.5F, 3.5F)));
    public static final Block AMBLYGONITE_ORE = register("amblygonite_ore", new Block(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).requiresTool().strength(3.0F, 3.0F)));
    public static final Block LEPIDOLITE_ORE = register("lepidolite_ore", new Block(AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).instrument(Instrument.BASEDRUM).requiresTool().strength(1.5F,3.5F)));
    public static final Block DEEPSLATE_SPODUMENE_ORE = register("deepslate_spodumene_ore", new Block(AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).instrument(Instrument.BASEDRUM).requiresTool().strength(5.0F, 4.5F)));
    public static final Block DEEPSLATE_AMBLYGONITE_ORE = register("deepslate_amblygonite_ore", new Block(AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).instrument(Instrument.BASEDRUM).requiresTool().strength(4.5F, 4.5F)));
    public static final Block LEPIDOLITE_BLOCK = register("lepidolite_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.DULL_PINK).instrument(Instrument.HARP).requiresTool().strength(1.5F, 1.5F)));


    public static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Elements.MOD_ID, id), block);
    }

    public static void registerBlockItems(String id, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Elements.MOD_ID, id), new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks() {

    }
}
