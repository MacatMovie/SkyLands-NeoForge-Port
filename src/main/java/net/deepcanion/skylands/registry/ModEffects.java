package net.deepcanion.skylands.registry;
import net.deepcanion.skylands.SkyLands;
import net.deepcanion.skylands.effect.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.*;
public final class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, SkyLands.MOD_ID);
    public static final DeferredHolder<MobEffect, FrozenEffect> FROZEN = EFFECTS.register("frozen", FrozenEffect::new);
    public static final DeferredHolder<MobEffect, HiddenEffect> HIDDEN = EFFECTS.register("hidden", HiddenEffect::new);
    public static final DeferredHolder<MobEffect, WarmthEffect> WARMTH = EFFECTS.register("warmth", WarmthEffect::new);
    private ModEffects() { }
}
