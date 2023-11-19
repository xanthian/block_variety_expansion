package net.xanthian.block_variety_expansion.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.xanthian.block_variety_expansion.Initialise;
import net.xanthian.block_variety_expansion.block.custom.ModWoodBlockEnum;

import java.util.Locale;

public class ModWoodBlocks {

    public static void registerWoodBlockTypes() {
        for (ModWoodBlockEnum woodTypes : ModWoodBlockEnum.values()) {

            Block woodBlock = woodTypes.getWoodBlock();
            WoodType woodType = woodTypes.getWoodType();
            String woodName = woodTypes.name().toLowerCase(Locale.ENGLISH);

            register(woodName + "_stairs", new StairsBlock(woodBlock.getDefaultState(), FabricBlockSettings.copyOf(woodBlock)));
            register(woodName + "_slab", new SlabBlock(FabricBlockSettings.copyOf(woodBlock)));
            register(woodName + "_fence", new FenceBlock(FabricBlockSettings.copyOf(woodBlock)));
            register(woodName + "_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(woodBlock), woodType));
            register(woodName + "_wall", new WallBlock(FabricBlockSettings.copyOf(woodBlock)));

        }
    }

    private static Block register(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Initialise.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Initialise.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }
}