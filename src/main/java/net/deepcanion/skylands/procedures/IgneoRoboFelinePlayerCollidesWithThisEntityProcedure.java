package net.deepcanion.skylands.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.deepcanion.skylands.entity.IgneoRoboFelineEntity;

public class IgneoRoboFelinePlayerCollidesWithThisEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null || entity.level().isClientSide())
			return;
		if (entity instanceof IgneoRoboFelineEntity) {
			((IgneoRoboFelineEntity) entity).setAnimation("attack");
		}
		sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 3);
	}
}
