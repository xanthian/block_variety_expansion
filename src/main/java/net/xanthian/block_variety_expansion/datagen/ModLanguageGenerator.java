package net.xanthian.block_variety_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import net.xanthian.block_variety_expansion.Initialise;
import org.apache.commons.lang3.text.WordUtils;


import java.util.List;

public class ModLanguageGenerator  extends FabricLanguageProvider {
    public ModLanguageGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override

    public void generateTranslations(TranslationBuilder translationBuilder) {

        List<Block> blockList = Registries.BLOCK.getIds()
                .stream()
                .filter(identifier -> identifier.getNamespace().equals(Initialise.MOD_ID))
                .map(Registries.BLOCK::get)
                .toList();

        for (Block block : blockList) {
            String blockName = Registries.BLOCK.getId(block).getPath();
            String translatedBlockName = WordUtils.capitalizeFully(blockName.replace("_", " "));
            translationBuilder.add(new Identifier("block." + Initialise.MOD_ID, blockName), translatedBlockName);
        }
    }
}