package Fantasy_World.mod.conf;

import Fantasy_World.mod.fantasy_world;
import cpw.mods.fml.common.ModMetadata;
//import Fantasy_World_mod.aluminiummod.common.AluminiumMod;

public class ModInfoCore {
	public static void registerInfo(ModMetadata meta) {
		meta.modId = fantasy_world.instance.modID;
		meta.name = fantasy_world.instance.name;
		meta.description = "This mod adds Aluminium.";
		meta.version = fantasy_world.instance.ver;
		meta.url = "http://www.tntmodders.com";
		meta.authorList.add("Akasata Nahama");
		meta.authorList.add("Tom Kate");
		meta.credits = "";
		meta.logoFile = "assets/aluminiummod/logo.png";
		meta.autogenerated = false;
	}
}
