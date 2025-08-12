package net.kuko.remod.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.kuko.remod.ReMod
import net.kuko.remod.item.custom.OreAlchemyPickaxe
import net.minecraft.item.Item
import net.minecraft.item.ToolMaterials
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier


object ModItems {
//    val TEST_ITEM: Item = item("test_item", Item(FabricItemSettings()))
//    val ADVANCED_ITEM: Item = item("advanced_item", Item(FabricItemSettings().maxCount(16)))

    val ORE_ALCHEMY_PICKAXE: Item = item("ore_alchemy_pickaxe",
        OreAlchemyPickaxe(ToolMaterials.NETHERITE, 1, -2.8F,  Item.Settings().fireproof( )))

    fun item(name: String, item: Item): Item = Registry.register(Registries.ITEM, Identifier(ReMod.MOD_ID, name), item)

    fun itemInit() {
        ReMod.LOGGER.info("Items for ${ReMod.MOD_ID}")
    }
}