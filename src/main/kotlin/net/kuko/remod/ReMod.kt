package net.kuko.remod

import net.fabricmc.api.ModInitializer
import net.kuko.remod.init.ItemInit
import org.slf4j.LoggerFactory

object ReMod : ModInitializer {
	const val MOD_ID = "remod"
	val LOGGER = LoggerFactory.getLogger(ReMod.MOD_ID)

	override fun onInitialize() {
		LOGGER.info("Hello Fabric world!")
		ItemInit.init()
	}
}