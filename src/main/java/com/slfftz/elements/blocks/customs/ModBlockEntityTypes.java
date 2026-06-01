package com.slfftz.elements.blocks.customs;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.slfftz.elements.Elements;

public class ModBlockEntityTypes {
    public static final BlockEntityType<SilkwormCauldronBlockEntity> SILKWORM_CAULDRON = 
            Registry.register(
                    Registries.BLOCK_ENTITY_TYPE,
                    new Identifier(Elements.MOD_ID, "silkworm_cauldron"),
                    BlockEntityType.Builder.create(
                            SilkwormCauldronBlockEntity::new,
                            ModBlocksCustom.SILKWORM_CAULDRON
                    ).build(null)
            );

    public static void registerBlockEntityTypes() {
        // Registration happens automatically via the above static block
    }
}
