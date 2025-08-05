package net.kuko.remod.init

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType.ExtendedFactory
import net.kuko.remod.ReMod
import net.kuko.remod.ReMod.MOD_ID
import net.kuko.remod.screen.PedestalScreenHandler
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier


object ScreenHandlersInit {

    val PEDESTAL_SCREEN_HANDLER: ScreenHandlerType<PedestalScreenHandler> =
        Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier(ReMod.MOD_ID, "pedestal"),
            ExtendedScreenHandlerType { syncId, inv, buf ->
                PedestalScreenHandler(syncId, inv, buf.readBlockPos())
            }
        )

    fun screenHandlerInit() {
        ReMod.LOGGER.info("Registering Screen Handlers for $MOD_ID");
    }
}