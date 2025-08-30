package com.slfftz.elements.datagen;

import com.slfftz.elements.blocks.ModBlocks;
import com.slfftz.elements.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;


public class ModLzhLangProvider extends FabricLanguageProvider {
    public ModLzhLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "lzh");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.LITHIUM_INGOT, "鋰錠");
        translationBuilder.add(ModItems.LITHIUM_ORE_POWDER, "鋰礦末");
        translationBuilder.add(ModItems.LEPIDOLITE_SHARD, "鋰雲母殘片");
        translationBuilder.add(ModItems.LITHIUM_POWDER, "鋰末");
        translationBuilder.add(ModItems.LITHIUM_BATTERY, "陰陽蓄鋰之氣匣");
        translationBuilder.add(ModItems.IMPURITY, "柔面");
        translationBuilder.add(ModItems.SPODUMENE, "鋰輝石");
        translationBuilder.add(ModItems.AMBLYGONITE, "鋰磷鋁石");
        translationBuilder.add(ModItems.LITHIUM_INGOT_BILLET, "毛鋰");

        translationBuilder.add(ModBlocks.SPODUMENE_ORE, "鋰輝石礦");
        translationBuilder.add(ModBlocks.AMBLYGONITE_ORE, "鋰磷鋁石礦");
        translationBuilder.add(ModBlocks.LEPIDOLITE_ORE, "鋰雲母礦");
        translationBuilder.add(ModBlocks.DEEPSLATE_SPODUMENE_ORE, "深鋰輝石礦");
        translationBuilder.add(ModBlocks.DEEPSLATE_AMBLYGONITE_ORE, "深鋰磷鋁石礦");
        translationBuilder.add(ModBlocks.LEPIDOLITE_BLOCK, "鋰雲母塊");
        translationBuilder.add(ModBlocks.SPODUMENE_BLOCK, "鋰輝石塊");
        translationBuilder.add(ModBlocks.AMBLYGONITE_BLOCK, "鋰磷鋁石塊");

        translationBuilder.add("itemGroup.elements_mod_items", "物於元質模組");
        translationBuilder.add("itemGroup.elements_mod_blocks","塊方於元質模組");
    }
}