package net.deepcanion.skylands.entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/** Shared 1.21 arrow constructors and authored projectile knockback. */
public abstract class SkyProjectile extends AbstractArrow {
    private int skyKnockback;
    protected SkyProjectile(EntityType<? extends SkyProjectile> type, Level level) { super(type, level); }
    protected SkyProjectile(EntityType<? extends SkyProjectile> type, double x, double y, double z, Level level) {
        super(type, x, y, z, level, new ItemStack(Items.ARROW), null);
    }
    protected SkyProjectile(EntityType<? extends SkyProjectile> type, LivingEntity owner, Level level) {
        super(type, owner, level, new ItemStack(Items.ARROW), null);
        pickup = Pickup.DISALLOWED;
    }
    public void setKnockback(int value) { skyKnockback = Math.max(0, value); }
    @Override
    protected void doKnockback(LivingEntity target, DamageSource source) {
        if (skyKnockback > 0) {
            Vec3 push = getDeltaMovement().multiply(1, 0, 1).normalize().scale(skyKnockback * 0.6 * Math.max(0, 1 - target.getAttributeValue(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)));
            target.push(push.x, 0.1, push.z);
        }
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) { super.addAdditionalSaveData(tag); tag.putInt("SkyKnockback", skyKnockback); }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) { super.readAdditionalSaveData(tag); skyKnockback = tag.getInt("SkyKnockback"); }
    @Override
    public void tick() { super.tick(); if (!level().isClientSide() && tickCount > 1200) discard(); }
}
