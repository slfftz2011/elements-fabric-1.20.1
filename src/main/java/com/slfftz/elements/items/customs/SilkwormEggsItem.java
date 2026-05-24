package com.slfftz.elements.items.customs;

import com.slfftz.elements.blocks.customs.MulberryLeavesBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SilkwormEggsItem extends Item {
    public SilkwormEggsItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();

        if (state.getBlock() instanceof MulberryLeavesBlock
                && MulberryLeavesBlock.getSilkwormStage(world, pos) == 0) {

            if (!world.isClient()) {
                MulberryLeavesBlock.setSilkwormStage(world, pos, 1);

                ItemStack stack = null;
                if (player != null) {
                    stack = player.getStackInHand(hand);
                }
                if (player != null && !player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
            }

            world.playSound(player, pos, SoundEvents.BLOCK_SLIME_BLOCK_PLACE,
                    SoundCategory.BLOCKS, 0.6f, 1.2f);

            return ActionResult.success(world.isClient());
        }

        return ActionResult.PASS;
    }
}
