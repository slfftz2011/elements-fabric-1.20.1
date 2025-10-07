package com.slfftz.elements.world;

import com.slfftz.elements.world.ore.ModOreGeneration;

public class ModWorldGeneration {
    public static void register() {
        ModOreGeneration.registerOres();
    }
}