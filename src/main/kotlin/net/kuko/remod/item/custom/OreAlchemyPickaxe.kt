package net.kuko.remod.item.custom

import net.minecraft.block.BlockState
import net.minecraft.item.ItemStack
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ToolMaterial

class OreAlchemyPickaxe(material: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) : PickaxeItem(material, attackDamage, attackSpeed, settings) {
    val EXTRA_DAMAGE: Float = 5.0f
    val ATTACK_SPEED: Float = -2.8f

    override fun hasGlint(stack: ItemStack?): Boolean {
        return true
    }

    override fun getDefaultStack(): ItemStack? {
        return ItemStack(this)
    }

    override fun getMiningSpeedMultiplier(stack: ItemStack?, state: BlockState?): Float {
        return 1000.0f
    }
}
