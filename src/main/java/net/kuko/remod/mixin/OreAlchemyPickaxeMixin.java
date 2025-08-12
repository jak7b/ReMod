package net.kuko.remod.mixin;

import java.util.Arrays;
import java.util.List;

import net.kuko.remod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin({Block.class})
public class OreAlchemyPickaxeMixin {
    @Inject(
            method = {"afterBreak"},
            at = {@At("TAIL")}
    )
    private void oreAlchemyPickaxe$transformStone(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool, CallbackInfo ci) {
        if (!world.isClient && tool.isOf(ModItems.INSTANCE.getORE_ALCHEMY_PICKAXE())) {
            Block brokenBlock = state.getBlock();
            boolean isStone = brokenBlock == Blocks.STONE;
            boolean isDeepslate = brokenBlock == Blocks.DEEPSLATE;
            if (isStone || isDeepslate) {
                Block newOre;
                List regularOres;
                if (isStone) {
                    regularOres = Arrays.asList(Blocks.COAL_ORE, Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.DIAMOND_ORE, Blocks.EMERALD_ORE, Blocks.REDSTONE_ORE, Blocks.LAPIS_ORE, Blocks.COPPER_ORE);
                    newOre = (Block)regularOres.get(world.getRandom().nextInt(regularOres.size()));
                } else {
                regularOres = Arrays.asList(Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE_COPPER_ORE);
                    newOre = (Block)regularOres.get(world.getRandom().nextInt(regularOres.size()));
                }

                world.setBlockState(pos, newOre.getDefaultState());
                world.playSound((Entity)null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 0.8F, 1.2F);
                if (world instanceof ServerWorld) {
                    ServerWorld serverWorld = (ServerWorld)world;
                    serverWorld.spawnParticles(ParticleTypes.ENCHANT, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 8, 0.3D, 0.3D, 0.3D, 0.1D);
                }

            }
        }
    }
}
