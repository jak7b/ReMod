package net.kuko.remod.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.kuko.remod.init.ItemInit
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import net.minecraft.recipe.Recipe
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier
import java.util.List
import java.util.function.Consumer

class ModRecipeProvider(output: FabricDataOutput) : FabricRecipeProvider(output) {
    override fun generate(exporter: Consumer<RecipeJsonProvider>) {

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.CUSTOM_BUCKET, 1)
            .input(Items.LAVA_BUCKET)
            .input(Items.IRON_BLOCK)
            .criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET))
            .criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_BLOCK))
            .offerTo(exporter, Identifier(getRecipeName(ItemInit.CUSTOM_BUCKET)))

    }

}
