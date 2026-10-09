package net.deepcanion.skylands.entity;

import net.deepcanion.skylands.registry.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;

public final class AridSkyAutomatonEntity extends AbstractSkyAutomaton {
    public AridSkyAutomatonEntity(EntityType<AridSkyAutomatonEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected double strollSpeed() { return 0.6; }

    public static AttributeSupplier.Builder createAttributes() { return attributes(8, 0.8); }
}
