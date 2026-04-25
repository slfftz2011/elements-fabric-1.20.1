package com.slfftz.elements.items;

import com.slfftz.elements.Elements;
import com.slfftz.elements.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.*;
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
                        for (Item entry : ModItems.elements_mod_items) {
                            entries.add(entry);
                        }
                    }).build());

    public static final ItemGroup ELEMENTS_MOD_BLOCKS = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier(Elements.MOD_ID, "elements_mod_blocks"),
            ItemGroup.create(null, -1)
                    .displayName(Text.translatable("itemGroup.elements_mod_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.LEPIDOLITE_BLOCK))
                    .entries((displayContext, entries) -> {
                        for (Block entry : ModItems.elements_mod_blocks) {
                            entries.add(entry);
                        }
                    }).build());

    public static void registerGroups() {

    }
}
