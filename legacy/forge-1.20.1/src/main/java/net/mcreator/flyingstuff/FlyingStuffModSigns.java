/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.flyingstuff as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.flyingstuff;

import net.mcreator.flyingstuff.FlyingStuffMod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.client.renderer.Sheets;


import net.custom.flyingstuff.util.WoodTypes;
import net.custom.flyingstuff.blocks.mStandingSignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.custom.flyingstuff.blocks.mWallSignBlock;
import net.custom.flyingstuff.blocks.mHangingSignBlock;
import net.custom.flyingstuff.blocks.mWallHangingSignBlock;
import net.custom.flyingstuff.blocks.signs.ModSignBlockEntity;
import net.custom.flyingstuff.blocks.signs.ModHangingSignBlockEntity;
import net.custom.flyingstuff.entity.ModBoatEntity;
import net.custom.flyingstuff.entity.ModChestBoatEntity;
import net.custom.flyingstuff.entity.client.ModBoatRenderer;
import net.custom.flyingstuff.item.ModBoatItem;

import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.block.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.mcreator.flyingstuff.init.FlyingStuffModBlocks;
import net.mcreator.flyingstuff.init.FlyingStuffModItems;
import net.mcreator.flyingstuff.init.FlyingStuffModBlockEntities;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mcreator.flyingstuff.init.FlyingStuffModEntities;
import net.mcreator.flyingstuff.init.FlyingStuffModEntityRenderers;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;


