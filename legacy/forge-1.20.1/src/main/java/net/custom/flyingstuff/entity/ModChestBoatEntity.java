package net.custom.flyingstuff.entity;

import net.mcreator.flyingstuff.FlyingStuffModSigns;
import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.IntFunction;
import net.minecraft.world.entity.vehicle.ChestBoat;



public class ModChestBoatEntity extends ChestBoat {

	private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ChestBoat.class, EntityDataSerializers.INT);
	
	public ModChestBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel)
 {
		super(pEntityType, pLevel);
		}

    public ModChestBoatEntity(Level level, double pX, double pY, double pZ) {
        this(FlyingStuffModSigns.MOD_CHEST_BOAT.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

	@Override
    public Item getDropItem() {
        switch (getModVariant()) {
            case GOLDEN_LEAVES -> FlyingStuffModSigns.GOLDEN_LEAVES_CHEST_BOAT.get();
        };
        return super.getDropItem();
        
    }
    
	public void setVariant(ModBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
  	}

   	public ModBoatEntity.Type getModVariant() {
        return ModBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
   	}


	  protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE, ModBoatEntity.Type.GOLDEN_LEAVES.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(ModBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

}
