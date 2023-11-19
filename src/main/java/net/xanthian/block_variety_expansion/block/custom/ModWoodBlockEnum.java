package net.xanthian.block_variety_expansion.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodType;

public enum ModWoodBlockEnum {

    ACACIA_LOG(Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG, WoodType.ACACIA),
    ACACIA_WOOD(Blocks.ACACIA_PLANKS, Blocks.ACACIA_WOOD, WoodType.ACACIA),
    STRIPPED_ACACIA_LOG(Blocks.ACACIA_PLANKS, Blocks.STRIPPED_ACACIA_LOG, WoodType.ACACIA),
    STRIPPED_ACACIA_WOOD(Blocks.ACACIA_PLANKS, Blocks.STRIPPED_ACACIA_WOOD, WoodType.ACACIA),

    BAMBOO_BLOCK(Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_BLOCK, WoodType.BAMBOO),
    STRIPPED_BAMBOO_BLOCK(Blocks.BAMBOO_PLANKS, Blocks.STRIPPED_BAMBOO_BLOCK, WoodType.BAMBOO),

    BIRCH_LOG(Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG, WoodType.BIRCH),
    BIRCH_WOOD(Blocks.BIRCH_PLANKS, Blocks.BIRCH_WOOD, WoodType.BIRCH),
    STRIPPED_BIRCH_LOG(Blocks.BIRCH_PLANKS, Blocks.STRIPPED_BIRCH_LOG, WoodType.BIRCH),
    STRIPPED_BIRCH_WOOD(Blocks.BIRCH_PLANKS, Blocks.STRIPPED_BIRCH_WOOD, WoodType.BIRCH),

    CHERRY_LOG(Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG, WoodType.CHERRY),
    CHERRY_WOOD(Blocks.CHERRY_PLANKS, Blocks.CHERRY_WOOD, WoodType.CHERRY),
    STRIPPED_CHERRY_LOG(Blocks.CHERRY_PLANKS, Blocks.STRIPPED_CHERRY_LOG, WoodType.CHERRY),
    STRIPPED_CHERRY_WOOD(Blocks.CHERRY_PLANKS, Blocks.STRIPPED_CHERRY_WOOD, WoodType.CHERRY),

    CRIMSON_STEM(Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, WoodType.CRIMSON),
    CRIMSON_HYPHAE(Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_HYPHAE, WoodType.CRIMSON),
    STRIPPED_CRIMSON_STEM(Blocks.CRIMSON_PLANKS, Blocks.STRIPPED_CRIMSON_STEM, WoodType.CRIMSON),
    STRIPPED_CRIMSON_HYPHAE(Blocks.CRIMSON_PLANKS, Blocks.STRIPPED_CRIMSON_HYPHAE, WoodType.CRIMSON),

    DARK_OAK_LOG(Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG, WoodType.DARK_OAK),
    DARK_OAK_WOOD(Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_WOOD, WoodType.DARK_OAK),
    STRIPPED_DARK_OAK_LOG(Blocks.DARK_OAK_PLANKS, Blocks.STRIPPED_DARK_OAK_LOG, WoodType.DARK_OAK),
    STRIPPED_DARK_OAK_WOOD(Blocks.DARK_OAK_PLANKS, Blocks.STRIPPED_DARK_OAK_WOOD, WoodType.DARK_OAK),

    JUNGLE_LOG(Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG, WoodType.JUNGLE),
    JUNGLE_WOOD(Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_WOOD, WoodType.JUNGLE),
    STRIPPED_JUNGLE_LOG(Blocks.JUNGLE_PLANKS, Blocks.STRIPPED_JUNGLE_LOG, WoodType.JUNGLE),
    STRIPPED_JUNGLE_WOOD(Blocks.JUNGLE_PLANKS, Blocks.STRIPPED_JUNGLE_WOOD, WoodType.JUNGLE),

    MANGROVE_LOG(Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG, WoodType.MANGROVE),
    MANGROVE_WOOD(Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_WOOD, WoodType.MANGROVE),
    STRIPPED_MANGROVE_LOG(Blocks.MANGROVE_PLANKS, Blocks.STRIPPED_MANGROVE_LOG, WoodType.MANGROVE),
    STRIPPED_MANGROVE_WOOD(Blocks.MANGROVE_PLANKS, Blocks.STRIPPED_MANGROVE_WOOD, WoodType.MANGROVE),

    OAK_LOG(Blocks.OAK_PLANKS, Blocks.OAK_LOG, WoodType.OAK),
    OAK_WOOD(Blocks.OAK_PLANKS, Blocks.OAK_WOOD, WoodType.OAK),
    STRIPPED_OAK_LOG(Blocks.OAK_PLANKS, Blocks.STRIPPED_OAK_LOG, WoodType.OAK),
    STRIPPED_OAK_WOOD(Blocks.OAK_PLANKS, Blocks.STRIPPED_OAK_WOOD, WoodType.OAK),

    SPRUCE_LOG(Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG, WoodType.SPRUCE),
    SPRUCE_WOOD(Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_WOOD, WoodType.SPRUCE),
    STRIPPED_SPRUCE_LOG(Blocks.SPRUCE_PLANKS, Blocks.STRIPPED_SPRUCE_LOG, WoodType.SPRUCE),
    STRIPPED_SPRUCE_WOOD(Blocks.SPRUCE_PLANKS, Blocks.STRIPPED_SPRUCE_WOOD, WoodType.SPRUCE),

    WARPED_STEM(Blocks.WARPED_PLANKS, Blocks.WARPED_STEM, WoodType.WARPED),
    WARPED_HYPHAE(Blocks.WARPED_PLANKS, Blocks.WARPED_HYPHAE, WoodType.WARPED),
    STRIPPED_WARPED_STEM(Blocks.WARPED_PLANKS, Blocks.STRIPPED_WARPED_STEM, WoodType.WARPED),
    STRIPPED_WARPED_HYPHAE(Blocks.WARPED_PLANKS, Blocks.STRIPPED_WARPED_HYPHAE, WoodType.WARPED);

    private final Block woodBlock;
    private final Block baseBlock;
    private final WoodType woodType;

    ModWoodBlockEnum(Block woodBlock, Block baseBlock, WoodType woodType) {
        this.woodBlock = woodBlock;
        this.baseBlock = baseBlock;
        this.woodType = woodType;
    }

    public Block getWoodBlock() {
        return woodBlock;
    }

    public Block getBaseBlock() {
        return baseBlock;
    }

    public WoodType getWoodType() {
        return woodType;
    }
}