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

    public static final RegistryKey<ItemGroup> ELEMENTS_MOD_ITEMS = register("elements_mod_items");
    public static final RegistryKey<ItemGroup> ELEMENTS_MOD_BLOCKS = register("elements_mod_blocks");

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Elements.MOD_ID, id));
    }

    public static void registerGroups() {
        Registry.register(
                Registries.ITEM_GROUP,
                ELEMENTS_MOD_ITEMS,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
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
        Registry.register(
                Registries.ITEM_GROUP,
                ELEMENTS_MOD_BLOCKS,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.elements_mod_blocks"))
                        .icon(() -> new ItemStack(ModItems.LITHIUM_INGOT))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.SPODUMENE_ORE);
                            entries.add(ModBlocks.AMBLYGONITE_ORE);
                            entries.add(ModBlocks.LEPIDOLITE_ORE);
                            entries.add(ModBlocks.DEEPSLATE_SPODUMENE_ORE);
                            entries.add(ModBlocks.DEEPSLATE_AMBLYGONITE_ORE);
                            entries.add(ModBlocks.LEPIDOLITE_BLOCK);
                        }).build());
    }
}
