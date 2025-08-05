package net.kuko.remod.init

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.kuko.remod.ReMod
import net.kuko.remod.ReMod.MOD_ID
import net.kuko.remod.block.custom.PedestalBlock
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object BlockInit {
    val PEDESTAL = registerBlock("pedestal", PedestalBlock(
        FabricBlockSettings.create()
            .nonOpaque())
    )


    private fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register(Registries.BLOCK, Identifier(ReMod.MOD_ID, name), block)
    }

    private fun registerBlockItem(name: String, block: Block): Item = Registry.register(Registries.ITEM, Identifier.of(
        ReMod.MOD_ID, name), BlockItem(block, FabricItemSettings()))

    fun blockInit() {
        ReMod.LOGGER.info("Items have been initialized and registered for mod: $MOD_ID")
    }
}