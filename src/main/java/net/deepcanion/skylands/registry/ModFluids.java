package net.deepcanion.skylands.registry;

import net.deepcanion.skylands.SkyLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class ModFluids {
    public static final DeferredRegister<FluidType> TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, SkyLands.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, SkyLands.MOD_ID);
    public static final DeferredHolder<FluidType, FluidType> MOLTEN_METAL_TYPE = TYPES.register("molten_metal", () -> new FluidType(FluidType.Properties.create()
        .canSwim(false).canDrown(false).pathType(PathType.LAVA).adjacentPathType(null)
        .motionScale(0.0035D).lightLevel(15).density(1104).viscosity(840).temperature(30000)
        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
        .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)));
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> MOLTEN_METAL = FLUIDS.register("molten_metal", () -> new BaseFlowingFluid.Source(properties()));
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_MOLTEN_METAL = FLUIDS.register("flowing_molten_metal", () -> new BaseFlowingFluid.Flowing(properties()));
    private static BaseFlowingFluid.Properties properties() {
        // Vanilla-sized slope search avoids signed-byte cache indices in Lithium 0.15.4.
        // This controls the search for downhill paths, not the fluid tick rate or level decay.
        return new BaseFlowingFluid.Properties(MOLTEN_METAL_TYPE, MOLTEN_METAL, FLOWING_MOLTEN_METAL)
            .explosionResistance(100F).tickRate(8).slopeFindDistance(4)
            .bucket(() -> ModItems.MOLTEN_METAL_BUCKET.get()).block(() -> ModBlocks.MOLTEN_METAL.get());
    }
    private ModFluids() { }
}
