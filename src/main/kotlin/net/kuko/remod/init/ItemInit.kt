package net.kuko.remod.init

import net.kuko.remod.ReMod
import net.kuko.remod.ReMod.MOD_ID
import net.minecraft.item.Item  
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ItemInit {





    fun item(name: String, item: Item): Item =
        Registry.register(Registries.ITEM, Identifier.of(ReMod.MOD_ID, name), item)

    fun itemInit() {
        ReMod.LOGGER.info("Items have been initialized and registered for mod: $MOD_ID")
    }
}
// soon™