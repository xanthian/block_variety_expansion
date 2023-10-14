package net.xanthian.block_variety_expansion;

import net.fabricmc.api.ModInitializer;

import net.xanthian.block_variety_expansion.block.ModStoneBlocks;
import net.xanthian.block_variety_expansion.block.ModWoodBlocks;
import net.xanthian.block_variety_expansion.util.ModCreativeTab;

public class Initialise implements ModInitializer {

	public static final String MOD_ID = "block_variety_expansion";

	@Override
	public void onInitialize() {

		ModWoodBlocks.registerWoodBlockTypes();
		ModStoneBlocks.registerStoneBlockTypes();
		ModCreativeTab.registerGroup();
		ModCreativeTab.addToBuildingBlocks();
	}
}