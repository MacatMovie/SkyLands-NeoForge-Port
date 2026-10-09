package net.mcreator.flyingstuff.procedures;

import java.util.Map;
import java.lang.Integer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.flyingstuff.init.FlyingStuffModItems;

import javax.annotation.Nullable;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.util.Mth;


import net.mcreator.flyingstuff.init.FlyingStuffModParticleTypes;
import net.minecraft.util.RandomSource;

@Mod.EventBusSubscriber
public class OnItemBrokenProcedure {
	@SubscribeEvent
	public static void onItemDestroyed(PlayerDestroyItemEvent event) {
		execute(event, event.getOriginal(), event.getEntity(), event.getHand());
	}

	public static void execute(ItemStack itemstack, Player player, InteractionHand hand) {
		execute(null, itemstack, player, hand);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, Player player, InteractionHand hand) {
		ItemStack sword = ItemStack.EMPTY;
		if (itemstack.is(ItemTags.create(new ResourceLocation("flying_stuff:breaks_in_sword")))) {
			sword = new ItemStack(FlyingStuffModItems.SWORD_OF_THE_SKY.get());
			sword.setCount(1);
			Map<Enchantment, Integer> ench = itemstack.getAllEnchantments();
			for (Map.Entry<Enchantment, Integer> entry : ench.entrySet()) {
				sword.enchant(entry.getKey(), entry.getValue().intValue());
			}
			
			Level lvl = player.level();
			RandomSource rand = lvl.random;
			
			lvl.addParticle(FlyingStuffModParticleTypes.ITEM_BREAK.get(), player.getX(), player.getY(), player.getZ(), Mth.nextDouble(rand, -0.2, 0.2), Mth.nextDouble(rand, -0.1, 0.2), Mth.nextDouble(rand, -0.2, 0.2));
			lvl.addParticle(FlyingStuffModParticleTypes.ITEM_BREAK.get(), player.getX(), player.getY(), player.getZ(), Mth.nextDouble(rand, -0.2, 0.2), Mth.nextDouble(rand, -0.1, 0.2), Mth.nextDouble(rand, -0.2, 0.2));
			lvl.addParticle(FlyingStuffModParticleTypes.ITEM_BREAK.get(), player.getX(), player.getY(), player.getZ(), Mth.nextDouble(rand, -0.2, 0.2), Mth.nextDouble(rand, -0.1, 0.2), Mth.nextDouble(rand, -0.2, 0.2));
			lvl.addParticle(FlyingStuffModParticleTypes.ITEM_BREAK.get(), player.getX(), player.getY(), player.getZ(), Mth.nextDouble(rand, -0.2, 0.2), Mth.nextDouble(rand, -0.1, 0.2), Mth.nextDouble(rand, -0.2, 0.2));
			lvl.addParticle(FlyingStuffModParticleTypes.ITEM_BREAK.get(), player.getX(), player.getY(), player.getZ(), Mth.nextDouble(rand, -0.2, 0.2), Mth.nextDouble(rand, -0.1, 0.2), Mth.nextDouble(rand, -0.2, 0.2));
			lvl.addParticle(FlyingStuffModParticleTypes.ITEM_BREAK.get(), player.getX(), player.getY(), player.getZ(), Mth.nextDouble(rand, -0.2, 0.2), Mth.nextDouble(rand, -0.1, 0.2), Mth.nextDouble(rand, -0.2, 0.2));
			
			player.setItemInHand(hand, sword);
			event.setCanceled(true);
		}
	}
}
