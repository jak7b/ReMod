package net.kuko.remod.data;


import net.kuko.remod.ReModNeoForgified;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ReModNeoForgified.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        basicItem(ModItems.BISMUTH.get());
//        basicItem(ModItems.RAW_BISMUTH.get());
//
//        basicItem(ModItems.RADISH.get());
//        basicItem(ModItems.STARLIGHT_ASHES.get());
//        basicItem(ModItems.FROSTFIRE_ICE.get());
//        basicItem(ModItems.CHISEL.get());

        basicItem(Items.DIAMOND);
    }
}