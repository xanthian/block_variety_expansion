package net.xanthian.block_variety_expansion.util;

import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import net.xanthian.block_variety_expansion.Initialise;

import java.util.Optional;

public class ModModels {

    public static final Model MOD_FENCE_POST;
    public static final Model MOD_FENCE_SIDE;
    public static final Model MOD_FENCE_INVENTORY;
    public static final Model MOD_WALL_INVENTORY;
    public static final Model MOD_WALL_POST;
    public static final Model MOD_WALL_SIDE;
    public static final Model MOD_WALL_SIDE_TALL;
    public static final Model MOD_FENCE_GATE;
    public static final Model MOD_FENCE_GATE_OPEN;
    public static final Model MOD_FENCE_GATE_WALL;
    public static final Model MOD_FENCE_GATE_WALL_OPEN;

    static {

        MOD_FENCE_POST = createModel("fence_post", "_post", TextureKey.TOP, TextureKey.SIDE);
        MOD_FENCE_SIDE = createModel("fence_side", "_side", TextureKey.TOP, TextureKey.SIDE);
        MOD_FENCE_INVENTORY = createModel("fence_inventory", "_inventory", TextureKey.TOP, TextureKey.SIDE);
        MOD_WALL_INVENTORY = createModel("wall_inventory", "_inventory", TextureKey.TOP, TextureKey.SIDE);
        MOD_WALL_POST = createModel("template_wall_post", "_post", TextureKey.TOP, TextureKey.SIDE);
        MOD_WALL_SIDE = createModel("template_wall_side", "_side", TextureKey.SIDE);
        MOD_WALL_SIDE_TALL = createModel("template_wall_side_tall", "_side_tall", TextureKey.SIDE);
        MOD_FENCE_GATE = createModel("template_fence_gate", "", TextureKey.TOP, TextureKey.SIDE);
        MOD_FENCE_GATE_OPEN = createModel("template_fence_gate_open", "_open", TextureKey.TOP, TextureKey.SIDE);
        MOD_FENCE_GATE_WALL = createModel("template_fence_gate_wall", "_wall", TextureKey.TOP, TextureKey.SIDE);
        MOD_FENCE_GATE_WALL_OPEN = createModel("template_fence_gate_wall_open", "_wall_open", TextureKey.TOP, TextureKey.SIDE);

    }

    public static Model createModel(String parent, String variant, TextureKey... requiredTextures) {
        return new Model(Optional.of(new Identifier(Initialise.MOD_ID, "block/" + parent)), Optional.of(variant), requiredTextures);
    }
}