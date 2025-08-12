package net.kuko.remod

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.kuko.remod.item.ModItems
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.registry.RegistryKey
import org.slf4j.Logger
import org.slf4j.LoggerFactory


object ReMod : ModInitializer {
	const val MOD_ID: String = "remod"
	val LOGGER: Logger = LoggerFactory.getLogger(ReMod.MOD_ID)

	override fun onInitialize() {
		LOGGER.info("Mod: $MOD_ID, Has been loaded!")

		ModItems.itemInit()

		addItemsToMisc(ModItems.ORE_ALCHEMY_PICKAXE, ItemGroups.NATURAL)
	}


	fun addItemsToMisc(item: Item, itemGroup: RegistryKey<ItemGroup>) {
		ItemGroupEvents.modifyEntriesEvent(itemGroup)
			.register(ModifyEntries { entries: FabricItemGroupEntries? ->
                entries?.add(item)
			})
	}
}	