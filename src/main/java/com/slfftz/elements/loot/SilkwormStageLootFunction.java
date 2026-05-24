package com.slfftz.elements.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.slfftz.elements.blocks.customs.MulberryLeavesBlock;
import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.items.customs.SilkwormEggsItem;
import com.slfftz.elements.items.customs.SilkwormItem;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SilkwormStageLootFunction extends ConditionalLootFunction {

    public static final LootFunctionType TYPE = new LootFunctionType(
            new Serializer()
    );

    protected SilkwormStageLootFunction(LootCondition[] conditions) {
        super(conditions);
    }

    @Override
    protected ItemStack process(ItemStack stack, LootContext context) {
        Vec3d origin = context.get(LootContextParameters.ORIGIN);
        BlockPos pos = origin != null ? BlockPos.ofFloored(origin) : null;

        World world = context.getWorld();

        BlockState state = context.get(LootContextParameters.BLOCK_STATE);
        if (state != null && state.getBlock() instanceof MulberryLeavesBlock) {
            int stage = MulberryLeavesBlock.getSilkwormStage(world, pos);
            if (stage >= 1 && stage <= 3 && stack.getItem() == ModItems.SILKWORM_EGGS) {
                return SilkwormEggsItem.setStage(stack, stage);
            }
            if (stage >= 4 && stage <= 6 && stack.getItem() == ModItems.SILKWORM) {
                return SilkwormItem.setStage(stack, stage - 3);
            }
            if (stage == 8 && stack.getItem() == ModItems.COCOON) {
                return stack;
            }
        }

        return stack;
    }

    @Override
    public LootFunctionType getType() {
        return TYPE;
    }

    // ---------- 序列化器 ----------

    public static class Serializer extends ConditionalLootFunction.Serializer<SilkwormStageLootFunction> {
        @Override
        public SilkwormStageLootFunction fromJson(
                JsonObject json,
                JsonDeserializationContext context,
                LootCondition[] conditions) {
            return new SilkwormStageLootFunction(conditions);
        }

        @Override
        public void toJson(
                JsonObject json,
                SilkwormStageLootFunction function,
                JsonSerializationContext context) {
            super.toJson(json, function, context);
        }
    }

    // ---------- Builder ----------

    public static ConditionalLootFunction.Builder<?> builder() {
        return builder(SilkwormStageLootFunction::new);
    }
}
