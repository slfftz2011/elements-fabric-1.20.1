package com.slfftz.elements.datagen;

import com.slfftz.elements.blocks.ModBlocks;
import com.slfftz.elements.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;


public class ModZhCnLangProvider extends FabricLanguageProvider {
    public ModZhCnLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.LITHIUM_INGOT, "锂锭");
        translationBuilder.add(ModItems.LITHIUM_ORE_POWDER, "锂矿粉");
        translationBuilder.add(ModItems.LEPIDOLITE_SHARD, "锂云母片");
        translationBuilder.add(ModItems.LITHIUM_POWDER, "锂粉");
        translationBuilder.add(ModItems.LITHIUM_BATTERY, "锂电池");
        translationBuilder.add(ModItems.IMPURITY, "杂质");
        translationBuilder.add(ModItems.SPODUMENE, "锂辉石");
        translationBuilder.add(ModItems.AMBLYGONITE, "锂磷铝石");
        translationBuilder.add(ModItems.LITHIUM_INGOT_BILLET, "锂坯");

        translationBuilder.add(ModBlocks.SPODUMENE_ORE, "锂辉石矿");
        translationBuilder.add(ModBlocks.AMBLYGONITE_ORE, "锂磷铝石矿");
        translationBuilder.add(ModBlocks.LEPIDOLITE_ORE, "锂云母矿");
        translationBuilder.add(ModBlocks.DEEPSLATE_SPODUMENE_ORE, "深层锂辉石矿");
        translationBuilder.add(ModBlocks.DEEPSLATE_AMBLYGONITE_ORE, "深层锂磷铝石矿");
        translationBuilder.add(ModBlocks.LEPIDOLITE_BLOCK, "锂云母块");
        translationBuilder.add(ModBlocks.SPODUMENE_BLOCK, "锂辉石块");
        translationBuilder.add(ModBlocks.AMBLYGONITE_BLOCK, "锂磷铝石块");

        translationBuilder.add("itemGroup.elements_mod_items", "元素模组物品");
        translationBuilder.add("itemGroup.elements_mod_blocks","元素模组方块");
    }
}