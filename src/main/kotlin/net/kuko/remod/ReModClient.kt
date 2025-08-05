package net.kuko.remod

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.kuko.remod.block.entity.PedestalBlockEntity
import net.kuko.remod.init.ScreenHandlersInit
import net.kuko.remod.screen.PedestalScreen
import net.kuko.remod.screen.PedestalScreenHandler
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.gui.screen.ingame.HandledScreens
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.screen.ScreenHandler
import net.minecraft.text.Text

// In ReModClient.kt
object ReModClient : ClientModInitializer {
    override fun onInitializeClient() {
        HandledScreens.register(ScreenHandlersInit.PEDESTAL_SCREEN_HANDLER, ::PedestalScreen)
    }
}