package com.slfftz.elements.event;

import com.slfftz.elements.blocks.entity.ModCauldronBlockEntity;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.slfftz.elements.component.ModComponents;
import com.slfftz.elements.items.ModItems;

public class ModEvents {
    public static void init() {
        // 监听世界加载（如果需要迁移旧存档，可在这里实现）
        ServerWorldEvents.LOAD.register((server, world) -> {
            // 可以在这里一次性迁移所有水炼药锅，但建议不做，让玩家自己重新放置
        });

        // 监听玩家右键点击
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            // 只处理水炼药锅（有水位）
            if (state.isOf(Blocks.WATER_CAULDRON) && state.get(LeveledCauldronBlock.LEVEL) > 0) {
                return onCauldronInteract(player, world, hand, pos, hitResult);
            }
            return ActionResult.PASS;
        });
    }

    private static ActionResult onCauldronInteract(PlayerEntity player, World world, Hand hand, BlockPos pos, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        var be = world.getBlockEntity(pos);
        if (!(be instanceof ModCauldronBlockEntity)) return ActionResult.PASS;

        var comp = ModComponents.CAULDRON_DATA.getNullable(be);
        if (comp == null) return ActionResult.PASS;

        // 空手右键 -> 取出物品
        if (stack.isEmpty()) {
            ItemStack stored = comp.getStoredItem();
            if (!stored.isEmpty()) {
                player.giveItemStack(stored.copy());
                comp.setStoredItem(ItemStack.EMPTY);
                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 1f, 1f);
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        }

        // 手持木棍 + 蚕蛹 -> 缠丝木棍
        if (stack.getItem() == Items.STICK && comp.getStoredItem().getItem() == ModItems.SILKWORM_PUPA) {
            if (!player.isCreative()) stack.decrement(1);
            player.giveItemStack(new ItemStack(ModItems.WRAPPED_STICK, 1));
            comp.setStoredItem(ItemStack.EMPTY);
            world.playSound(null, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.PLAYERS, 1f, 1f);
            return ActionResult.SUCCESS;
        }

        // 手持蚕茧
        if (stack.getItem() == ModItems.COCOON) {
            ItemStack stored = comp.getStoredItem();
            if (stored.isEmpty()) {
                comp.setStoredItem(stack.copy());
                comp.setCocoonCount(1);
                if (!player.isCreative()) stack.decrement(1);
                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 1f, 1f);
                return ActionResult.SUCCESS;
            } else if (stored.getItem() == ModItems.COCOON && comp.getCocoonCount() < 16) {
                comp.incrementCocoonCount();
                if (!player.isCreative()) stack.decrement(1);
                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 1f, 1f);
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }
}