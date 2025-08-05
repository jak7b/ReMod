package net.kuko.remod.block.custom

import net.kuko.remod.block.entity.PedestalBlockEntity
import net.kuko.remod.init.BlockInit
import net.kuko.remod.init.ItemInit
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.ItemScatterer
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.World


class PedestalBlock public constructor(settings: Settings) : BlockWithEntity(settings), BlockEntityProvider {
    val SHAPE: VoxelShape = Block.createCuboidShape(2.0, 0.0, 2.0,
        14.0, 13.0, 14.0);

    @Deprecated("Deprecated in Java")
    override fun getOutlineShape(state: BlockState, world: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape = SHAPE

    override fun getRenderType(state: BlockState): BlockRenderType = BlockRenderType.MODEL

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity = PedestalBlockEntity(pos, state)

    @Deprecated("Deprecated in Java")
    override fun onStateReplaced(state: BlockState, world: World, pos: BlockPos, newState: BlockState, moved: Boolean) {
        if (state.block != newState.block) {
            val blockEntity = world.getBlockEntity(pos)
            if (blockEntity is PedestalBlockEntity) {
                ItemScatterer.spawn(world, pos, blockEntity)
                world.updateComparators(pos, this)
            }
            super.onStateReplaced(state, world, pos, newState, moved)
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        val stack: ItemStack = player.getStackInHand(hand)

        (world.getBlockEntity(pos) as? PedestalBlockEntity)?.let { pedestal ->
            if (!world.isClient) {
                when {
                    // Place item on empty pedestal
                    pedestal.isEmpty && !stack.isEmpty -> {
                        pedestal.setStack(0, stack.copyWithCount(1))
                        world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 2f)
                        stack.decrement(1)

                        pedestal.markDirty()
                        world.updateListeners(pos, state, state, 0)

                        val item = pedestal.getDisplayItem().item.name.toString()
                        player.sendMessage(Text.literal(item), false)

                    }

                    // Take item from pedestal (not sneaking)
                    !pedestal.isEmpty && stack.isEmpty && !player.isSneaking -> {
                        val stackOnPedestal: ItemStack = pedestal.getStack(0)
                        player.setStackInHand(hand, stackOnPedestal) // Fixed: use 'hand' parameter
                        world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f)
                        pedestal.clear()

                        pedestal.markDirty()
                        world.updateListeners(pos, state, state, 0)
                    }

                    // Open GUI when sneaking with empty hands on empty pedestal
                    pedestal.isEmpty && stack.isEmpty && player.isSneaking -> {
                        val screenHandlerFactory: NamedScreenHandlerFactory =
                            world.getBlockEntity(pos) as PedestalBlockEntity
                        player.openHandledScreen(screenHandlerFactory)
                    }
                }
            }
        }

        return ActionResult.SUCCESS
    }


}
