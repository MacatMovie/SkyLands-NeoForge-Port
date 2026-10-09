package net.deepcanion.skylands.block;
import java.util.function.Supplier;
import net.deepcanion.skylands.registry.ModItems;
import net.minecraft.world.item.Item;
public enum SkyChestKind {
GOLDEN_1("golden_sky_level_1_chest", ModItems.GOLDENLEVEL_1_KEY, "textures/block/chest.png", "textures/block/chest_active.png"),
    GOLDEN_2("golden_sky_level_2_chest", ModItems.GOLDEN_LEVEL_2_KEY, "textures/block/level2chest.png", "textures/block/level2chest_open.png"),
    GLACIATED_1("glaciated_sky_level_1_chest", ModItems.DIAMOND_LEVEL_1_KEY, "textures/block/glaciated_chest0.png", "textures/block/glaciated_chest0_open.png"),
    GLACIATED_2("glaciated_sky_level_2_chest", ModItems.DIAMOND_LEVEL_2KEY, "textures/block/glaciated_chest.png", "textures/block/glaciated_chest_open.png"),
    LAVIC_1("lavic_sky_lvl_1_chest", ModItems.LAVIC_LEVEL_1_KEY, "textures/block/lavic_lvl1_chest.png", "textures/block/lavic_lvl1_chest_open.png"),
    LAVIC_2("lavic_sky_lvl_2_chest", ModItems.LAVIC_LEVEL_2_KEY, "textures/block/lavic_lvl2_chest.png", "textures/block/lavic_lvl2_chest_open.png"),
    ARID_1("arid_sky_level_0_chest", ModItems.ARID_LEVEL_1_KEY, "textures/block/arid_chest_0.png", "textures/block/arid_chest_0_open.png"),
    ARID_2("arid_sky_level_2_chest", ModItems.ARID_LEVEL_2_KEY, "textures/block/arid_chest_1.png", "textures/block/arid_chest_1_open.png"),
    PROTO("proto_chest", null, "textures/block/protochest.png", "textures/block/protochest.png");
    public final String id;
    public final Supplier<? extends Item> key;
    private final String lockedTexture, unlockedTexture;
    SkyChestKind(String id, Supplier<? extends Item> key, String lockedTexture, String unlockedTexture) {
        this.id = id; this.key = key; this.lockedTexture = lockedTexture; this.unlockedTexture = unlockedTexture;
    }
    public int size() { return this == PROTO ? 44 : 27; }
    public String texture(boolean unlocked) { return unlocked ? unlockedTexture : lockedTexture; }
    public String asset() { return this == PROTO ? "proto_chest" : "golden_sky_chest_lvl1"; }
}
