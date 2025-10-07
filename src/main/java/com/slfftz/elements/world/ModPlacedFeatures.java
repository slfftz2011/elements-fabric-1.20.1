package com.slfftz.elements.world;

import com.slfftz.elements.Elements;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> SPODUMENE_ORE_PLACED_KEY = of("spodumene_ore_placed");
    public static final RegistryKey<PlacedFeature> AMBLYGONITE_ORE_PLACED_KEY = of("amblygonite_ore_placed");
    public static final RegistryKey<PlacedFeature> LEPIDOLITE_ORE_PLACED_KEY = of("lepidolite_ore_placed");
    public static final RegistryKey<PlacedFeature> DEEPSLATE_SPODUMENE_ORE_PLACED_KEY = of("deepslate_spodumene_ore_placed");
    public static final RegistryKey<PlacedFeature> DEEPSLATE_AMBLYGONITE_ORE_PLACED_KEY = of("deepslate_amblygonite_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // 为每种矿石配置放置规则
        PlacedFeatures.register(featureRegisterable, SPODUMENE_ORE_PLACED_KEY,
                registryEntryLookup.getOrThrow(ModConfiguredFeatures.SPODUMENE_ORE_KEY),
                modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(4), YOffset.fixed(64)))); // 生成高度范围

        PlacedFeatures.register(featureRegisterable, AMBLYGONITE_ORE_PLACED_KEY,
                registryEntryLookup.getOrThrow(ModConfiguredFeatures.AMBLYGONITE_ORE_KEY),
                modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(4), YOffset.fixed(48))));

        PlacedFeatures.register(featureRegisterable, LEPIDOLITE_ORE_PLACED_KEY,
                registryEntryLookup.getOrThrow(ModConfiguredFeatures.LEPIDOLITE_ORE_KEY),
                modifiersWithCount(12,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-12), YOffset.fixed(80))));

        // 深层矿石通常生成在更低的位置
        PlacedFeatures.register(featureRegisterable, DEEPSLATE_SPODUMENE_ORE_PLACED_KEY,
                registryEntryLookup.getOrThrow(ModConfiguredFeatures.DEEPSLATE_SPODUMENE_ORE_KEY),
                modifiersWithCount(7,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-50), YOffset.fixed(-4))));

        PlacedFeatures.register(featureRegisterable, DEEPSLATE_AMBLYGONITE_ORE_PLACED_KEY,
                registryEntryLookup.getOrThrow(ModConfiguredFeatures.DEEPSLATE_AMBLYGONITE_ORE_KEY),
                modifiersWithCount(6,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-50), YOffset.fixed(-4))));

    }

    public static RegistryKey<PlacedFeature> of(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Elements.MOD_ID, id));
    }

    // 通用放置修饰符组合
    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    // 带数量的放置修饰符
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    // 带稀有度的放置修饰符
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
