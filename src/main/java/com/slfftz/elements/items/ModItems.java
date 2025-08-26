package com.slfftz.elements.items;

import com.slfftz.elements.Elements;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item LITHIUM_INGOT = registerItem("lithium_ingot", new Item(new Item.Settings()));
    public static final Item LITHIUM_ORE_POWDER = registerItem("lithium_ore_powder", new Item(new Item.Settings()));
    public static final Item LEPIDOLITE_SHARD = registerItem("lepidolite_shard", new Item(new Item.Settings()));
    public static final Item LITHIUM_POWDER = registerItem("lithium_powder", new Item(new Item.Settings()));
    public static final Item LITHIUM_BATTERY = registerItem("lithium_battery", new Item(new Item.Settings()));
    public static final Item IMPURITY = registerItem("impurity", new Item(new Item.Settings()));
    public static final Item SPODUMENE = registerItem("spodumene", new Item(new Item.Settings()));
    public static final Item AMBLYGONITE = registerItem("amblygonite", new Item(new Item.Settings()));
    public static final Item LITHIUM_INGOT_BILLET = registerItem("lithium_ingot_billet", new Item(new Item.Settings()));


    public static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), new Identifier(Elements.MOD_ID, id)), item);
    }

    public static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Elements.MOD_ID, id), item);
    }

    public static Item register(String id, Item item) {
        return register(new Identifier(Elements.MOD_ID, id), item);
    }

    public static Item register(Identifier id, Item item) {
        return register(RegistryKey.of(Registries.ITEM.getKey(), id), item);
    }

    public static Item register(RegistryKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    private static void addItemToItemGroup1(FabricItemGroupEntries entries) {

    }


    public static void registerItems() {

    }
}


