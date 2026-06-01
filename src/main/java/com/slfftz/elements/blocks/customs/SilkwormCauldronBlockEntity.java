package com.slfftz.elements.blocks.customs;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class SilkwormCauldronBlockEntity extends BlockEntity {
    private static final String HAS_COCOON_KEY = "HasCocoon";
    private static final String PROCESSING_TICKS_KEY = "ProcessingTicks";
    private static final String STICK_PROGRESS_KEY = "StickProgress";
    private static final int PROCESS_DURATION = 300; // 300 ticks

    private boolean hasCocoon = false;
    private int processingTicks = 0;
    private int stickProgress = 0;

    public SilkwormCauldronBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.SILKWORM_CAULDRON, pos, state);
    }

    public void tick() {
        if (hasCocoon && processingTicks < PROCESS_DURATION) {
            processingTicks++;
            if (processingTicks == PROCESS_DURATION) {
                markDirty();
            }
        }
    }

    public boolean hasCocoon() {
        return hasCocoon;
    }

    public int getProcessingTicks() {
        return processingTicks;
    }

    public int getStickProgress() {
        return stickProgress;
    }

    public boolean isReadyForStickProcessing() {
        return hasCocoon && processingTicks >= PROCESS_DURATION;
    }

    public void setCocoon(boolean has) {
        this.hasCocoon = has;
        if (!has) {
            this.processingTicks = 0;
            this.stickProgress = 0;
        }
        markDirty();
    }

    public void incrementStickProgress() {
        this.stickProgress++;
        markDirty();
    }

    public void resetProcessing() {
        this.hasCocoon = false;
        this.processingTicks = 0;
        this.stickProgress = 0;
        markDirty();
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.hasCocoon = nbt.getBoolean(HAS_COCOON_KEY);
        this.processingTicks = nbt.getInt(PROCESSING_TICKS_KEY);
        this.stickProgress = nbt.getInt(STICK_PROGRESS_KEY);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putBoolean(HAS_COCOON_KEY, this.hasCocoon);
        nbt.putInt(PROCESSING_TICKS_KEY, this.processingTicks);
        nbt.putInt(STICK_PROGRESS_KEY, this.stickProgress);
    }

    @Nullable
    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    private void markDirty() {
        if (this.world instanceof ServerWorld) {
            ((ServerWorld) this.world).getChunkManager().markForUpdate(this.pos);
        }
    }
}
