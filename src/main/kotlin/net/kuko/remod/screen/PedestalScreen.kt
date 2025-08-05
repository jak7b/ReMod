package net.kuko.remod.screen

import com.mojang.blaze3d.systems.RenderSystem
import net.kuko.remod.ReMod
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.render.GameRenderer
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text
import net.minecraft.util.Identifier

class PedestalScreen(handler: PedestalScreenHandler,
                     inventory: PlayerInventory,
                     title: Text
) : HandledScreen<PedestalScreenHandler>(handler, inventory, title) {
    private val TEXTURE: Identifier = Identifier(ReMod.MOD_ID, "textures/gui/pedestal_gui.png")


    override fun init() {
        super.init()
    }

    override fun drawBackground(
        context: DrawContext?,
        delta: Float,
        mouseX: Int,
        mouseY: Int
    ) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram)
        RenderSystem.setShaderColor(1f,1f,1f, 1f)
        RenderSystem.setShaderTexture(0, TEXTURE)
        var x = (width - backgroundWidth) / 2
        var y = (height - backgroundHeight) / 2
        context?.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight)
    }
}