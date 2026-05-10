package com.slfftz.elements.entities;

import com.slfftz.elements.Elements;
import com.slfftz.elements.blocks.ModBlocks;
import com.slfftz.elements.items.ModItems;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier MULBERRY_BOAT = new Identifier(Elements.MOD_ID, "mulberry_boat");
    public static final Identifier MULBERRY_CHEST_BOAT = new Identifier(Elements.MOD_ID, "mulberry_chest_boat");

    public static final RegistryKey<TerraformBoatType> MULBERRY_BOAT_KEY = TerraformBoatTypeRegistry.createKey(MULBERRY_BOAT);

    public static void registerBoats(){
        TerraformBoatType ICE_ETHER_BOAT_TYPE = new TerraformBoatType.Builder()
                .item(ModItems.MULBERRY_BOAT)
                .chestItem(ModItems.MULBERRY_CHEST_BOAT)
                .planks(ModBlocks.MULBERRY_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, MULBERRY_BOAT_KEY, ICE_ETHER_BOAT_TYPE);
    }
}
