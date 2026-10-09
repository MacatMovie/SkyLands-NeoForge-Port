
package net.mcreator.flyingstuff.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.flyingstuff.init.FlyingStuffModItems;

import java.util.List;

public class SwordOfTheSkyItem extends SwordItem {
	public SwordOfTheSkyItem() {
		super(new Tier() {
			public int getUses() {
				return 3104;
			}

			public float getSpeed() {
				return 2f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 20;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(FlyingStuffModItems.INGOT_OF_THE_SKY.get()));
			}
		}, 3, -2.35f, new Item.Properties().fireResistant());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Can Be Infused with All Celestium Types"));
	}
}
