package com.slfftz.elements.items;

import com.slfftz.elements.Elements;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> ELEMENTS_MOD_ITEMS = register("elements_mod_items");

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Elements.MOD_ID, id));
    }

    public static void registerGroups_() {
        Registry.register(
                Registries.ITEM_GROUP,
                ELEMENTS_MOD_ITEMS,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.elements_mod_items"))
                        .icon(() -> new ItemStack(ModItems.LITHIUM_INGOT))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.LITHIUM_INGOT);
                            entries.add(ModItems.LITHIUM_ORE_POWDER);
                            entries.add(ModItems.LITHIUM_MICA_SHEET);
                            entries.add(ModItems.LITHIUM_POWDER);
                            entries.add(ModItems.LITHIUM_BATTERY);
                            entries.add(ModItems.IMPURITY);
                        }).build());
    }
}
