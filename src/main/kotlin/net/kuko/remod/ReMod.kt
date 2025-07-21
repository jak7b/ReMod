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

/**
 * * Molten metals system: pouring molten metals into molds to create items.
 *
 *  + Idea inspired by crafting mechanics involving molten metals, molds, and upgrades.
 *  + Planned mod name: **Steelshift**. - dusty45
 *
 * ? Features outline:
 * - Obtain molten metals by crafting a lava bucket with a block of the metal.
 * todo: make this crap
 *
 * - Use a Mold Table with a GUI to combine molten metal buckets with molds,
 *   producing items and returning the empty bucket and a damaged mold (molds have durability).
 * - Use an Assembly Station to upgrade armor, weapons, or tools by applying crafted parts,
 *   granting special abilities or enhancements.
 *
 * * Example workflow:
 *? 1. Crafting molten metal:
 *    - Input: Block of Steel + Lava Bucket
 *    - Output: Bucket of Molten Steel
 *
 *? 2. Mold Table crafting:
 *    - Input: Bucket of Molten Steel + Spring Mold
 *    - Output: Spring + Empty Bucket + Damaged Spring Mold
 *
 *? 3. Assembly Station upgrade:
 *   - Right-click Netherite Boots with Spring
 *    - Output: Spring Boots (boots gain ability to launch the player a few blocks into the air)
 *
 * ? Planned additional features:
 * - Magnets, springs, and other crafted parts that can upgrade gear.
 * - Armor/weapon/tool upgrades with unique abilities.
 *
 * Open to community ideas and contributions! < :hypers:919650434191335477 >
 *
 * Any suggestions or ideas are welcome! < :peperose:960605861292683274 >
 */
