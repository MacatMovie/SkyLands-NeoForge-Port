package net.deepcanion.skylands.effect;
import net.deepcanion.skylands.registry.ModEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.*;
public final class FrozenEffect extends MobEffect {
    public FrozenEffect() { super(MobEffectCategory.HARMFUL, -6684673); }
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) { return true; }
    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.hasEffect(ModEffects.WARMTH)) return false;
        entity.setTicksFrozen(250);
        if (entity.level() instanceof ServerLevel server) server.sendParticles(ParticleTypes.SNOWFLAKE, entity.getX(), entity.getY(), entity.getZ(), 5, 0.2, 0.2, 0.2, 0.01);
        return true;
    }
}
