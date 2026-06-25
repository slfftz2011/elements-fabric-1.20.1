package com.slfftz.elements.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.slfftz.elements.blocks.entity.ModCauldronBlockEntity;
import com.slfftz.elements.component.ModComponents;
import com.slfftz.elements.event.ModTickHandler;
import com.slfftz.elements.items.ModItems;

@Mixin(AbstractBlock.class)
public abstract class AbstractBlockMixin {
    @Inject(
            method = "onEntityCollision(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;)V",
            at = @At("HEAD")
    )
    private void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
        // 只处理水炼药锅
        if (!state.isOf(Blocks.WATER_CAULDRON)) return;
        if (world.isClient) return;
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
                comp.setStoredItem(new ItemStack(ModItems.COCOON, 1));
                comp.setCocoonCount(count);
                itemEntity.discard();
                // ✅ 首次放入，加入活跃列表
                ModTickHandler.addActive(pos);
                // 播放音效
                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 1f, 1f);
            } else if (stored.getItem() == ModItems.COCOON && comp.getCocoonCount() < 16) {
                int add = Math.min(stack.getCount(), 16 - comp.getCocoonCount());
                comp.setCocoonCount(comp.getCocoonCount() + add);
                stack.decrement(add);
                if (stack.isEmpty()) itemEntity.discard();
                // ✅ 确保在活跃列表中（可能已存在，但幂等操作安全）
                ModTickHandler.addActive(pos);
                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 1f, 1f);
            }
        }
    }
}