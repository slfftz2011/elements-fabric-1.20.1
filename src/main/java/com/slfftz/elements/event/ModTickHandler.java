package com.slfftz.elements.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import com.slfftz.elements.blocks.entity.ModCauldronBlockEntity;
import com.slfftz.elements.component.CauldronDataComponent;
import com.slfftz.elements.component.ModComponents;
import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.tag.ModTags;

import java.util.HashSet;
import java.util.Set;

public class ModTickHandler {
    // 存储所有活跃的炼药锅位置，用于快速遍历
    private static final Set<BlockPos> ACTIVE_CAULDRONS = new HashSet<>();

    public static void init() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            if (world.isClient) return;
            // 遍历所有活跃的炼药锅
            for (BlockPos pos : ACTIVE_CAULDRONS) {
                // 检查该位置是否仍然存在炼药锅且有水
                if (!world.getBlockState(pos).isOf(Blocks.WATER_CAULDRON) ||
                        world.getBlockState(pos).get(LeveledCauldronBlock.LEVEL) == 0) {
                    continue;
                }
                BlockEntity be = world.getBlockEntity(pos);
                if (!(be instanceof ModCauldronBlockEntity)) continue;

                CauldronDataComponent comp = ModComponents.CAULDRON_DATA.getNullable(be);
                if (comp == null) continue;

                // 热源检测（每秒一次）
                if (world.getTime() % 20 == 0) {
                    boolean heated = world.getBlockState(pos.down()).isIn(ModTags.CAULDRON_HEAT_SOURCES);
                    comp.setHeated(heated);
                }

                // 进度处理
                ItemStack stored = comp.getStoredItem();
                if (stored.getItem() == ModItems.COCOON && comp.getCocoonCount() > 0 && comp.isHeated()) {
                    int time = comp.getProcessTime();
                    if (time < 800) {
                        comp.setProcessTime(time + 1);
                    }
                    if (comp.getProcessTime() >= 800) {
                        int count = comp.getCocoonCount();
                        if (count > 0) {
                            comp.setStoredItem(new ItemStack(ModItems.SILKWORM_PUPA, count));
                            comp.setCocoonCount(0);
                            comp.setProcessTime(0);
                        }
                    }
                }
            }
        });
    }

    // 当有炼药锅获得组件数据时，注册到活跃列表
    public static void addActive(BlockPos pos) {
        ACTIVE_CAULDRONS.add(pos);
    }

    public static void removeActive(BlockPos pos) {
        ACTIVE_CAULDRONS.remove(pos);
    }
}