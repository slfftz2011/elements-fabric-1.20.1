package com.slfftz.elements.mixin;

import com.slfftz.elements.blocks.entity.ModCauldronBlockEntity;
import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock; // 导入
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.slfftz.elements.blocks.ModBlocks;
import com.slfftz.elements.component.CauldronDataComponent;
import com.slfftz.elements.component.ModComponents;
import com.slfftz.elements.items.ModItems;

@Mixin(AbstractCauldronBlock.class)
public abstract class AbstractCauldronBlockMixin {
    @Inject(method = "onEntityCollision", at = @At("HEAD"))
    private void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
        // 只处理水炼药锅
        if (!state.isOf(Blocks.WATER_CAULDRON)) return;
        if (world.isClient) return;
        // 检查水位是否 > 0
        if (state.get(LeveledCauldronBlock.LEVEL) == 0) return;
        if (!(entity instanceof ItemEntity itemEntity)) return;

        ItemStack stack = itemEntity.getStack();
        if (stack.getItem() == ModItems.COCOON) {
            var be = world.getBlockEntity(pos);
            if (!(be instanceof ModCauldronBlockEntity)) return;

            var comp = ModComponents.CAULDRON_DATA.getNullable(be);
            if (comp == null) return;

            ItemStack stored = comp.getStoredItem();
            if (stored.isEmpty()) {
                int count = Math.min(stack.getCount(), 16);
                comp.setStoredItem(new ItemStack(ModItems.SILKWORM_PUPA, 1));
                comp.setCocoonCount(count);
                itemEntity.discard();
            } else if (stored.getItem() == ModItems.SILKWORM_EGGS && comp.getCocoonCount() < 16) {
                int add = Math.min(stack.getCount(), 16 - comp.getCocoonCount());
                comp.setCocoonCount(comp.getCocoonCount() + add);
                stack.decrement(add);
                if (stack.isEmpty()) itemEntity.discard();
            }
        }
    }
}