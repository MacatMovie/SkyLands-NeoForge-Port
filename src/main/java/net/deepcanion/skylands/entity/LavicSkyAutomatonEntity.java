package net.deepcanion.skylands.entity;

import net.deepcanion.skylands.registry.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;

public final class LavicSkyAutomatonEntity extends AbstractSkyAutomaton {
    public LavicSkyAutomatonEntity(EntityType<LavicSkyAutomatonEntity> type, Level level) {
        super(type, level);
        setItemSlot(EquipmentSlot.MAINHAND, ModItems.AUTOMATON_SWORD.get().getDefaultInstance());
    }

    public static AttributeSupplier.Builder createAttributes() { return attributes(1, 0.5); }
}
