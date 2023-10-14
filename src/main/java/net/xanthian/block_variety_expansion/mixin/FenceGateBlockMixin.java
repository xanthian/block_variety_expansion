package net.xanthian.block_variety_expansion.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.registry.tag.TagKey;

import net.xanthian.block_variety_expansion.util.ModBlockTags;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FenceGateBlock.class)
public class FenceGateBlockMixin {

    @WrapOperation(method = "isWall", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    private boolean blockvarietyexpansion$isWallWoodenWalls(BlockState blockState, TagKey<Block> tagKey, Operation<Boolean> original) {
        return original.call(blockState, tagKey) || blockState.isIn(ModBlockTags.WOODEN_WALLS);
    }
}