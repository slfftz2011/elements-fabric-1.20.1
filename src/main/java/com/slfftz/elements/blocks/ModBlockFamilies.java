package com.slfftz.elements.blocks;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class ModBlockFamilies {
    private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.<Block, BlockFamily>newHashMap();

    public static final BlockFamily MULBERRY = register(ModBlocks.MULBERRY_PLANKS)
            .stairs(ModBlocks.MULBERRY_STAIRS)
            .slab(ModBlocks.MULBERRY_SLAB)
            .button(ModBlocks.MULBERRY_BUTTON)
            .pressurePlate(ModBlocks.MULBERRY_PRESSURE_PLATE)
            .fence(ModBlocks.MULBERRY_FENCE)
            .fenceGate(ModBlocks.MULBERRY_FENCE_GATE)
            .door(ModBlocks.MULBERRY_DOOR)
            .trapdoor(ModBlocks.MULBERRY_TRAPDOOR)
            .sign(ModBlocks.MULBERRY_SIGN, ModBlocks.MULBERRY_WALL_SIGN)
            .build();


    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
        } else {
            return builder;
        }
    }
    public static Stream<BlockFamily> getFamilies() {
        return BASE_BLOCKS_TO_FAMILIES.values().stream();
    }
}