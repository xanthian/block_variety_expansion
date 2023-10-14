package net.xanthian.block_variety_expansion.util;

import net.minecraft.block.Block;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.util.Identifier;

public class ModTextureMap extends TextureMap {

    public static TextureMap threeSides(Block baseBlock) {
        Identifier id = getId(baseBlock);
        String path = id.getPath();

        if (path.endsWith("_wood") || path.endsWith("_hyphae")) {
            String modifiedPath = path.endsWith("_wood") ? path.replace("_wood", "_log") : path.replace("_hyphae", "_stem");
            Identifier modifiedTexture = new Identifier(id.getNamespace(), modifiedPath);

            return (new ModTextureMap())
                    .put(TextureKey.BOTTOM, modifiedTexture)
                    .put(TextureKey.SIDE, modifiedTexture)
                    .put(TextureKey.TOP, modifiedTexture);
        }

        return (new ModTextureMap())
                .put(TextureKey.BOTTOM, id)
                .put(TextureKey.SIDE, id)
                .put(TextureKey.TOP, id);
    }

    public static TextureMap sideTopTop(Block block) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_side"))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(block, "_top"));
    }
    public static TextureMap topTopTop(Block block) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(block, "_top"));
    }
    public static TextureMap normalTop(Block block) {
        return new TextureMap()
                .put(TextureKey.SIDE, TextureMap.getId(block))
                .put(TextureKey.TOP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(block, "_top"));
    }
}