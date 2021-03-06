package Fantasy_World.mod.recipe;

import java.util.Iterator;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import Fantasy_World.mod.fantasy_world;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;


public class ItemRecipe{
	public ItemRecipe(){
		// クリスタルストーン
		GameRegistry.addRecipe(new ItemStack(fantasy_world.items.crystal_stone, 1),
				"XXX",
				"XYX",
				"XXX",
				'X', fantasy_world.items.crystal,
				'Y', Items.redstone);

		// クリスタルストーン
		GameRegistry.addShapelessRecipe(new ItemStack(fantasy_world.items.crystal_stone, 4),
				fantasy_world.blocks.crystal_block);

		// クリスタル
		GameRegistry.addShapelessRecipe(new ItemStack(fantasy_world.items.crystal, 4),
						fantasy_world.items.crystal_stone);

		// 魔法の棒
		GameRegistry.addRecipe(new ItemStack(fantasy_world.items.rod_stick, 1),
				" X ",
				"XYX",
				" X ",
				'Y', Items.stick,
				'X', fantasy_world.items.crystal_dust);

		// 魔法の葉
		GameRegistry.addShapelessRecipe(new ItemStack(fantasy_world.items.magic_leaf, 4),
				fantasy_world.blocks.magic_wood_leaves);

		// クリスタルダスト
		GameRegistry.addShapelessRecipe(new ItemStack(fantasy_world.items.crystal_dust, 2),
				fantasy_world.items.crystal);

		// クリスタルダスト燃料化
		GameRegistry.registerFuelHandler(new IFuelHandler(){
			@Override
			public int getBurnTime(ItemStack fuel) {
				if (fuel.getItem() == fantasy_world.items.crystal_dust) {
					return 100;
				}
				return 0;
			}
		});

		// 最速ヒール
		GameRegistry.addRecipe(new ItemStack(fantasy_world.foods.fast_drag, 1),
				" X ",
				"XYX",
				"ZXZ",
				'Y', Items.redstone,
				'X', fantasy_world.foods.herb_laef,
				'Z', Items.water_bucket);

		// 六大元素
		GameRegistry.addRecipe(new ItemStack(fantasy_world.items.fire_element, 1),
				"ZYZ",
				"YXY",
				"ZYZ",
				'Y', Items.coal,
				'X', fantasy_world.items.normal_element,
				'Z', fantasy_world.items.crystal);
		GameRegistry.addRecipe(new ItemStack(fantasy_world.items.water_element, 1),
				"ZYZ",
				"YXY",
				"ZYZ",
				'Y', Items.water_bucket,
				'X', fantasy_world.items.normal_element,
				'Z', fantasy_world.items.crystal);
		GameRegistry.addRecipe(new ItemStack(fantasy_world.items.ice_element, 1),
				"ZYZ",
				"YXY",
				"ZYZ",
				'Y', Blocks.snow,
				'X', fantasy_world.items.normal_element,
				'Z', fantasy_world.items.crystal);
		GameRegistry.addRecipe(new ItemStack(fantasy_world.items.wood_element, 1),
				"ZYZ",
				"YXY",
				"ZYZ",
				'Y', Blocks.leaves,
				'X', fantasy_world.items.normal_element,
				'Z', fantasy_world.items.crystal);
		GameRegistry.addRecipe(new ItemStack(fantasy_world.items.thunder_element, 1),
				"ZYZ",
				"YXY",
				"ZYZ",
				'Y', Blocks.redstone_block,
				'X', fantasy_world.items.normal_element,
				'Z', fantasy_world.items.crystal);
		GameRegistry.addRecipe(new ItemStack(fantasy_world.items.earth_element, 1),
				"ZYZ",
				"YXY",
				"ZYZ",
				'Y', Blocks.dirt,
				'X', fantasy_world.items.normal_element,
				'Z', fantasy_world.items.crystal);

		// 火の元素燃料化
		GameRegistry.registerFuelHandler(new IFuelHandler(){
			@Override
			public int getBurnTime(ItemStack fuel) {
				if (fuel.getItem() == fantasy_world.items.fire_element) {
					return 2000;
				}
				return 0;
			}
		});

		// 三大元素
		GameRegistry.addRecipe(new ItemStack(fantasy_world.items.normal_element, 1),
				"ZYZ",
				"YXY",
				"ZYZ",
				'Y', Items.bone,
				'X', Items.slime_ball,
				'Z', fantasy_world.items.crystal);
		GameRegistry.addRecipe(new ItemStack(fantasy_world.items.light_element, 1),
				"ZYZ",
				"YXY",
				"ZYZ",
				'Y', Blocks.torch,
				'X', fantasy_world.items.normal_element,
				'Z', fantasy_world.items.crystal);
		GameRegistry.addRecipe(new ItemStack(fantasy_world.items.dark_element, 1),
				"ZYZ",
				"YXY",
				"ZYZ",
				'Y', Items.ender_pearl,
				'X', fantasy_world.items.normal_element,
				'Z', fantasy_world.items.crystal);

		// バニラアイテム
		// 木の棒
		GameRegistry.addRecipe(new ItemStack(Items.stick, 4),
				"Y",
				"Y",
				'Y', fantasy_world.blocks.magic_wood_block);









		deleteVanillaRecipe();

	}

	// レシピの削除
	public static void deleteVanillaRecipe() {

        CraftingManager m = CraftingManager.getInstance();
        ItemStack wool = new ItemStack(Blocks.wool);
        ItemStack fishing_rod = new ItemStack(Items.fishing_rod);
        ItemStack wood_sword = new ItemStack(Items.wooden_sword);

        Iterator<IRecipe> i = m.getRecipeList().iterator();

        while (i.hasNext()) {

            IRecipe re = i.next();

            if (re == null) continue;
            ItemStack outPut = re.getRecipeOutput();
            if (outPut == null) continue;

            if (outPut.isItemEqual(wool) && re instanceof ShapedRecipes && !(re instanceof ShapelessRecipes)) {
                i.remove();
                continue;
            }

            if (outPut.isItemEqual(fishing_rod)) {
                i.remove();
                continue;
            }

            if (outPut.isItemEqual(wood_sword)) {
                i.remove();
                continue;
            }

        }

    }
}