package com.fusionflux.portalcubed.util;

import com.fusionflux.portalcubed.entity.ExperimentalPortal;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.UUID;

public class EntityComponent implements PortalCubedComponent, AutoSyncedComponent {
    boolean gravityState = false;
    VoxelShape portalCutout = VoxelShapes.empty();
    UUID cubeUUID = null;
    private final Entity entity;


    public EntityComponent(Entity entity) {
        this.entity = entity;
    }

    @Override
    public boolean getSwapGravity() {
        return gravityState;
    }

    @Override
    public void setSwapGravity(boolean gravityState) {
        this.gravityState = gravityState;
        PortalCubedComponents.ENTITY_COMPONENT.sync(entity);
    }

    @Override
    public VoxelShape getPortalCutout() {
        return this.portalCutout;
    }

    @Override
    public void setPortalCutout(VoxelShape portalCutout) {
        //if(portalCutout != this.portalCutout) {
            this.portalCutout = portalCutout;
            PortalCubedComponents.ENTITY_COMPONENT.sync(entity);
        //}
    }


    @Override
    public UUID getCubeUUID() {
        return cubeUUID;
    }

    @Override
    public void setCubeUUID(UUID CubeUUID) {
        cubeUUID = CubeUUID;
        PortalCubedComponents.ENTITY_COMPONENT.sync(entity);
    }

   // @Override
   // public void writeSyncPacket(PacketByteBuf buf, ServerPlayerEntity player) {
   //     buf.writeDouble(this.portalCutout.getMax(Direction.Axis.X)); // only synchronize the information you need!
   //     buf.writeDouble(this.portalCutout.getMax(Direction.Axis.Y)); // only synchronize the information you need!
   //     buf.writeDouble(this.portalCutout.getMax(Direction.Axis.Z)); // only synchronize the information you need!
   //     buf.writeDouble(this.portalCutout.getMin(Direction.Axis.X)); // only synchronize the information you need!
   //     buf.writeDouble(this.portalCutout.getMin(Direction.Axis.Y)); // only synchronize the information you need!
   //     buf.writeDouble(this.portalCutout.getMin(Direction.Axis.Z)); // only synchronize the information you need!
   // }
////
   // @Override
   // public void applySyncPacket(PacketByteBuf buf) {
   //     double maxX = buf.readDouble();
   //     double maxY = buf.readDouble();
   //     double maxZ = buf.readDouble();
   //     double minX = buf.readDouble();
   //     double minY = buf.readDouble();
   //     double minZ = buf.readDouble();
   //     System.out.println(minX +" "+ minY +" "+ minZ +" "+ maxX +" "+ maxY +" "+ maxZ);
   //     this.portalCutout = VoxelShapes.cuboid(minX,minY,minZ,maxX,maxY,maxZ);
   // }

    @Override
    public void readFromNbt(NbtCompound tag) {

    }

    @Override
    public void writeToNbt(NbtCompound tag) {

    }
}
