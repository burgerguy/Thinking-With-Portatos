package com.fusionflux.portalcubed.blocks.blockentities;

import com.fusionflux.portalcubed.blocks.PortalCubedBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ExcursionFunnelEntity extends ExcursionFunnelEntityAbstract {

    public ExcursionFunnelEntity(BlockPos pos, BlockState state) {
        super(PortalCubedBlocks.EXCURSION_FUNNEL_ENTITY, pos, state);
    }

    public static void tick2(World world, BlockPos pos, BlockState state, ExcursionFunnelEntity blockEntity) {
        assert world != null;
        if (!world.isClient) {
            if (blockEntity.emitters != null) {
                if (!(world.getBlockEntity(blockEntity.emitters) instanceof ExcursionFunnelEmitterEntityAbstract)) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                } else if (!((ExcursionFunnelEmitterEntityAbstract) Objects.requireNonNull(world.getBlockEntity(blockEntity.emitters))).posXList.contains(blockEntity.pos.getX()) && !((ExcursionFunnelEmitterEntityAbstract) Objects.requireNonNull(world.getBlockEntity(blockEntity.emitters))).posYList.contains(blockEntity.pos.getY()) && !((ExcursionFunnelEmitterEntityAbstract) Objects.requireNonNull(world.getBlockEntity(blockEntity.emitters))).posZList.contains(blockEntity.pos.getZ())) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                }else if( !(world.getBlockEntity(blockEntity.emitters) instanceof DuelExcursionFunnelEmitterEntity && !world.isReceivingRedstonePower(blockEntity.emitters))){

                    if((world.getBlockEntity(blockEntity.emitters) instanceof ExcursionFunnelEmitterEntity) && !world.isReceivingRedstonePower(blockEntity.emitters) )
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());

                }
            }
        }
    }


}