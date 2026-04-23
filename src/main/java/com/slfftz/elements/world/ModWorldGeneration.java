package com.slfftz.elements.world;

import com.slfftz.elements.world.ore.ModOreGeneration;
import com.slfftz.elements.world.tree.ModTreeGeneration;

public class ModWorldGeneration {
    public static void register() {
        ModOreGeneration.registerOres();
        ModTreeGeneration.registerTrees();
    }
}