package Fantasy_World.mod;

import Fantasy_World.mod.api.armors;
import Fantasy_World.mod.api.biome;
import Fantasy_World.mod.api.blocks;
import Fantasy_World.mod.api.dimensions;
import Fantasy_World.mod.api.foods;
import Fantasy_World.mod.api.items;
import Fantasy_World.mod.api.weapons;
import Fantasy_World.mod.biome.biome_base;
import Fantasy_World.mod.blocks.FwmBlocks;
import Fantasy_World.mod.creativetabs.creativetabs;
import Fantasy_World.mod.dimensions.dimension_core;
import Fantasy_World.mod.entity.entity_core;
import Fantasy_World.mod.entity.magicentity.magic_rod_entity;
import Fantasy_World.mod.enums.FwmEnumToolMaterial;
import Fantasy_World.mod.gui.gui_core;
import Fantasy_World.mod.item.FwmArmors;
import Fantasy_World.mod.item.FwmFood;
import Fantasy_World.mod.item.FwmItem;
import Fantasy_World.mod.recipe.ArmorRecipe;
import Fantasy_World.mod.recipe.BlockRecipe;
import Fantasy_World.mod.recipe.ItemRecipe;
import Fantasy_World.mod.recipe.WeaponRecipe;
import Fantasy_World.mod.register.RegisterBlocks;
import Fantasy_World.mod.register.RegisterItems;
import Fantasy_World.mod.register.RegisterOre;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = fantasy_world.modID, name = fantasy_world.name, version = fantasy_world.ver, guiFactory = "Fantasy_World_mod.conf.ModGuiFactory")
public class fantasy_world {
/*
	// プロキシの登録
	@SidedProxy(clientSide = "fantasy_world.mod.client.ClientProxyF",
			serverSide = "fantasy_world.mod.common.CommonProxyF")
	public static Commons proxy;
*/
	@Instance("Fantasy_World_mod")
	public static fantasy_world instance;
	public static final String modID = "Fantasy_World_mod";
	public static final String name = "Fantasy World mod";
	public static final String ver = "0.0.2";

	// 追加するアイテムの宣言
	// 複数追加も可

	// アイテム、武器、食料、鎧
	public static items items;
	public static weapons weapons;
	public static foods foods;
	public static armors armors;

	// マテリアル
	public static FwmEnumToolMaterial FwmToolMaterial;

	//public static RegisterItems RegisterItems;

	// ブロック
	public static blocks blocks;

	// クリエイティブタブ
	public static creativetabs Tabs;

	// ディメンション
	public static dimensions dimensions;

	// バイオーム
	public static biome biome;

	// バイオームベース
	public static biome_base biome_base;

	// GUI
	public static Fantasy_World.mod.api.gui gui;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		FwmToolMaterial = new FwmEnumToolMaterial();

		Tabs = new creativetabs();

		// アイテムの追加
		new FwmItem();
		new FwmFood();
		new FwmArmors();
		//new FwmWepons();

		// アイテム登録
		new RegisterItems();

		// ディメンション追加
		new dimension_core();

	}
	// ブロックの設定
	@EventHandler
	public void perInit(FMLPreInitializationEvent event) {

		// new confing(event);

		// ブロックの追加
		new FwmBlocks();

		// ブロック登録
		new RegisterBlocks();

		new gui_core();
	}
	// レシピや鉱石生成の設定
	@EventHandler
	public void init(FMLInitializationEvent event){

		// new confing(event);

		// アイテムレシピの追加
		new ItemRecipe();
		//new deleteVanillaRecipe();

		// ブロックレシピの追加
		new BlockRecipe();

		// 武器レシピの追加
		new WeaponRecipe();

		// 防具レシピの追加
		new ArmorRecipe();

		// 鉱石生成
		new RegisterOre();



		//バイオームの追加
		new biome_base();

		// entity
		int NullmagicID = 1;
		EntityRegistry.registerModEntity(magic_rod_entity.class, "dcsflame.entity_flame", NullmagicID, this, 128, 5, true);
		new entity_core();


		// render
		//proxy.registerRenderers();
	}
}

// メモ
// テクスチャ保存場所
// src/main/resources/assets/ドメイン(fantasy_ｗorld)/textures/items/