import java.util.function.Function;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.MobCategory;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FlyingStuffModSigns {

	//public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FlyingStuffMod.MODID);
	//public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FlyingStuffMod.MODID);
	//public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FlyingStuffMod.MODID);
	//Sign Blocks
	
	public static final RegistryObject<Block> GOLDEN_LEAVES_SIGN = FlyingStuffModBlocks.REGISTRY.register("golden_leaves_sign", () -> new mStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), WoodTypes.GOLDEN_LEAVES));
	public static final RegistryObject<Block> GOLDEN_LEAVES_WALL_SIGN =  FlyingStuffModBlocks.REGISTRY.register("golden_leaves_wall_sign", () -> new mWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), WoodTypes.GOLDEN_LEAVES));

	public static final RegistryObject<Block> GOLDEN_LEAVES_HANGING_SIGN =  FlyingStuffModBlocks.REGISTRY.register("golden_leaves_hanging_sign", () -> new mHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), WoodTypes.GOLDEN_LEAVES));
	public static final RegistryObject<Block> GOLDEN_LEAVES_WALL_HANGING_SIGN =  FlyingStuffModBlocks.REGISTRY.register("golden_leaves_hanging_wall_sign", () -> new mWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), WoodTypes.GOLDEN_LEAVES));



	public static final RegistryObject<Block> GLACIATED_SIGN = FlyingStuffModBlocks.REGISTRY.register("glaciated_sign", () -> new mStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), WoodTypes.GLACIATED));
	public static final RegistryObject<Block> GLACIATED_WALL_SIGN =  FlyingStuffModBlocks.REGISTRY.register("glaciated_wall_sign", () -> new mWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), WoodTypes.GLACIATED));

	public static final RegistryObject<Block> GLACIATED_HANGING_SIGN =  FlyingStuffModBlocks.REGISTRY.register("glaciated_hanging_sign", () -> new mHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), WoodTypes.GLACIATED));
	public static final RegistryObject<Block> GLACIATED_WALL_HANGING_SIGN =  FlyingStuffModBlocks.REGISTRY.register("glaciated_hanging_wall_sign", () -> new mWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), WoodTypes.GLACIATED));



	public static final RegistryObject<Block> LAVIC_SIGN = FlyingStuffModBlocks.REGISTRY.register("lavic_sign", () -> new mStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), WoodTypes.LAVIC));
	public static final RegistryObject<Block> LAVIC_WALL_SIGN =  FlyingStuffModBlocks.REGISTRY.register("lavic_wall_sign", () -> new mWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), WoodTypes.LAVIC));

	public static final RegistryObject<Block> LAVIC_HANGING_SIGN =  FlyingStuffModBlocks.REGISTRY.register("lavic_hanging_sign", () -> new mHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), WoodTypes.LAVIC));
	public static final RegistryObject<Block> LAVIC_WALL_HANGING_SIGN =  FlyingStuffModBlocks.REGISTRY.register("lavic_hanging_wall_sign", () -> new mWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), WoodTypes.LAVIC));



	public static final RegistryObject<Block> INKY_SIGN = FlyingStuffModBlocks.REGISTRY.register("inky_sign", () -> new mStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), WoodTypes.INKY));
	public static final RegistryObject<Block> INKY_WALL_SIGN =  FlyingStuffModBlocks.REGISTRY.register("inky_wall_sign", () -> new mWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), WoodTypes.INKY));

	public static final RegistryObject<Block> INKY_HANGING_SIGN =  FlyingStuffModBlocks.REGISTRY.register("inky_hanging_sign", () -> new mHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), WoodTypes.INKY));
	public static final RegistryObject<Block> INKY_WALL_HANGING_SIGN =  FlyingStuffModBlocks.REGISTRY.register("inky_hanging_wall_sign", () -> new mWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), WoodTypes.INKY));



	public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN = FlyingStuffModBlockEntities.REGISTRY.register("mod_sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, 
	GOLDEN_LEAVES_SIGN.get(), GOLDEN_LEAVES_WALL_SIGN.get(), GLACIATED_SIGN.get(), GLACIATED_WALL_SIGN.get(), LAVIC_SIGN.get(), LAVIC_WALL_SIGN.get(), INKY_SIGN.get(), INKY_WALL_SIGN.get()).build(null));

	public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN = FlyingStuffModBlockEntities.REGISTRY.register("mod_hanging_sign", () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, 
	GOLDEN_LEAVES_HANGING_SIGN.get(), GOLDEN_LEAVES_WALL_HANGING_SIGN.get(), GLACIATED_HANGING_SIGN.get(), GLACIATED_WALL_HANGING_SIGN.get(), LAVIC_HANGING_SIGN.get(), LAVIC_WALL_HANGING_SIGN.get(),INKY_HANGING_SIGN.get(), INKY_WALL_HANGING_SIGN.get()).build(null));


	//Boat Entities

	public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT = FlyingStuffModEntities.REGISTRY.register("mod_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,MobCategory.MISC).sized(1.375f,0.5625f).build("mod_boat"));

	public static final RegistryObject<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT = FlyingStuffModEntities.REGISTRY.register("mod_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new,MobCategory.MISC).sized(1.375f,0.5625f).build("mod_chest_boat"));


	// Sign Items


	public static final RegistryObject<Item> GOLDEN_LEAVES_SIGN_ITEM = FlyingStuffModItems.REGISTRY.register("golden_leaves_sign",
	() -> new SignItem(new Item.Properties().stacksTo(16),GOLDEN_LEAVES_SIGN.get(), GOLDEN_LEAVES_WALL_SIGN.get()));

	public static final RegistryObject<Item> GOLDEN_LEAVES_HANGING_SIGN_ITEM = FlyingStuffModItems.REGISTRY.register("golden_leaves_hanging_sign",
	() -> new HangingSignItem(GOLDEN_LEAVES_HANGING_SIGN.get(), GOLDEN_LEAVES_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));


	public static final RegistryObject<Item> GLACIATED_SIGN_ITEM = FlyingStuffModItems.REGISTRY.register("glaciated_sign",
	() -> new SignItem(new Item.Properties().stacksTo(16),GLACIATED_SIGN.get(), GLACIATED_WALL_SIGN.get()));

	public static final RegistryObject<Item> GLACIATED_HANGING_SIGN_ITEM = FlyingStuffModItems.REGISTRY.register("glaciated_hanging_sign",
	() -> new HangingSignItem(GLACIATED_HANGING_SIGN.get(), GLACIATED_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));


	public static final RegistryObject<Item> LAVIC_SIGN_ITEM = FlyingStuffModItems.REGISTRY.register("lavic_sign",
	() -> new SignItem(new Item.Properties().stacksTo(16),LAVIC_SIGN.get(),LAVIC_WALL_SIGN.get()));

	public static final RegistryObject<Item> LAVIC_HANGING_SIGN_ITEM = FlyingStuffModItems.REGISTRY.register("lavic_hanging_sign",
	() -> new HangingSignItem(LAVIC_HANGING_SIGN.get(), LAVIC_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));


	public static final RegistryObject<Item> INKY_SIGN_ITEM = FlyingStuffModItems.REGISTRY.register("inky_sign",
	() -> new SignItem(new Item.Properties().stacksTo(16), INKY_SIGN.get(), INKY_WALL_SIGN.get()));

	public static final RegistryObject<Item>  INKY_HANGING_SIGN_ITEM = FlyingStuffModItems.REGISTRY.register("inky_hanging_sign",
	() -> new HangingSignItem( INKY_HANGING_SIGN.get(),  INKY_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));


	// Boat Items

	public static final RegistryObject<Item> GOLDEN_LEAVES_BOAT = FlyingStuffModItems.REGISTRY.register("golden_leaves_boat",
	() -> new ModBoatItem(false,ModBoatEntity.Type.GOLDEN_LEAVES,new Item.Properties()));

	public static final RegistryObject<Item> GOLDEN_LEAVES_CHEST_BOAT = FlyingStuffModItems.REGISTRY.register("golden_leaves_chest_boat",
	() -> new ModBoatItem(true,ModBoatEntity.Type.GOLDEN_LEAVES,new Item.Properties()));



	public static final RegistryObject<Item> GLACIATED_BOAT = FlyingStuffModItems.REGISTRY.register("glaciated_boat",
	() -> new ModBoatItem(false,ModBoatEntity.Type.GLACIATED,new Item.Properties()));

	public static final RegistryObject<Item> GLACIATED_CHEST_BOAT = FlyingStuffModItems.REGISTRY.register("glaciated_chest_boat",
	() -> new ModBoatItem(true,ModBoatEntity.Type.GLACIATED,new Item.Properties()));



	public static final RegistryObject<Item> LAVIC_BOAT = FlyingStuffModItems.REGISTRY.register("lavic_boat",
	() -> new ModBoatItem(false,ModBoatEntity.Type.LAVIC,new Item.Properties()));

	public static final RegistryObject<Item> LAVIC_CHEST_BOAT = FlyingStuffModItems.REGISTRY.register("lavic_chest_boat",
	() -> new ModBoatItem(true,ModBoatEntity.Type.LAVIC,new Item.Properties()));



		public static final RegistryObject<Item> INKY_BOAT = FlyingStuffModItems.REGISTRY.register("inky_boat",
	() -> new ModBoatItem(false,ModBoatEntity.Type.INKY,new Item.Properties()));

	public static final RegistryObject<Item> INKY_CHEST_BOAT = FlyingStuffModItems.REGISTRY.register("inky_chest_boat",
	() -> new ModBoatItem(true,ModBoatEntity.Type.INKY,new Item.Properties()));


	



	
	//@OnlyIn(Dist.CLIENT)
	public static void register(IEventBus eventBus) {
		//ITEMS.register(eventBus);
        //BLOCKS.register(eventBus);
        //BLOCK_ENTITIES.register(eventBus);
       // SignBlock(((StandingSignBlock) GOLDEN_LEAVES_SIGN.get()),((WallSignBlock) GOLDEN_LEAVES_WALL_SIGN.get()),blockTexture(FlyingStuffModBlocks.F_IERY_PLANKS.get()));
    }

	
	public FlyingStuffModSigns() {
		register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		new FlyingStuffModSigns();
	}

	@Mod.EventBusSubscriber
	private static class ForgeBusEvents {
		@SubscribeEvent
		public static void serverLoad(ServerStartingEvent event) {


	

		
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void clientLoad(FMLClientSetupEvent event) {
			Sheets.addWoodType(WoodTypes.GOLDEN_LEAVES);
			Sheets.addWoodType(WoodTypes.GLACIATED);
			Sheets.addWoodType(WoodTypes.LAVIC);
			Sheets.addWoodType(WoodTypes.INKY);
		}
	}
}
