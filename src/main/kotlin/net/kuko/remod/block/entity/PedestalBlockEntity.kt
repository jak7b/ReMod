package net.kuko.remod.block.entity

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory
import net.kuko.remod.init.BlockEntitiesInit
import net.kuko.remod.screen.PedestalScreenHandler
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.PacketByteBuf
import net.minecraft.network.listener.ClientPlayPacketListener
import net.minecraft.network.packet.Packet
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
import net.minecraft.screen.ScreenHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos


class PedestalBlockEntity(
    type: BlockEntityType<PedestalBlockEntity?>?,
    pos: BlockPos?,
    state: BlockState?
) : BlockEntity(type, pos, state), ExtendedScreenHandlerFactory, ImplementedInventory {
    val inventory: DefaultedList<ItemStack> = DefaultedList.ofSize(1, ItemStack.EMPTY)
    constructor(pos: BlockPos?, state: BlockState?) : this(BlockEntitiesInit.PEDESTAL_BE, pos, state)

    private val INPUT_SLOT = 0


    override fun writeScreenOpeningData(player: ServerPlayerEntity, buf: PacketByteBuf) {
        buf.writeBlockPos(this.pos)
    }

    override fun getItems(): DefaultedList<ItemStack> {
        return inventory
    }

    override fun markDirty() {}

    override fun getDisplayName(): Text {
        return Text.literal("Pedestal")
    }

    override fun writeNbt(nbt: NbtCompound) {
        super.writeNbt(nbt)
        Inventories.writeNbt(nbt, inventory)
    }

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
        Inventories.readNbt(nbt, inventory)
    }

    override fun toUpdatePacket(): Packet<ClientPlayPacketListener?>? {
        return BlockEntityUpdateS2CPacket.create(this)
    }

    override fun toInitialChunkDataNbt(): NbtCompound {
        return createNbt()
    }

    override fun createMenu(
        syncId: Int,
        playerInventory: PlayerInventory,
        player: PlayerEntity
    ): ScreenHandler? {
        return PedestalScreenHandler(syncId, playerInventory, this)
    }

    // Get the item in the pedestal
    fun getDisplayItem(): ItemStack {
        return inventory[INPUT_SLOT]
    }

    // Get full NBT data
    fun getNbtData(): NbtCompound {
        return createNbt()
    }

    // Get specific NBT value (example)
    fun getCustomProperty(key: String): String {
        val nbt = createNbt()
        return nbt.getString(key)
    }
}
