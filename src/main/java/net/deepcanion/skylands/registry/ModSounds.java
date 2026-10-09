package net.deepcanion.skylands.registry;

import net.deepcanion.skylands.SkyLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public final class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, SkyLands.MOD_ID);
    static {
        SOUNDS.register("glaciated_sky", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("glaciated_sky")));
        SOUNDS.register("golden_sky_music", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("golden_sky_music")));
        SOUNDS.register("igneus_sky", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("igneus_sky")));
        SOUNDS.register("sky_wind", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("sky_wind")));
    }
    public static final DeferredHolder<SoundEvent, SoundEvent> DRAGON_ATTACK = SOUNDS.register("dragon_attack", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("dragon_attack")));
    public static final DeferredHolder<SoundEvent, SoundEvent> DRAGON_FINAL_KILL = SOUNDS.register("dragon_final_kill", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("dragon_final_kill")));
    public static final DeferredHolder<SoundEvent, SoundEvent> FIREBLADE_SOUND = SOUNDS.register("fireblade_sound", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("fireblade_sound")));
    public static final DeferredHolder<SoundEvent, SoundEvent> ICE_BOMB_HITS = SOUNDS.register("ice_bomb_hits", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("ice_bomb_hits")));
    public static final DeferredHolder<SoundEvent, SoundEvent> ICE_BOMB_TROWN = SOUNDS.register("ice_bomb_trown", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("ice_bomb_trown")));
    public static final DeferredHolder<SoundEvent, SoundEvent> ICE_DRAGON_FLAP = SOUNDS.register("ice_dragon_flap", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("ice_dragon_flap")));
    public static final DeferredHolder<SoundEvent, SoundEvent> SKY_AUTOMATON_BOSS_FINAL_KILL = SOUNDS.register("sky_automaton_boss_final_kill", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("sky_automaton_boss_final_kill")));
    public static final DeferredHolder<SoundEvent, SoundEvent> CHEST_UNLOCK = SOUNDS.register("chest_unlock", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("chest_unlock")));
    public static final DeferredHolder<SoundEvent, SoundEvent> SKY_CHEST_OPEN = SOUNDS.register("sky_chest_open", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("sky_chest_open")));
    public static final DeferredHolder<SoundEvent, SoundEvent> SKY_CHEST_CLOSE = SOUNDS.register("sky_chest_close", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("sky_chest_close")));
    public static final DeferredHolder<SoundEvent, SoundEvent> DESERT_DISC = SOUNDS.register("desert_disc", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("desert_disc")));
    public static final DeferredHolder<SoundEvent, SoundEvent> LAVA_DISK = SOUNDS.register("lava_disk", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("lava_disk")));
    public static final DeferredHolder<SoundEvent, SoundEvent> SKY_RIVER_DISK = SOUNDS.register("sky_river_disk", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("sky_river_disk")));
    public static final DeferredHolder<SoundEvent, SoundEvent> SKY_WATERFALL = SOUNDS.register("sky_waterfall", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("sky_waterfall")));
    public static final DeferredHolder<SoundEvent, SoundEvent> DISKICE = SOUNDS.register("diskice", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("diskice")));
    public static final DeferredHolder<SoundEvent, SoundEvent> TEARS_OF_MOOG_CITY = SOUNDS.register("tears_of_moog_city", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("tears_of_moog_city")));
    public static final DeferredHolder<SoundEvent, SoundEvent> UNDERGROUND_MUSIC_DISK = SOUNDS.register("underground_music_disk", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("underground_music_disk")));
    public static final DeferredHolder<SoundEvent, SoundEvent> MECHANISM_STATIC = SOUNDS.register("mechanism_static", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("mechanism_static")));
    public static final DeferredHolder<SoundEvent, SoundEvent> MECHANISM_DEACTIVATION = SOUNDS.register("mechanism_deactivation", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("mechanism_deactivation")));
    public static final DeferredHolder<SoundEvent, SoundEvent> POWERFUL_WIND = SOUNDS.register("powerful_wind", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("powerful_wind")));
    public static final DeferredHolder<SoundEvent, SoundEvent> FREEFALL = SOUNDS.register("freefall", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("freefall")));
    public static final DeferredHolder<SoundEvent, SoundEvent> FREEFALL_FAST = SOUNDS.register("freefall_fast", () -> SoundEvent.createVariableRangeEvent(SkyLands.id("freefall_fast")));
    private ModSounds() { }
}
