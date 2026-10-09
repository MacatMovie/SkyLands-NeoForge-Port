
package net.mcreator.flyingstuff.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.flyingstuff.procedures.WarmthOnEffectActiveTickProcedure;

public class WarmthMobEffect extends MobEffect {
	public WarmthMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -26368);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		WarmthOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
