package net.xanthian.block_variety_expansion.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.registry.tag.TagKey;
import net.xanthian.block_variety_expansion.util.ModBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PaneBlock.class)
public class PaneBlockMixin {

    @WrapOperation(method = "connectsTo", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    private boolean blockvarietyexpansion$woodenWallsConnectToPanes(BlockState blockState, TagKey<Block> tagKey, Operation<Boolean> original) {
        return original.call(blockState, tagKey) || blockState.isIn(ModBlockTags.WOODEN_WALLS);
    }
}