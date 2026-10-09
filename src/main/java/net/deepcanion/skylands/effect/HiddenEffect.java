package net.deepcanion.skylands.effect;
import net.deepcanion.skylands.registry.ModEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.*;
public final class HiddenEffect extends MobEffect {
    public HiddenEffect() { super(MobEffectCategory.BENEFICIAL, -1); }
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) { return true; }
    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof net.minecraft.world.entity.Mob mob && !(mob instanceof net.minecraft.world.entity.monster.warden.Warden)) mob.setTarget(null);
        if (entity.tickCount % 5 == 0 && entity.level() instanceof ServerLevel server && !(entity instanceof net.minecraft.world.entity.monster.warden.Warden)) {
            for (var mob : server.getEntitiesOfClass(net.minecraft.world.entity.Mob.class, entity.getBoundingBox().inflate(32), m -> m.getTarget() == entity)) {
                if (!(mob instanceof net.minecraft.world.entity.monster.warden.Warden)) mob.setTarget(null);
            }
        }
        return true;
    }
}
