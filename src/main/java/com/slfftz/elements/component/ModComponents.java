package com.slfftz.elements.component;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import net.minecraft.util.Identifier;
import com.slfftz.elements.Elements;

public class ModComponents {
    public static final ComponentKey<CauldronDataComponent> CAULDRON_DATA =
            ComponentRegistryV3.INSTANCE.getOrCreate(
                    new Identifier(Elements.MOD_ID, "cauldron_data"),
                    CauldronDataComponent.class
            );
}