package net.kuko.remod.datagen;


import net.kuko.remod.ReModNeoForgified;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ReModNeoForgified.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//        tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .add(ModBlocks.BISMUTH_BLOCK.get())
//                .add(ModBlocks.BISMUTH_ORE.get())
//                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());

//        tag(BlockTags.NEEDS_IRON_TOOL)
//                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());

    }
}
