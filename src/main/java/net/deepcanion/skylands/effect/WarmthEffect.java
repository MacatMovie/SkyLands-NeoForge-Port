package net.deepcanion.skylands.effect;
import net.deepcanion.skylands.registry.ModEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.*;
public final class WarmthEffect extends MobEffect {
    public WarmthEffect() { super(MobEffectCategory.BENEFICIAL, -26368); }
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) { return true; }
    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        entity.setTicksFrozen(0);
        return true;
    }
}
