package net.kuko.remod

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.minecraft.text.Text
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ReMod : ModInitializer {
	const val MOD_ID: String = "remod"
	val LOGGER: Logger = LoggerFactory.getLogger(ReMod.MOD_ID)

	override fun onInitialize() {
		LOGGER.info("Mod: $MOD_ID, Has been loaded!")

	}
}