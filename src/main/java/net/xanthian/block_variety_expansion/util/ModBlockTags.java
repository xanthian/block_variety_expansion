package net.xanthian.block_variety_expansion.util;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.xanthian.block_variety_expansion.Initialise;

public class ModBlockTags {

    public static final TagKey<Block> WOODEN_WALLS = register("wooden_walls");

    private static TagKey<Block> register(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(Initialise.MOD_ID, id));
    }
}