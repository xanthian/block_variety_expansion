package net.xanthian.block_variety_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import net.xanthian.block_variety_expansion.Initialise;
import net.xanthian.block_variety_expansion.block.custom.ModStoneBlockEnum;
import net.xanthian.block_variety_expansion.block.custom.ModWoodBlockEnum;

import java.util.Locale;

public class ModLootTableGenerator  extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        generateBlockLoot(ModWoodBlockEnum.values());
        generateBlockLoot(ModStoneBlockEnum.values());
    }

    private void generateBlockLoot(Enum<?>[] blocks) {
        for (Enum<?> blockType : blocks) {
            String blockName = blockType.name().toLowerCase(Locale.ENGLISH);

            Block fence = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, blockName + "_fence"));
            Block fence_gate = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, blockName + "_fence_gate"));
            Block slab = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, blockName + "_slab"));
            Block stairs = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, blockName + "_stairs"));
            Block wall = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, blockName + "_wall"));

            addDrop(fence);
            addDrop(fence_gate);
            addDrop(slab, slabDrops(slab));
            addDrop(stairs);
            addDrop(wall);
        }
    }
}