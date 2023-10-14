package net.xanthian.block_variety_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import net.xanthian.block_variety_expansion.Initialise;
import net.xanthian.block_variety_expansion.block.custom.ModStoneBlockEnum;
import net.xanthian.block_variety_expansion.block.custom.ModWoodBlockEnum;
import net.xanthian.block_variety_expansion.util.ModModels;
import net.xanthian.block_variety_expansion.util.ModTextureMap;

import java.util.Locale;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        for (ModWoodBlockEnum woodType : ModWoodBlockEnum.values()) {
            Block baseBlock = woodType.getBaseBlock();
            String woodName = woodType.name().toLowerCase(Locale.ENGLISH);

            Block fence = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_fence"));
            Block fence_gate = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_fence_gate"));
            Block slab = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_slab"));
            Block stairs = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_stairs"));
            Block wall = Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, woodName + "_wall"));

            if (woodName.endsWith("log") || woodName.endsWith("stem") || woodName.endsWith("block")) {

                generateFences(fence, TextureMap.sideAndEndForTop(baseBlock), blockStateModelGenerator);
                generateFenceGates(fence_gate, TextureMap.sideAndEndForTop(baseBlock), blockStateModelGenerator);
                generateSlabs(slab, baseBlock, TextureMap.sideAndEndForTop(baseBlock), blockStateModelGenerator);
                generateStairs(stairs, TextureMap.sideAndEndForTop(baseBlock), blockStateModelGenerator);
                generateWalls(wall, TextureMap.sideAndEndForTop(baseBlock), blockStateModelGenerator);

            } else if (woodName.endsWith("wood") || woodName.endsWith("hyphae")) {

                generateFences(fence, ModTextureMap.threeSides(baseBlock), blockStateModelGenerator);
                generateFenceGates(fence_gate, ModTextureMap.threeSides(baseBlock), blockStateModelGenerator);
                generateSlabs(slab, baseBlock, ModTextureMap.threeSides(baseBlock), blockStateModelGenerator);
                generateStairs(stairs, ModTextureMap.threeSides(baseBlock), blockStateModelGenerator);
                generateWalls(wall, ModTextureMap.threeSides(baseBlock), blockStateModelGenerator);

            }
        }

        for (ModStoneBlockEnum stoneType : ModStoneBlockEnum.values()) {
            Block baseBlock = stoneType.getBaseBlock();
            String stoneName = stoneType.name().toLowerCase(Locale.ENGLISH);

            generateBlockVariants(blockStateModelGenerator, baseBlock, stoneName, stoneType);
        }
    }

    private void generateBlockVariants(BlockStateModelGenerator blockStateModelGenerator, Block baseBlock, String stoneName, ModStoneBlockEnum stoneType) {
        TextureMap textureMap;

        if (stoneName.matches("purpur_pillar|deepslate|blackstone|quartz_pillar|chiseled_quartz|sandstone|red_sandstone")) {
            textureMap = ModTextureMap.normalTop(baseBlock);
        } else if (stoneName.matches("smooth_quartz|smooth_sandstone|smooth_red_sandstone")){
            textureMap = ModTextureMap.topTopTop(baseBlock);
        } else if (stoneName.matches("(?<!_)basalt|polished_basalt|bone")){
            textureMap = ModTextureMap.sideTopTop(baseBlock);
        } else if (stoneName.matches("reinforced_deepslate|quartz")) {
            textureMap = TextureMap.sideTopBottom(baseBlock);
        } else {
            textureMap = ModTextureMap.threeSides(baseBlock);
        }

        if (stoneType.getStairBlock()) {
            generateStairs(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_stairs")),
                    textureMap, blockStateModelGenerator);
        }

        if (stoneType.getSlabBlock()) {
            generateSlabs(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_slab")),
                    baseBlock, textureMap, blockStateModelGenerator);
        }

        if (stoneType.getFenceBlock()) {
            generateFences(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_fence")),
                    textureMap, blockStateModelGenerator);
        }

        if (stoneType.getWallBlock()) {
            generateWalls(Registries.BLOCK.get(new Identifier(Initialise.MOD_ID, stoneName + "_wall")),
                    textureMap, blockStateModelGenerator);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }

    void generateSlabs(Block slab, Block fullBlock, TextureMap texture, BlockStateModelGenerator blockStateModelGenerator) {
        var slabUpper = Models.SLAB_TOP.upload(slab, texture, blockStateModelGenerator.modelCollector);
        var slabLower = Models.SLAB.upload(slab, texture, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slab, slabLower, slabUpper, ModelIds.getBlockModelId(fullBlock)));
        blockStateModelGenerator.registerParentedItemModel(slab, slabLower);
    }

    void generateStairs(Block stairs, TextureMap texture, BlockStateModelGenerator blockStateModelGenerator) {
        var stairsNormal = Models.STAIRS.upload(stairs, texture, blockStateModelGenerator.modelCollector);
        var stairsInner = Models.INNER_STAIRS.upload(stairs, texture, blockStateModelGenerator.modelCollector);
        var stairsOuter = Models.OUTER_STAIRS.upload(stairs, texture, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stairs, stairsInner, stairsNormal, stairsOuter));
        blockStateModelGenerator.registerParentedItemModel(stairs, stairsNormal);
    }

    void generateFences(Block fence, TextureMap texture, BlockStateModelGenerator blockStateModelGenerator) {
        var fenceInv = ModModels.MOD_FENCE_INVENTORY.upload(fence, texture, blockStateModelGenerator.modelCollector);
        var fencePost = ModModels.MOD_FENCE_POST.upload(fence, texture, blockStateModelGenerator.modelCollector);
        var fenceSide = ModModels.MOD_FENCE_SIDE.upload(fence, texture, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(fence, fencePost, fenceSide));
        blockStateModelGenerator.registerParentedItemModel(fence, fenceInv);
    }

    void generateWalls(Block wall, TextureMap texture, BlockStateModelGenerator blockStateModelGenerator) {
        var wallPost = ModModels.MOD_WALL_POST.upload(wall, texture, blockStateModelGenerator.modelCollector);
        var wallSide = ModModels.MOD_WALL_SIDE.upload(wall, texture, blockStateModelGenerator.modelCollector);
        var wallSideTall = ModModels.MOD_WALL_SIDE_TALL.upload(wall, texture, blockStateModelGenerator.modelCollector);
        var wallInv = ModModels.MOD_WALL_INVENTORY.upload(wall, texture, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wall, wallPost, wallSide, wallSideTall));
        blockStateModelGenerator.registerParentedItemModel(wall, wallInv);
    }

    void generateFenceGates(Block fencegate, TextureMap texture, BlockStateModelGenerator blockStateModelGenerator) {
        Identifier fenceGateOpen = ModModels.MOD_FENCE_GATE_OPEN.upload(fencegate, texture, blockStateModelGenerator.modelCollector);
        Identifier fenceGate = ModModels.MOD_FENCE_GATE.upload(fencegate, texture, blockStateModelGenerator.modelCollector);
        Identifier fenceGateWallOpen = ModModels.MOD_FENCE_GATE_WALL_OPEN.upload(fencegate, texture, blockStateModelGenerator.modelCollector);
        Identifier fenceGateWall = ModModels.MOD_FENCE_GATE_WALL.upload(fencegate, texture, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createFenceGateBlockState(fencegate, fenceGateOpen, fenceGate, fenceGateWallOpen, fenceGateWall, false));
    }

}