package com.slfftz.elements.items.customs;

import com.slfftz.elements.blocks.customs.MulberryLeavesBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SilkwormItem extends Item {
   private static final String STAGE_KEY = "SilkwormStage";

    public SilkwormItem(Settings settings) {
        super(settings);
    }

    // ---------- Stage 读写 ----------

    /** 从 ItemStack 读取 stage，默认返回 0 */
    public static int getStage(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        if (nbt != null && nbt.contains(STAGE_KEY)) {
            return nbt.getInt(STAGE_KEY);
        }
        return 0;
    }

    /**
     * 设置 stage 并同步更新 CustomModelData
     *
     * @return stack
     */
    public static ItemStack setStage(ItemStack stack, int stage) {
        int clamped = Math.max(1, Math.min(3, stage));
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putInt(STAGE_KEY, clamped);
        nbt.putInt("CustomModelData", clamped); // model_data 与 stage 一致
        return stack;
    }

    // ---------- 使用逻辑 ----------

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        ItemStack stack = null;
        if (player != null) {
            stack = player.getStackInHand(hand);
        }

        // 只有桑树树叶且 stage 为 0 时可用
        if (state.getBlock() instanceof MulberryLeavesBlock
                && MulberryLeavesBlock.getSilkwormStage(world, pos) == 0) {

            int eggStage = 0;
            if (stack != null) {
                eggStage = getStage(stack);
            }
            // stage 为 0（默认）时视作 stage 4
            int targetStage = Math.max(1, Math.min(3, eggStage == 0 ? 1 : eggStage)) + 3;


            if (!world.isClient()) {
                MulberryLeavesBlock.setSilkwormStage(world, pos, targetStage);

                if (player != null && !player.getAbilities().creativeMode) {
                    if (stack != null) {
                        stack.decrement(1);
                    }
                }
            }

            world.playSound(player, pos, SoundEvents.BLOCK_SLIME_BLOCK_PLACE,
                    SoundCategory.BLOCKS, 0.6f, 1.0f + targetStage * 0.15f);

            return ActionResult.success(world.isClient());
        }

        return ActionResult.PASS;
    }
}
