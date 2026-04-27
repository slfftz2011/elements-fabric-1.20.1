package com.slfftz.elements.datagen.languages;

import com.slfftz.elements.blocks.ModBlocks;
import com.slfftz.elements.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;


public class ModEnUsLangProvider extends FabricLanguageProvider {
    public ModEnUsLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.LITHIUM_INGOT, "Lithium Ingot");
        translationBuilder.add(ModItems.LITHIUM_ORE_POWDER, "Lithium Ore Powder");
        translationBuilder.add(ModItems.LEPIDOLITE_SHARD, "Lepidolite Shard");
        translationBuilder.add(ModItems.LITHIUM_POWDER, "Lithium Powder");
        translationBuilder.add(ModItems.LITHIUM_BATTERY, "Lithium Battery");
        translationBuilder.add(ModItems.IMPURITY, "Impurity");
        translationBuilder.add(ModItems.SPODUMENE, "Spodumene");
        translationBuilder.add(ModItems.AMBLYGONITE, "Amblygonite");
        translationBuilder.add(ModItems.LITHIUM_INGOT_BILLET, "Lithium Billet");

        translationBuilder.add(ModBlocks.SPODUMENE_ORE, "Spodumene Ore");
        translationBuilder.add(ModBlocks.AMBLYGONITE_ORE, "Amblygonite Ore");
        translationBuilder.add(ModBlocks.LEPIDOLITE_ORE, "Lepidolite Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_SPODUMENE_ORE, "Deepslate Spodumene Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_AMBLYGONITE_ORE, "Deepslate Amblygonite Ore");
        translationBuilder.add(ModBlocks.LEPIDOLITE_BLOCK, "Block of Lepidolite");
        translationBuilder.add(ModBlocks.SPODUMENE_BLOCK, "Block of Spodumene");
        translationBuilder.add(ModBlocks.AMBLYGONITE_BLOCK, "Block of Amblygonite");

        translationBuilder.add(ModBlocks.MULBERRY_BUTTON, "Mulberry Button");
        translationBuilder.add(ModBlocks.MULBERRY_DOOR, "Mulberry Door");
        translationBuilder.add(ModBlocks.MULBERRY_FENCE, "Mulberry Fence");
        translationBuilder.add(ModBlocks.MULBERRY_FENCE_GATE, "Mulberry Fence Gate");
        translationBuilder.add(ModBlocks.MULBERRY_LEAVES, "Mulberry Leaves");
        translationBuilder.add(ModBlocks.MULBERRY_LOG, "Mulberry Log");
        translationBuilder.add(ModBlocks.MULBERRY_PLANKS, "Mulberry Planks");
        translationBuilder.add(ModBlocks.MULBERRY_PRESSURE_PLATE, "Mulberry Pressure Plate");
        translationBuilder.add(ModBlocks.MULBERRY_SAPLING, "Mulberry Sapling");
        translationBuilder.add(ModBlocks.MULBERRY_SLAB, "Mulberry Slab");
        translationBuilder.add(ModBlocks.MULBERRY_STAIRS, "Mulberry Stairs");
        translationBuilder.add(ModBlocks.MULBERRY_TRAPDOOR, "Mulberry Trapdoor");
        translationBuilder.add(ModBlocks.MULBERRY_WOOD, "Mulberry Wood");
        translationBuilder.add(ModBlocks.STRIPPED_MULBERRY_LOG, "Stripped Mulberry Log");
        translationBuilder.add(ModBlocks.STRIPPED_MULBERRY_WOOD, "Stripped Mulberry Wood");
        translationBuilder.add("block.elements.mulberry_sign", "Mulberry Sign");
        translationBuilder.add("block.elements.mulberry_hanging_sign", "Mulberry Hanging Sign");
        translationBuilder.add("block.elements.mulberry_wall_sign", "Mulberry Wall Sign");
        translationBuilder.add("block.elements.mulberry_wall_hanging_sign", "Mulberry Wall Hanging Sign");


        translationBuilder.add("itemGroup.elements_mod_items", "Elements Mod Items");
        translationBuilder.add("itemGroup.elements_mod_blocks","Elements Mod Blocks");
    }
}