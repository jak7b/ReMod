package net.kuko.remod.init

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.kuko.remod.ReMod
import net.minecraft.item.Item  
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ItemInit {





    fun item(name: String, item: Item): Item =
        Registry.register(Registries.ITEM, Identifier.of(ReMod.MOD_ID, name), item)

    fun init() {
        ReMod.LOGGER.info("Items have been initialized and registered for mod: " + ReMod.MOD_ID)
    }
}
// soon™