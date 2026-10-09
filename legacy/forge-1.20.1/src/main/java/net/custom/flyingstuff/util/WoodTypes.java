package net.custom.flyingstuff.util;

import net.mcreator.flyingstuff.FlyingStuffMod;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class WoodTypes {
    public static final WoodType GOLDEN_LEAVES = WoodType.register(new WoodType(FlyingStuffMod.MODID + ":golden_leaves", BlockSetType.OAK));
    public static final WoodType GLACIATED = WoodType.register(new WoodType(FlyingStuffMod.MODID + ":glaciated", BlockSetType.OAK));
	public static final WoodType LAVIC = WoodType.register(new WoodType(FlyingStuffMod.MODID + ":lavic", BlockSetType.OAK));
	public static final WoodType INKY = WoodType.register(new WoodType(FlyingStuffMod.MODID + ":inky", BlockSetType.OAK));

    
}
