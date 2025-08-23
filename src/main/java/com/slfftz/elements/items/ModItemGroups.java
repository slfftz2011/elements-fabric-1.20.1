package com.slfftz.elements.items;

import com.slfftz.elements.Elements;
import com.slfftz.elements.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Elements.MOD_ID, id));
    }

    public static final ItemGroup ELEMENTS_MOD_ITEMS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(Elements.MOD_ID, "elements_mod_items"),
            ItemGroup.create(null, -1)
                    .displayName(Text.translatable("itemGroup.elements_mod_items"))
                    .icon(() -> new ItemStack(ModItems.LITHIUM_INGOT))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.LITHIUM_INGOT);
                        entries.add(ModItems.LITHIUM_ORE_POWDER);
                        entries.add(ModItems.LEPIDOLITE_SHARD);
                        entries.add(ModItems.LITHIUM_POWDER);
                        entries.add(ModItems.LITHIUM_BATTERY);
                        entries.add(ModItems.IMPURITY);
                        entries.add(ModItems.SPODUMENE);
                        entries.add(ModItems.AMBLYGONITE);
                    }).build());

    public static final ItemGroup ELEMENTS_MOD_BLOCKS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(Elements.MOD_ID, "elements_mod_blocks"),
            ItemGroup.create(null, -1)
                    .displayName(Text.translatable("itemGroup.elements_mod_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.LEPIDOLITE_BLOCK))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SPODUMENE_ORE);
                        entries.add(ModBlocks.AMBLYGONITE_ORE);
                        entries.add(ModBlocks.LEPIDOLITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SPODUMENE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_AMBLYGONITE_ORE);
                        entries.add(ModBlocks.LEPIDOLITE_BLOCK);
                    }).build());
    public static void registerGroups() {

    }
}
