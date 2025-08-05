package net.kuko.remod.init

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.kuko.remod.ReMod
import net.kuko.remod.ReMod.MOD_ID
import net.kuko.remod.block.entity.PedestalBlockEntity
import net.kuko.remod.init.BlockInit.PEDESTAL
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos

object BlockEntitiesInit {
    val PEDESTAL_BE: BlockEntityType<PedestalBlockEntity?>? =
        Registry.register<BlockEntityType<*>?, BlockEntityType<PedestalBlockEntity?>?>(
            Registries.BLOCK_ENTITY_TYPE, Identifier(ReMod.MOD_ID, "gem_polishing_be"),
            FabricBlockEntityTypeBuilder.create<PedestalBlockEntity>(
                FabricBlockEntityTypeBuilder.Factory { pos: BlockPos, state: BlockState ->
                    PedestalBlockEntity(
                        pos,
                        state
                    )
                },
                PEDESTAL
            ).build()
        )


    fun blockEntityInit() {
        ReMod.LOGGER.info("Block Entities have been initialized and registered for mod: $MOD_ID")
    }
}
