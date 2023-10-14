package net.xanthian.block_variety_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import net.xanthian.block_variety_expansion.Initialise;
import net.xanthian.block_variety_expansion.block.custom.ModStoneBlockEnum;
import net.xanthian.block_variety_expansion.block.custom.ModWoodBlockEnum;

import java.util.Locale;
import java.util.function.Consumer;

public class ModRecipeGenerator  extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }



    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        for (ModWoodBlockEnum woodType : ModWoodBlockEnum.values()) {
            Block baseBlock = woodType.getBaseBlock();
            String woodName = woodType.name().toLowerCase(Locale.ENGLISH);

            addFenceGateRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_fence_gate")), baseBlock);
            addFenceRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_fence")), baseBlock);
            addSlabRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_slab")), baseBlock);
            addStairsRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_stairs")), baseBlock);
            addWallRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_wall")), baseBlock);

        }
        for (ModStoneBlockEnum stoneType : ModStoneBlockEnum.values()) {
            Block baseBlock = stoneType.getBaseBlock();
            String stoneName = stoneType.name().toLowerCase(Locale.ENGLISH);

            if (stoneType.getFenceBlock()) {
                addFenceRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_fence")), baseBlock);
                FabricRecipeProvider.offerStonecuttingRecipe(exporter,RecipeCategory.DECORATIONS, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_fence")), baseBlock);
            }
            if (stoneType.getSlabBlock()) {
                addSlabRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_slab")), baseBlock);
                FabricRecipeProvider.offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_slab")), baseBlock,2);
            }
            if (stoneType.getStairBlock()) {
                addStairsRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_stairs")), baseBlock);
                FabricRecipeProvider.offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_stairs")), baseBlock);
            }
            if (stoneType.getWallBlock()) {
                addWallRecipe(exporter, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_wall")), baseBlock);
                FabricRecipeProvider.offerStonecuttingRecipe(exporter,RecipeCategory.BUILDING_BLOCKS, Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_wall")), baseBlock);
            }
        }
    }

    public static void addFenceRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible fence, ItemConvertible baseBlock) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, fence, 3)
                .input('W', baseBlock).input('#', Items.STICK)
                .pattern("W#W").pattern("W#W")
                .criterion(RecipeProvider.hasItem(baseBlock), RecipeProvider.conditionsFromItem(baseBlock))
                .offerTo(exporter);
    }

    public static void addFenceGateRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible fenceGate, ItemConvertible baseBlock) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, fenceGate)
                .input('#', Items.STICK).input('W', baseBlock)
                .pattern("#W#").pattern("#W#")
                .criterion(RecipeProvider.hasItem(baseBlock), RecipeProvider.conditionsFromItem(baseBlock))
                .offerTo(exporter);
    }

    public static void addSlabRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible slab, ItemConvertible baseBlock) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, slab, 6)
                .input('#', baseBlock)
                .pattern("###")
                .criterion(RecipeProvider.hasItem(baseBlock), RecipeProvider.conditionsFromItem(baseBlock))
                .offerTo(exporter);
    }

    public static void addStairsRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible stair, ItemConvertible baseBlock) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, stair, 4)
                .input('#', baseBlock)
                .pattern("#  ").pattern("## ").pattern("###")
                .criterion(RecipeProvider.hasItem(baseBlock), RecipeProvider.conditionsFromItem(baseBlock))
                .offerTo(exporter);
    }

    public static void addWallRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible wall, ItemConvertible baseBlock) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, wall, 6)
                .input('#', baseBlock)
                .pattern("###").pattern("###")
                .criterion(RecipeProvider.hasItem(baseBlock), RecipeProvider.conditionsFromItem(baseBlock))
                .offerTo(exporter);
    }
}