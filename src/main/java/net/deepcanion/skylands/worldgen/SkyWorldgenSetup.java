package net.deepcanion.skylands.worldgen;

import net.deepcanion.skylands.SkyLands;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

public final class SkyWorldgenSetup {
    public static void register() {
        Regions.register(new SkyLandsRegion());
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, SkyLands.MOD_ID, SkySurfaceRules.create());
    }
    private SkyWorldgenSetup() { }
}
