package com.slfftz.elements.blocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class MulberryLeavesBlock extends LeavesBlock implements Fertilizable {
    public static final int MAX_STAGE = 9;
    public static final IntProperty SILKWORM_GROWTH_STAGE = IntProperty.of("silkworm_growth_stage", 0, 9);
    public MulberryLeavesBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(SILKWORM_GROWTH_STAGE, 0)
                .with(PERSISTENT, false)
                .with(DISTANCE, 7)
                .with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(SILKWORM_GROWTH_STAGE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(SILKWORM_GROWTH_STAGE, 0).with(PERSISTENT, true);
    }

    public static void setSilkwormStage(World world, BlockPos pos, int stage) {
        if (world.isClient()) return;
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof MulberryLeavesBlock) {
            int clampedStage = Math.max(0, Math.min(9, stage));
            world.setBlockState(pos, state
                    .with(SILKWORM_GROWTH_STAGE, clampedStage)
                    .with(PERSISTENT, clampedStage > 0), Block.NOTIFY_LISTENERS);
        }
    }

    public static int getMaxStage() { return MAX_STAGE; }

    public static int getSilkwormStage(BlockState state) {
        return state.get(SILKWORM_GROWTH_STAGE);
    }

    public static void growSilkworm(World world, BlockPos pos) {
        int currentStage = getSilkwormStage(world.getBlockState(pos));
        if (currentStage < getMaxStage()) {
            setSilkwormStage(world, pos, currentStage + 1);
            return;
        }
        Direction[] horizontals = {
                Direction.NORTH, Direction.SOUTH,
                Direction.WEST,  Direction.EAST
        };

        for (Direction dir : horizontals) {
            BlockPos adjacentPos = pos.offset(dir);
            BlockState adjacentState = world.getBlockState(adjacentPos);

            if (adjacentState.getBlock() == ModBlocks.MULBERRY_LEAVES
                    && getSilkwormStage(adjacentState) == 0) {
                growSilkworm(world, adjacentPos);
            }
        }

        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (this.shouldDecay(state)) {
            dropStacks(state, world, pos);
            world.removeBlock(pos, false);
            return;
        }
        if (world.getBaseLightLevel(pos, 0) >= 8) {
            float f = getAvailableMoisture(this, world, pos);
            if (random.nextInt((int)(25.0F / f) + 1) == 0) {
                grow(world, random, pos, state);
            }
        }
    }

    protected static float getAvailableMoisture(Block block, BlockView world, BlockPos pos) {
        float f = 1.0F;
        return f;
    }

    @Override
    protected boolean shouldDecay(BlockState state) {
        return !(Boolean)state.get(PERSISTENT) && state.get(DISTANCE) == 7 && getSilkwormStage(state) == 0;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        growSilkworm(world, pos);
    }
}

