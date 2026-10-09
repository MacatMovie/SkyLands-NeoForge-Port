package net.deepcanion.skylands.entity;
import net.deepcanion.skylands.registry.ModEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.warden.Warden;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
public final class CombatEvents {
    public static void target(LivingChangeTargetEvent event) {
        if (event.getEntity() instanceof Warden) return;
        var target = event.getNewAboutToBeSetTarget();
        if (event.getEntity().hasEffect(ModEffects.HIDDEN) || target != null && target.hasEffect(ModEffects.HIDDEN)) event.setNewAboutToBeSetTarget(null);
    }
    private CombatEvents() { }
}
