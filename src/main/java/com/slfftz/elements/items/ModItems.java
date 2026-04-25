package com.slfftz.elements.items;

import com.slfftz.elements.Elements;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static List<Item> elements_mod_items = new ArrayList<>();
    public static List<Block> elements_mod_blocks = new ArrayList<>();

    public static final Item LITHIUM_INGOT = registerItem("lithium_ingot");
    public static final Item LITHIUM_ORE_POWDER = registerItem("lithium_ore_powder");
    public static final Item LEPIDOLITE_SHARD = registerItem("lepidolite_shard");
    public static final Item LITHIUM_POWDER = registerItem("lithium_powder");
    public static final Item LITHIUM_BATTERY = registerItem("lithium_battery");
    public static final Item IMPURITY = registerItem("impurity");
    public static final Item SPODUMENE = registerItem("spodumene");
    public static final Item AMBLYGONITE = registerItem("amblygonite");
    public static final Item LITHIUM_INGOT_BILLET = registerItem("lithium_ingot_billet");



    public static Item registerItem(String id) {
        Item item = registerItem(id, new Item.Settings());
        elements_mod_items.add(item);
        return item;
    }

    public static Item registerItem(String id, Item.Settings settings) {
        return registerItem(id, new Item(settings));
    }

    public static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Elements.MOD_ID, id), item);
    }


    public static void registerModItems() {

    }
}


