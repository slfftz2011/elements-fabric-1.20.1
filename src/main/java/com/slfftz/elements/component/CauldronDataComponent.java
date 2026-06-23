package com.slfftz.elements.component;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import net.minecraft.item.ItemStack;

public interface CauldronDataComponent extends ComponentV3 {
    ItemStack getStoredItem();
    void setStoredItem(ItemStack stack);
    int getProcessTime();
    void setProcessTime(int time);
    boolean isHeated();
    void setHeated(boolean heated);
    int getCocoonCount();
    void setCocoonCount(int count);
    void incrementCocoonCount();
    void sync();
}