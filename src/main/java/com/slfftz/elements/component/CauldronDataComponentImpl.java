package com.slfftz.elements.component;

import com.slfftz.elements.event.ModTickHandler;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauldronDataComponentImpl implements CauldronDataComponent, AutoSyncedComponent {
    private ItemStack storedItem = ItemStack.EMPTY;
    private int processTime = 0;
    private boolean heated = false;
    private int cocoonCount = 0;
    private final BlockPos pos;
    private final World world;

    public CauldronDataComponentImpl(BlockPos pos, World world) {
        this.pos = pos;
        this.world = world;
    }

    @Override
    public ItemStack getStoredItem() { return storedItem; }

    @Override
    public void setStoredItem(ItemStack stack) {
        boolean wasEmpty = this.storedItem.isEmpty();
        this.storedItem = stack;
        if (stack.isEmpty()) {
            this.processTime = 0;
            this.cocoonCount = 0;
            ModTickHandler.removeActive(pos);
        } else {
            if (wasEmpty) {
                ModTickHandler.addActive(pos);
            }
        }
        sync();
        markDirty();
    }

    @Override
    public int getProcessTime() { return processTime; }

    @Override
    public void setProcessTime(int time) {
        this.processTime = time;
        sync();
        markDirty();
    }

    @Override
    public boolean isHeated() { return heated; }

    @Override
    public void setHeated(boolean heated) {
        this.heated = heated;
        sync();
        markDirty();
    }

    @Override
    public int getCocoonCount() { return cocoonCount; }

    @Override
    public void setCocoonCount(int count) {
        this.cocoonCount = count;
        sync();
        markDirty();
    }

    @Override
    public void incrementCocoonCount() {
        if (cocoonCount < 16) {
            cocoonCount++;
            sync();
            markDirty();
        }
    }

    @Override
    public void sync() {
        BlockEntity be = world.getBlockEntity(pos);
        if (be != null) {
            ModComponents.CAULDRON_DATA.sync(be);
        }
    }

    private void markDirty() {
        BlockEntity be = world.getBlockEntity(pos);
        if (be != null) {
            be.markDirty();
        }
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        storedItem = ItemStack.fromNbt(tag.getCompound("StoredItem"));
        processTime = tag.getInt("ProcessTime");
        heated = tag.getBoolean("Heated");
        cocoonCount = tag.getInt("CocoonCount");
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.put("StoredItem", storedItem.writeNbt(new NbtCompound()));
        tag.putInt("ProcessTime", processTime);
        tag.putBoolean("Heated", heated);
        tag.putInt("CocoonCount", cocoonCount);
    }
}