package net.xanthian.block_variety_expansion.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.xanthian.block_variety_expansion.Initialise;
import net.xanthian.block_variety_expansion.block.custom.ModStoneBlockEnum;
import net.xanthian.block_variety_expansion.block.custom.ModWoodBlockEnum;

import java.util.Comparator;
import java.util.Locale;

public class ModCreativeTab {


    public static void registerGroup() {
    }


    public static final ItemGroup BVE = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Initialise.MOD_ID, "block_variety_expansion"),
            FabricItemGroup.builder()
                    .displayName(Text.literal("Block Variety Expansion"))
                    .icon(() -> new ItemStack(Items.DIAMOND))
                    .entries((context, entries) -> {
                        entries.addAll(Registries.ITEM.getIds().stream()
                                .filter(identifier -> identifier.getNamespace().equals(Initialise.MOD_ID))
                                .sorted(Comparator.comparing(Identifier::getPath))
                                .map(Registries.ITEM::get)
                                .map(ItemStack::new)
                                .filter(input -> !input.isEmpty())
                                .toList());
                    })
                    .build());


    public static void addToBuildingBlocks() {
        for (ModWoodBlockEnum woodType : ModWoodBlockEnum.values()) {
            Block stoneBlock = woodType.getBaseBlock();
            String woodName = woodType.name().toLowerCase(Locale.ENGLISH);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {

                content.addAfter(stoneBlock, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_stairs")));
                content.addAfter(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_stairs")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_slab")));
                content.addAfter(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_slab")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_wall")));
                content.addAfter(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_wall")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_fence")));
                content.addAfter(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_fence")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_fence_gate")));
            });
        }


        for (ModStoneBlockEnum stoneTypes : ModStoneBlockEnum.values()) {
            Block stoneBlock = stoneTypes.getBaseBlock();
            String stoneName = stoneTypes.name().toLowerCase(Locale.ENGLISH);

            if (!stoneName.matches("bone|calcite|clay|crying_obsidian|dripstone|glowstone|obsidian|tuff")) {

                ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {

                    if (stoneTypes.getStairBlock()) {
                        content.addAfter(stoneBlock, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_stairs")));
                    }
                    if (stoneTypes.getSlabBlock()) {
                        if (stoneTypes.getStairBlock()) {
                            content.addAfter(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_stairs")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_slab")));
                        } else {
                            content.addAfter(Registries.BLOCK.get(new Identifier("minecraft:" + stoneName + "_stairs")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_slab")));
                        }
                    }
                    if (stoneTypes.getWallBlock()) {
                        if (stoneTypes.getSlabBlock()) {
                            content.addAfter(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_slab")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_wall")));
                        } else {
                            content.addAfter(Registries.BLOCK.get(new Identifier("minecraft:" + stoneName + "_slab")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_wall")));
                        }
                    }
                    if (stoneTypes.getFenceBlock()) {
                        if (stoneTypes.getWallBlock()) {
                            content.addAfter(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_wall")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_fence")));
                        } else {
                            content.addAfter(Registries.BLOCK.get(new Identifier("minecraft:" + stoneName + "_wall")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_fence")));
                        }
                    }
                });
            } else {
                ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content2 -> {

                    if (stoneTypes.getStairBlock()) {
                        content2.addAfter(stoneBlock, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_stairs")));
                    }
                    if (stoneTypes.getSlabBlock()) {
                        if (stoneTypes.getStairBlock()) {
                            content2.addAfter(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_stairs")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_slab")));
                        } else {
                            content2.addAfter(Registries.BLOCK.get(new Identifier("minecraft:" + stoneName + "_stairs")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_slab")));
                        }
                    }
                    if (stoneTypes.getWallBlock()) {
                        if (stoneTypes.getSlabBlock()) {
                            content2.addAfter(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_slab")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_wall")));
                        } else {
                            content2.addAfter(Registries.BLOCK.get(new Identifier("minecraft:" + stoneName + "_slab")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_wall")));
                        }
                    }
                    if (stoneTypes.getFenceBlock()) {
                        if (stoneTypes.getWallBlock()) {
                            content2.addAfter(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_wall")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_fence")));
                        } else {
                            content2.addAfter(Registries.BLOCK.get(new Identifier("minecraft:" + stoneName + "_wall")), Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_fence")));
                        }
                    }
                });
            }
        }
    }
}