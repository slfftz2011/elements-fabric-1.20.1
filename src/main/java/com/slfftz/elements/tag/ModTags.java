package com.slfftz.elements.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import com.slfftz.elements.Elements;

public class ModTags {
    public static final TagKey<Block> CAULDRON_HEAT_SOURCES = TagKey.of(
            Registries.BLOCK.getKey(),
            new Identifier(Elements.MOD_ID, "cauldron_heat_sources")
    );
}