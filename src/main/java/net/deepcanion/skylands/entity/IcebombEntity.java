
package net.deepcanion.skylands.entity;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;

import net.deepcanion.skylands.procedures.IcebombProjectileHitsBlockProcedure;
import net.deepcanion.skylands.registry.ModEntities;
import net.deepcanion.skylands.registry.ModBlocks;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class IcebombEntity extends SkyProjectile implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(ModBlocks.CRISTALIZEDICE.get());



	public IcebombEntity(EntityType<? extends IcebombEntity> type, Level world) {
		super(type, world);
	}

	public IcebombEntity(EntityType<? extends IcebombEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public IcebombEntity(EntityType<? extends IcebombEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}



	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM.copy();
	}

	@Override
	protected ItemStack getDefaultPickupItem() {
		return PROJECTILE_ITEM.copy();
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(Math.max(0, entity.getArrowCount() - 1));
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		IcebombProjectileHitsBlockProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		IcebombProjectileHitsBlockProcedure.execute(this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.discard();
	}

	public static IcebombEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 0.8f, 5, 1);
	}

	public static IcebombEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		IcebombEntity entityarrow = new IcebombEntity(ModEntities.ICEBOMB.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), net.minecraft.core.registries.BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("flying_stuff:ice_bomb_trown")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static IcebombEntity shoot(LivingEntity entity, LivingEntity target) {
		IcebombEntity entityarrow = new IcebombEntity(ModEntities.ICEBOMB.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 0.8f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5);
		entityarrow.setKnockback(1);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), net.minecraft.core.registries.BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("flying_stuff:ice_bomb_trown")), SoundSource.PLAYERS, 1,
				1f / (entity.getRandom().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
