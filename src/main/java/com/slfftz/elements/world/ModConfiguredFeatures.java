package com.slfftz.elements.world;

import com.slfftz.elements.Elements;
import com.slfftz.elements.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    // 锂辉石矿配置键
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPODUMENE_ORE_KEY = of("spodumene_ore");
    // 锂磷铝石矿配置键
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMBLYGONITE_ORE_KEY = of("amblygonite_ore");
    // 锂云母矿配置键
    public static final RegistryKey<ConfiguredFeature<?, ?>> LEPIDOLITE_ORE_KEY = of("lepidolite_ore");
    // 深层锂辉石矿配置键
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_SPODUMENE_ORE_KEY = of("deepslate_spodumene_ore");
    // 深层锂磷铝石矿配置键
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_AMBLYGONITE_ORE_KEY = of("deepslate_amblygonite_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        // 定义替换规则
        RuleTest stoneReplace = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest graniteReplace = new BlockMatchRuleTest(Blocks.GRANITE);

        ConfiguredFeatures.register(featureRegisterable, SPODUMENE_ORE_KEY, Feature.ORE,
                new OreFeatureConfig(List.of(
                        OreFeatureConfig.createTarget(stoneReplace, ModBlocks.SPODUMENE_ORE.getDefaultState())
                ), 9));

        ConfiguredFeatures.register(featureRegisterable, DEEPSLATE_SPODUMENE_ORE_KEY, Feature.ORE,
                new OreFeatureConfig(List.of(
                        OreFeatureConfig.createTarget(deepslateReplace, ModBlocks.DEEPSLATE_SPODUMENE_ORE.getDefaultState())
                ), 7));

        ConfiguredFeatures.register(featureRegisterable, AMBLYGONITE_ORE_KEY, Feature.ORE,
                new OreFeatureConfig(List.of(
                        OreFeatureConfig.createTarget(stoneReplace, ModBlocks.AMBLYGONITE_ORE.getDefaultState())
                ), 8));

        ConfiguredFeatures.register(featureRegisterable, DEEPSLATE_AMBLYGONITE_ORE_KEY, Feature.ORE,
                new OreFeatureConfig(List.of(
                        OreFeatureConfig.createTarget(deepslateReplace, ModBlocks.DEEPSLATE_AMBLYGONITE_ORE.getDefaultState())
                ), 6));

        ConfiguredFeatures.register(featureRegisterable, LEPIDOLITE_ORE_KEY, Feature.ORE,
                new OreFeatureConfig(List.of(
                        OreFeatureConfig.createTarget(graniteReplace, ModBlocks.LEPIDOLITE_ORE.getDefaultState())
                ), 10));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Elements.MOD_ID, id));
    }
}
