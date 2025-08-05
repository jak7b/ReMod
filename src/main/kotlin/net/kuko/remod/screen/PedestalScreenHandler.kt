package net.kuko.remod.screen

import net.kuko.remod.init.ScreenHandlersInit.PEDESTAL_SCREEN_HANDLER
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot
import net.minecraft.util.math.BlockPos

class PedestalScreenHandler(syncId: Int, playerInventory: PlayerInventory, blockEntity: BlockEntity?) :
    ScreenHandler(PEDESTAL_SCREEN_HANDLER, syncId) {
    private val inventory: Inventory

    constructor(syncId: Int, playerInventory: PlayerInventory, pos: BlockPos) : this(
        syncId,
        playerInventory,
        playerInventory.player.world.getBlockEntity(pos)
    )

    init {
        this.inventory = (blockEntity as Inventory)

        this.addSlot(object : Slot(inventory, 0, 80, 35) {
            override fun getMaxItemCount(): Int {
                return 1
            }
        })

        addPlayerInventory(playerInventory)
        addPlayerHotbar(playerInventory)
    }


    override fun quickMove(player: PlayerEntity, invSlot: Int): ItemStack {
        var newStack = ItemStack.EMPTY
        val slot = this.slots[invSlot]
        if (slot != null && slot.hasStack()) {
            val originalStack = slot.stack
            newStack = originalStack.copy()
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size, true)) {
                    return ItemStack.EMPTY
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY
            }

            if (originalStack.isEmpty) {
                slot.stack = ItemStack.EMPTY
            } else {
                slot.markDirty()
            }
        }
        return newStack
    }

    override fun canUse(player: PlayerEntity ): Boolean {
        return this.inventory.canPlayerUse(player)
    }

    private fun addPlayerInventory(playerInventory: PlayerInventory ) {
        for (i in 0..2) {
            for (l in 0..8) {
                this.addSlot(Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18))
            }
        }
    }

    private fun addPlayerHotbar(playerInventory: PlayerInventory ) {
        for (i in 0..8) {
            this.addSlot(Slot(playerInventory, i, 8 + i * 18, 142))
        }
    }
}
