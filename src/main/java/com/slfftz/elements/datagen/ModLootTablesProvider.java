package com.slfftz.elements.datagen;

import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

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
    }

    public LootTable.Builder genericOreDrops(Block drop, Item item, float min, float max) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}