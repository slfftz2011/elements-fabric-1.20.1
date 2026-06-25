package com.slfftz.elements.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.util.math.BlockPos;
import com.slfftz.elements.blocks.entity.ModCauldronBlockEntity;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ModTickHandler {
    private static final Set<BlockPos> ACTIVE_CAULDRONS = ConcurrentHashMap.newKeySet();

    public static void init() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            if (world.isClient) return;
            for (BlockPos pos : ACTIVE_CAULDRONS) {
                // 检查方块状态是否有效
                if (!world.getBlockState(pos).isOf(Blocks.WATER_CAULDRON) ||
                        world.getBlockState(pos).get(LeveledCauldronBlock.LEVEL) == 0) {
                    removeActive(pos);
                    continue;
                }
                var be = world.getBlockEntity(pos);
                if (!(be instanceof ModCauldronBlockEntity cauldronBe)) {
                    removeActive(pos);
                    continue;
                }
                // 调用 BlockEntity 的 tick 方法处理进度
                ModCauldronBlockEntity.tick(world, pos, cauldronBe.getCachedState(), cauldronBe);
            }
        });
    }

    public static void addActive(BlockPos pos) {
        ACTIVE_CAULDRONS.add(pos);
    }

    public static void removeActive(BlockPos pos) {
        ACTIVE_CAULDRONS.remove(pos);
    }
}