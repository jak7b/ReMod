package net.kuko.remod.item

import net.kuko.remod.ReMod
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.world.World

class CustomBucketItem(settings: Settings) : Item(settings) {
    override fun onCraft(stack: ItemStack, world: World, player: PlayerEntity) {
        ReMod.LOGGER.info("Item crafted: ${stack.item.name.string}. Player's name: ${player.name}")
        if (world.isClient) world.playSound(player, player.blockPos, SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK,
            SoundCategory.MASTER,1.6f,1.3f)
    }
    /**
     * My idea is: For ```this``` item to get the recipe.
     * Example: ```Diamond``` + ```Lava BUckets``` = ```CBT``` with variable ```X``` set to ```item``` to ```Diamond```
      */



}
