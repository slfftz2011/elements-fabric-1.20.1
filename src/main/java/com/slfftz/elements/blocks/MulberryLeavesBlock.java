package com.slfftz.elements.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MulberryLeavesBlock extends LeavesBlock {
    public static final IntProperty SILKWORM_GROWTH_STAGE = IntProperty.of("silkworm_growth_stage", 0, 9);
    public MulberryLeavesBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(SILKWORM_GROWTH_STAGE, 0)
                .with(PERSISTENT, false)
                .with(DISTANCE, 7));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(SILKWORM_GROWTH_STAGE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(SILKWORM_GROWTH_STAGE, 0);
    }

    public static void setSilkwormStage(World world, BlockPos pos, int stage) {
        if (world.isClient()) return;
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof MulberryLeavesBlock) {
            int clampedStage = Math.max(0, Math.min(9, stage));
            world.setBlockState(pos, state.with(SILKWORM_GROWTH_STAGE, clampedStage));
        }
    }

    public static int getSilkwormStage(BlockState state) {
        return state.get(SILKWORM_GROWTH_STAGE);
    }

    public static void growSilkworm(World world, BlockPos pos) {
        int currentStage = getSilkwormStage(world.getBlockState(pos));
        if (currentStage < 9) {
            setSilkwormStage(world, pos, currentStage + 1);
        }
    }
}

