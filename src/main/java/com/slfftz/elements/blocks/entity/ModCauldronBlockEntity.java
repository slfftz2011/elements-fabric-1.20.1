package com.slfftz.elements.blocks.entity;

import com.slfftz.elements.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.slfftz.elements.component.CauldronDataComponent;
import com.slfftz.elements.component.ModComponents;
import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.tag.ModTags;

public class ModCauldronBlockEntity extends BlockEntity {
    public ModCauldronBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.CAULDRON_BE, pos, state);
    }

    // 这个 tick 方法会被每游戏刻调用
    public static void tick(World world, BlockPos pos, BlockState state, ModCauldronBlockEntity be) {
        if (world.isClient) return;

        CauldronDataComponent comp = ModComponents.CAULDRON_DATA.getNullable(be);
        if (comp == null) return;

        // 热源检测（每秒一次）
        if (world.getTime() % 20 == 0) {
            boolean heated = world.getBlockState(pos.down()).isIn(ModTags.CAULDRON_HEAT_SOURCES);
            comp.setHeated(heated);
        }

        // 进度处理
        var stored = comp.getStoredItem();
        if (stored.getItem() == ModItems.COCOON && comp.getCocoonCount() > 0 && comp.isHeated()) {
            int time = comp.getProcessTime();
            if (time < 800) {
                comp.setProcessTime(time + 1);
            }
            if (comp.getProcessTime() >= 800) {
                int count = comp.getCocoonCount();
                if (count > 0) {
                    comp.setStoredItem(new net.minecraft.item.ItemStack(ModItems.SILKWORM_PUPA, count));
                    comp.setCocoonCount(0);
                    comp.setProcessTime(0);
                }
            }
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
    }
}