package net.kuko.remod.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.kuko.remod.ReMod
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier


object ItemInit {
    val EXAMPLE_BUCKET : Item = registerItem("example_bucket", test(FabricItemSettings()))

    fun registerItem(name: String, item: Item): Item = Registry.register(Registries.ITEM,
        Identifier.of(ReMod.MOD_ID, name), item
    )

    fun init() {
        ReMod.LOGGER.info("Items have been initlized and registrated for mod: " + ReMod.MOD_ID)
    }
}