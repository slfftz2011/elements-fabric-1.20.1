package com.slfftz.elements;

import com.slfftz.elements.blocks.ModBlocks;
import com.slfftz.elements.blocks.entity.ModCauldronBlockEntity;
import com.slfftz.elements.component.CauldronDataComponentImpl;
import com.slfftz.elements.component.ModComponents;
import com.slfftz.elements.entities.ModBoats;
import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.items.ModItemGroups;
import com.slfftz.elements.loot.SilkwormStageLootFunction;
import com.slfftz.elements.world.ModWorldGeneration;
import com.slfftz.elements.event.ModEvents;
import dev.onyxstudios.cca.api.v3.block.BlockComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.block.BlockComponentInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Elements implements ModInitializer, BlockComponentInitializer {
    public static final String MOD_ID = "elements";
    public static final Logger LOGGER = LoggerFactory.getLogger("Elements");

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerGroups();
        ModWorldGeneration.register();
        ModBoats.registerBoats();
        Registry.register(
                Registries.LOOT_FUNCTION_TYPE,
                new Identifier(Elements.MOD_ID, "silkworm_stage"),
                SilkwormStageLootFunction.TYPE
        );
        ModEvents.init();
        LOGGER.info("The elemental world is ready, let's start your adventure!");
    }

    @Override
    public void registerBlockComponentFactories(BlockComponentFactoryRegistry registry) {
        registry.registerFor(
                ModCauldronBlockEntity.class,
                ModComponents.CAULDRON_DATA,
                (be) -> new CauldronDataComponentImpl(be.getPos(), be.getWorld())
        );
    }
}