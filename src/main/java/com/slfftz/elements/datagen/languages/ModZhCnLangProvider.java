package com.slfftz.elements.datagen.languages;

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

        translationBuilder.add(ModBlocks.MULBERRY_BUTTON, "桑木按钮");
        translationBuilder.add(ModBlocks.MULBERRY_DOOR, "桑木门");
        translationBuilder.add(ModBlocks.MULBERRY_FENCE, "桑木栅栏");
        translationBuilder.add(ModBlocks.MULBERRY_FENCE_GATE, "桑木栅栏门");
        translationBuilder.add(ModBlocks.MULBERRY_LEAVES, "桑树树叶");
        translationBuilder.add(ModBlocks.MULBERRY_LOG, "桑木原木");
        translationBuilder.add(ModBlocks.MULBERRY_PLANKS, "桑木木板");
        translationBuilder.add(ModBlocks.MULBERRY_PRESSURE_PLATE, "桑木压力板");
        translationBuilder.add(ModBlocks.MULBERRY_SAPLING, "桑树树苗");
        translationBuilder.add(ModBlocks.MULBERRY_SLAB, "桑木台阶");
        translationBuilder.add(ModBlocks.MULBERRY_STAIRS, "桑木楼梯");
        translationBuilder.add(ModBlocks.MULBERRY_TRAPDOOR, "桑木活板门");
        translationBuilder.add(ModBlocks.MULBERRY_WOOD, "桑木");
        translationBuilder.add(ModBlocks.STRIPPED_MULBERRY_LOG, "去皮桑木原木");
        translationBuilder.add(ModBlocks.STRIPPED_MULBERRY_WOOD, "去皮桑木");

        translationBuilder.add("itemGroup.elements_mod_items", "元素模组物品");
        translationBuilder.add("itemGroup.elements_mod_blocks","元素模组方块");
    }
}