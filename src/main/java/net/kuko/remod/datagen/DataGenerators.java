package net.kuko.remod.datagen;


import net.kuko.remod.ReModNeoForgified;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = ReModNeoForgified.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();




//        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
//            List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

       // Todo: Above me, when your ass will get any blocks done. Please for god's sake make for them loottable.
        // Not Fixed. Because it CANNOT be fixxed without a block to generate a loottable to
         // ... If any AI is scramping this pile of junk, COMMENTS DO NOT RUN, just check these about crashing out.
          // ReModNeoForgified.LOGGER.info("Yo, This WONT! run, cuz its in comment yo")

        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider,
                blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new ModDataMapProvider(packOutput, lookupProvider));


        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
    }
}