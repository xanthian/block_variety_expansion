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
import net.xanthian.block_variety_expansion.block.custom.ModStoneBlockEnum;

import java.util.Locale;

public class ModStoneBlocks {

    public static void registerStoneBlockTypes() {
        for (ModStoneBlockEnum stoneTypes : ModStoneBlockEnum.values()) {

            Block stoneBlock = stoneTypes.getBaseBlock();
            String stoneName = stoneTypes.name().toLowerCase(Locale.ENGLISH);

            if (stoneTypes.getStairBlock()) {
                register(stoneName + "_stairs", new StairsBlock(stoneBlock.getDefaultState(), FabricBlockSettings.copyOf(stoneBlock)));
            }
            if (stoneTypes.getSlabBlock()) {
                register(stoneName + "_slab", new SlabBlock(FabricBlockSettings.copyOf(stoneBlock)));
            }
            if (stoneTypes.getFenceBlock()) {
                register(stoneName + "_fence", new FenceBlock(FabricBlockSettings.copyOf(stoneBlock)));
            }
            if (stoneTypes.getWallBlock()) {
                register(stoneName + "_wall", new WallBlock(FabricBlockSettings.copyOf(stoneBlock)));
            }
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