package net.xanthian.block_variety_expansion;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.xanthian.block_variety_expansion.datagen.*;

public class DataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModItemTagGenerator::new);
        pack.addProvider(ModBlockTagGenerator::new);
        pack.addProvider(ModLanguageGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModLootTableGenerator::new);
    }
}