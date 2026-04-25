package com.slfftz.elements;

import com.slfftz.elements.blocks.ModBlocks;
import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.items.ModItemGroups;
import com.slfftz.elements.world.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Elements implements ModInitializer {
    public static final String MOD_ID = "elements";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerGroups();
        ModWorldGeneration.register();
        LOGGER.info("The elemental world is ready, let's start your adventure!");
    }
}