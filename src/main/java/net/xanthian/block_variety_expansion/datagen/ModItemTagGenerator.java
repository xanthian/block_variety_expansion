package net.xanthian.block_variety_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.xanthian.block_variety_expansion.Initialise;
import net.xanthian.block_variety_expansion.block.custom.ModStoneBlockEnum;
import net.xanthian.block_variety_expansion.block.custom.ModWoodBlockEnum;
import net.xanthian.block_variety_expansion.util.ModItemTags;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;


public class ModItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ModItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {


        for (ModWoodBlockEnum woodType : ModWoodBlockEnum.values()) {
            String woodName = woodType.name().toLowerCase(Locale.ENGLISH);

            Item fence = Registries.ITEM.get(new Identifier(Initialise.MOD_ID, woodName + "_fence"));
            Item fence_gate = Registries.ITEM.get(new Identifier(Initialise.MOD_ID, woodName + "_fence_gate"));
            Item slab = Registries.ITEM.get(new Identifier(Initialise.MOD_ID, woodName + "_slab"));
            Item stairs = Registries.ITEM.get(new Identifier(Initialise.MOD_ID, woodName + "_stairs"));
            Item wall = Registries.ITEM.get(new Identifier(Initialise.MOD_ID, woodName + "_wall"));

            getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(fence);
            getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(fence_gate);
            getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(slab);
            getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(stairs);
            getOrCreateTagBuilder(ModItemTags.WOODEN_WALLS).add(wall);

        }
        String[] itemSuffixes = {"fence", "slab", "stairs", "wall"};
        for (String suffix : itemSuffixes) {

            getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD).add(Registries.ITEM.get(new Identifier(Initialise.MOD_ID, "crimson_stem_" + suffix)));
            getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD).add(Registries.ITEM.get(new Identifier(Initialise.MOD_ID, "crimson_hyphae_" + suffix)));
            getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD).add(Registries.ITEM.get(new Identifier(Initialise.MOD_ID, "warped_stem_" + suffix)));
            getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD).add(Registries.ITEM.get(new Identifier(Initialise.MOD_ID, "warped_hyphae_" + suffix)));
            getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD).add(Registries.ITEM.get(new Identifier(Initialise.MOD_ID, "stripped_crimson_stem_" + suffix)));
            getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD).add(Registries.ITEM.get(new Identifier(Initialise.MOD_ID, "stripped_crimson_hyphae_" + suffix)));
            getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD).add(Registries.ITEM.get(new Identifier(Initialise.MOD_ID, "stripped_warped_stem_" + suffix)));
            getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD).add(Registries.ITEM.get(new Identifier(Initialise.MOD_ID, "stripped_warped_hyphae_" + suffix)));
        }

        for (ModStoneBlockEnum stoneType : ModStoneBlockEnum.values()) {
            String stoneName = stoneType.name().toLowerCase(Locale.ENGLISH);

            Item fence = Registries.ITEM.get(new Identifier(Initialise.MOD_ID, stoneName + "_fence"));
            Item slab = Registries.ITEM.get(new Identifier(Initialise.MOD_ID, stoneName + "_slab"));
            Item stairs = Registries.ITEM.get(new Identifier(Initialise.MOD_ID, stoneName + "_stairs"));
            Item wall = Registries.ITEM.get(new Identifier(Initialise.MOD_ID, stoneName + "_wall"));

            if (stoneType.getFenceBlock()) {
                getOrCreateTagBuilder(ItemTags.FENCES).add(fence);
            }
            if (stoneType.getSlabBlock()) {
                getOrCreateTagBuilder(ItemTags.SLABS).add(slab);
            }
            if (stoneType.getStairBlock()) {
                getOrCreateTagBuilder(ItemTags.STAIRS).add(stairs);
            }
            if (stoneType.getWallBlock()) {
                getOrCreateTagBuilder(ItemTags.WALLS).add(wall);
            }

        }
        String[] blockSuffixes = {"fence", "slab", "stairs", "wall"};
        for (String suffix : blockSuffixes) {

            getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED).add(Registries.ITEM.get(new Identifier(Initialise.MOD_ID, "gold_" + suffix)));

        }
    }
}