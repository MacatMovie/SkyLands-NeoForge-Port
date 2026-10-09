package net.deepcanion.skylands.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;

/** Shared authored melee behavior; 1.21 uses entity tags instead of MobType. */
public abstract class AbstractSkyAutomaton extends Monster {
    protected AbstractSkyAutomaton(EntityType<? extends AbstractSkyAutomaton> type, Level level) {
        super(type, level);
        xpReward = 10;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, false, false));
        goalSelector.addGoal(4, new RandomStrollGoal(this, strollSpeed()));
        goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    protected double strollSpeed() { return 0.8; }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return SoundEvents.BONE_BLOCK_BREAK; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.BONE_BLOCK_BREAK; }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud) return false;
        return super.hurt(source, amount);
    }

    protected static AttributeSupplier.Builder attributes(double damage, double knockback) {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.2).add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.ARMOR, 0.2).add(Attributes.ATTACK_DAMAGE, damage)
                .add(Attributes.FOLLOW_RANGE, 25).add(Attributes.KNOCKBACK_RESISTANCE, 0.2)
                .add(Attributes.ATTACK_KNOCKBACK, knockback).add(Attributes.STEP_HEIGHT, 0.6);
    }
}
