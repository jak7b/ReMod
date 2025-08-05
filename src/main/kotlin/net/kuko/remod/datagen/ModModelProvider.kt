package net.kuko.remod.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.kuko.remod.init.BlockInit
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models

class ModModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator?) {
        blockStateModelGenerator?.registerSimpleState(BlockInit.PEDESTAL)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
    //    itemModelGenerator.register(ModItems.RUBY, Models.GENERATED)
    }
}
