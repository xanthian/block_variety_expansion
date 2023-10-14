package net.xanthian.block_variety_expansion.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.xanthian.block_variety_expansion.Initialise;


public class ModItemTags {

    public static final TagKey<Item> WOODEN_WALLS = register("wooden_walls");

    private static TagKey<Item> register(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(Initialise.MOD_ID, id));
    }
}