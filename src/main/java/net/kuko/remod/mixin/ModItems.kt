package net.kuko.remod.mixin

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.kuko.remod.ReMod.LOGGER
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

//object ModItems {
//    val RUBY: Item = registerItem("ruby", Item(FabricItemSettings()))
//    val RAW_RUBY: Item = registerItem("raw_ruby", Item(FabricItemSettings()))
//
//    private fun addItemsToIngredientItemGroup(entries: FabricItemGroupEntries) {
//        entries.add(RUBY)
//        entries.add(RAW_RUBY)
//    }
//
//    private fun registerItem(name: String, item: Item?): Item {
//        return Registry.register<Item?, Item>(Registries.ITEM, Identifier("a", name), item)
//    }
//
//    fun registerModItems() {
//        LOGGER.info("Registering Mod Items for " + "a") // Why error here?
//
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
//            .register { entries -> ModItems.addItemsToIngredientItemGroup(entries) }
//    }
//}
