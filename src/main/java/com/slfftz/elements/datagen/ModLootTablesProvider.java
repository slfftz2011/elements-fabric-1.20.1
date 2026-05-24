package com.slfftz.elements.datagen;

import com.slfftz.elements.blocks.customs.MulberryLeavesBlock;
import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.blocks.ModBlocks;
import com.slfftz.elements.loot.SilkwormStageLootFunction;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTablesProvider extends FabricBlockLootTableProvider {
    public ModLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LEPIDOLITE_BLOCK);
        addDrop(ModBlocks.SPODUMENE_BLOCK);
        addDrop(ModBlocks.AMBLYGONITE_BLOCK);

        addDrop(ModBlocks.SPODUMENE_ORE, genericOreDrops(ModBlocks.SPODUMENE_ORE, ModItems.SPODUMENE, 2.0f, 5.0f));
        addDrop(ModBlocks.AMBLYGONITE_ORE, genericOreDrops(ModBlocks.AMBLYGONITE_ORE, ModItems.AMBLYGONITE, 2.0f, 5.0f));
        addDrop(ModBlocks.LEPIDOLITE_ORE, genericOreDrops(ModBlocks.LEPIDOLITE_ORE, ModItems.LEPIDOLITE_SHARD, 2.0f, 5.0f));
        addDrop(ModBlocks.DEEPSLATE_SPODUMENE_ORE, genericOreDrops(ModBlocks.DEEPSLATE_SPODUMENE_ORE, ModItems.SPODUMENE, 2.0f, 5.0f));
        addDrop(ModBlocks.DEEPSLATE_AMBLYGONITE_ORE, genericOreDrops(ModBlocks.DEEPSLATE_AMBLYGONITE_ORE, ModItems.AMBLYGONITE, 2.0f, 5.0f));

        addDrop(ModBlocks.MULBERRY_LOG);
        addDrop(ModBlocks.MULBERRY_WOOD);
        addDrop(ModBlocks.STRIPPED_MULBERRY_LOG);
        addDrop(ModBlocks.STRIPPED_MULBERRY_WOOD);
        addDrop(ModBlocks.MULBERRY_PLANKS);
        addDrop(ModBlocks.MULBERRY_SLAB, slabDrops(ModBlocks.MULBERRY_SLAB));
        addDrop(ModBlocks.MULBERRY_STAIRS);
        addDrop(ModBlocks.MULBERRY_FENCE);
        addDrop(ModBlocks.MULBERRY_FENCE_GATE);
        addDrop(ModBlocks.MULBERRY_DOOR, doorDrops(ModBlocks.MULBERRY_DOOR));
        addDrop(ModBlocks.MULBERRY_TRAPDOOR);
        addDrop(ModBlocks.MULBERRY_BUTTON);
        addDrop(ModBlocks.MULBERRY_PRESSURE_PLATE);
        addDrop(ModBlocks.MULBERRY_SAPLING);
        addDrop(ModBlocks.MULBERRY_LEAVES, mulberryLeavesDrops());
        addDrop(ModBlocks.MULBERRY_SIGN);
        addDrop(ModBlocks.MULBERRY_HANGING_SIGN);
    }

    public LootTable.Builder genericOreDrops(Block drop, Item item, float min, float max) {
        return dropsWithSilkTouch(
                drop,
                this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
    public LootTable.Builder bearingLeavesDrops(Block leaves, Block drop, float... chance) {
        return this.leavesDrops(leaves, drop, chance)
                .pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
                                .with(
                                        ((LeafEntry.Builder<?>)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(ModItems.MULBERRY)))
                                                .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.02F, 0.04F, 0.06F, 0.1F, 0.3F))
                                )
                );
    }
    public LootTable.Builder mulberryLeavesDrops() {
        LootCondition.Builder STAGE_1 = BlockStatePropertyLootCondition.builder(ModBlocks.MULBERRY_LEAVES)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 1));
        LootCondition.Builder STAGE_2 = BlockStatePropertyLootCondition.builder(ModBlocks.MULBERRY_LEAVES)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 2));
        LootCondition.Builder STAGE_3 = BlockStatePropertyLootCondition.builder(ModBlocks.MULBERRY_LEAVES)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 3));

        LootCondition.Builder STAGE_4 = BlockStatePropertyLootCondition.builder(ModBlocks.MULBERRY_LEAVES)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 4));
        LootCondition.Builder STAGE_5 = BlockStatePropertyLootCondition.builder(ModBlocks.MULBERRY_LEAVES)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 5));
        LootCondition.Builder STAGE_6 = BlockStatePropertyLootCondition.builder(ModBlocks.MULBERRY_LEAVES)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 6));

        LootCondition.Builder STAGE_8 = BlockStatePropertyLootCondition.builder(ModBlocks.MULBERRY_LEAVES)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(MulberryLeavesBlock.SILKWORM_GROWTH_STAGE, 8));

        LootCondition.Builder WHEN_STAGE_1_3 = (STAGE_1).or(STAGE_2).or(STAGE_3);
        LootCondition.Builder WHEN_STAGE_4_6 = (STAGE_4).or(STAGE_5).or(STAGE_6);

        return this.bearingLeavesDrops(ModBlocks.MULBERRY_LEAVES, ModBlocks.MULBERRY_SAPLING,
                        0.1F, 0.123F, 0.166666667F, 0.2F)
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WHEN_STAGE_1_3)
                        .with(this.addSurvivesExplosionCondition(ModBlocks.MULBERRY_LEAVES,
                                        ItemEntry.builder(ModItems.SILKWORM_EGGS))
                                .apply(SilkwormStageLootFunction.builder())))
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(WHEN_STAGE_4_6)
                        .with(this.addSurvivesExplosionCondition(ModBlocks.MULBERRY_LEAVES,
                                        ItemEntry.builder(ModItems.SILKWORM))
                                .apply(SilkwormStageLootFunction.builder())))
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .conditionally(STAGE_8)
                        .with(this.addSurvivesExplosionCondition(ModBlocks.MULBERRY_LEAVES,
                                        ItemEntry.builder(ModItems.COCOON))
                                .apply(SilkwormStageLootFunction.builder())));
    }
}