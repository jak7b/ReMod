package net.kuko.remod.init

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.kuko.remod.ReMod
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.minecraft.item.ItemGroup

object ItemGroupsInit {
    val RUBY_GROUP: ItemGroup = Registry.register(
        Registries.ITEM_GROUP,
        Identifier(ReMod.MOD_ID, "ruby"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.ruby"))
            .icon { ItemStack(Items.NETHERITE_INGOT) }
            .entries { displayContext, entries ->
                entries.add(BlockInit.PEDESTAL)
            }
            .build()
    )

    fun itemGroupInit() {
        ReMod.LOGGER.info("Registering Item Groups for ${ReMod.MOD_ID}")
    }
}
