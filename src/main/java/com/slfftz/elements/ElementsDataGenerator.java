package com.slfftz.elements;

import com.slfftz.elements.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ElementsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagsProvider::new);
        pack.addProvider(ModItemTagsProvider::new);
        pack.addProvider(ModEnUsLangProvider::new);
        pack.addProvider(ModZhCnLangProvider::new);
        pack.addProvider(ModLzhLangProvider::new);
        pack.addProvider(ModLootTablesProvider::new);
        pack.addProvider(ModModelsProvider::new);
        pack.addProvider(ModRecipesProvider::new);
	}
}
