package net.xanthian.block_variety_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import net.minecraft.util.Identifier;
import net.xanthian.block_variety_expansion.Initialise;
import net.xanthian.block_variety_expansion.block.custom.ModStoneBlockEnum;
import net.xanthian.block_variety_expansion.block.custom.ModWoodBlockEnum;
import net.xanthian.block_variety_expansion.util.ModBlockTags;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator  extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        for (ModWoodBlockEnum woodType : ModWoodBlockEnum.values()) {
            String woodName = woodType.name().toLowerCase(Locale.ENGLISH);

            Block fence = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_fence"));
            Block fence_gate = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_fence_gate"));
            Block slab = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_slab"));
            Block stairs = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_stairs"));
            Block wall = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_wall"));

                getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(fence);

                getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(fence_gate);

                getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(slab);

                getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(stairs);

                getOrCreateTagBuilder(ModBlockTags.WOODEN_WALLS).add(wall);
                getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(wall);

        }

        for (ModStoneBlockEnum stoneType : ModStoneBlockEnum.values()) {
            String stoneName = stoneType.name().toLowerCase(Locale.ENGLISH);

            Block fence = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_fence"));
            Block slab = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_slab"));
            Block stairs = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_stairs"));
            Block wall = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_wall"));

            if (stoneType.getFenceBlock()) {
                getOrCreateTagBuilder(BlockTags.FENCES).add(fence);
                getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(fence);
            }
            if (stoneType.getSlabBlock()) {
                getOrCreateTagBuilder(BlockTags.SLABS).add(slab);
                getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(slab);
            }
            if (stoneType.getStairBlock()) {
                getOrCreateTagBuilder(BlockTags.STAIRS).add(stairs);
                getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(stairs);
            }
            if (stoneType.getWallBlock()) {
                getOrCreateTagBuilder(BlockTags.WALLS).add(wall);
            }
        }

        String[] blockSuffixes = { "fence", "slab", "stairs", "wall" };
        for (String suffix : blockSuffixes) {

            getOrCreateTagBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS).add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "amethyst_" + suffix)));
            getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "iron_" + suffix)));
            getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "lapis_" + suffix)));
            getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "diamond_" + suffix)));
            getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "emerald_" + suffix)));
            getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "gold_" + suffix)));
            getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS).add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "gold_" + suffix)));
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "netherite_" + suffix)));
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "obsidian_" + suffix)));
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, "crying_obsidian_" + suffix)));

        }
    }
}