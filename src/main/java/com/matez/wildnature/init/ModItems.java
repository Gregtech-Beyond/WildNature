package com.matez.wildnature.init;

import com.matez.wildnature.Main;
import com.matez.wildnature.items.*;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<Item>();

    /*
        WOOD(0, 59, 2.0F, 0.0F, 15),
        STONE(1, 131, 4.0F, 1.0F, 5),
        IRON(2, 250, 6.0F, 2.0F, 14),
        DIAMOND(3, 1561, 8.0F, 3.0F, 10),
        GOLD(0, 32, 12.0F, 0.0F, 22);
     */
    public static Item.ToolMaterial STEEL = EnumHelper.addToolMaterial("STEEL", 2, 400, 6.5F, 2.5F, 15);

    public static Item.ToolMaterial AMETHYST = EnumHelper.addToolMaterial("AMETHYST", 4, 2000, 9.0F, 5F, 16);
    public static Item.ToolMaterial MALACHITE = EnumHelper.addToolMaterial("MALACHITE", 4, 2000, 9.0F, 5.5F, 17);
    public static Item.ToolMaterial SAPPHIRE = EnumHelper.addToolMaterial("SAPPHIRE", 5, 2500, 10.5F, 6F, 18);


    public static Item.ToolMaterial SILVER = EnumHelper.addToolMaterial("SILVER", 5, 999, 12.0F, 4.5F, 19);
    public static Item.ToolMaterial RUBY = EnumHelper.addToolMaterial("RUBY", 6, 3000, 11.5F, 8F, 20);
    public static Item.ToolMaterial AMBER = EnumHelper.addToolMaterial("AMBER", 3, 300, 12.5F, 4F, 17);



    public static final Item ZIELONE_JABLKO = new ItemEatBase("green_apple",1,0.3F,false);
    public static final Item GRUSZKA = new ItemEatBase("pear",1,0.3F,false);
    public static final Item ROWAN_CZERWONA = new ItemThrowable("rowanberry_red", SoundEvents.ENTITY_SNOWBALL_THROW);
    public static final Item ROWAN_POMARANCZOWA = new ItemThrowable("rowanberry_orange", SoundEvents.ENTITY_SNOWBALL_THROW);
    public static final Item CHERRY = new ItemEatBase("cherry",1,0.4F,false);
    public static final Item ACORN = new ItemThrowable("acorn", SoundEvents.ENTITY_SNOWBALL_THROW);
    public static final Item CORN = new ItemEatBase("corn",3,0.3F,false);
    public static final Item RAW_BOAR = new ItemEatBase("raw_boar",3,0.2F,true);
    public static final Item COOKED_BOAR = new ItemEatBase("cooked_boar",6,0.5F,true);
    public static final Item RAW_GOAT = new ItemEatBase("raw_goat",4,0.3F,true);
    public static final Item COOKED_GOAT = new ItemEatBase("cooked_goat",7,0.6F,true);
    public static final Item RAW_BISON = new ItemEatBase("raw_bison",5,0.7F,true);
    public static final Item COOKED_BISON = new ItemEatBase("cooked_bison",8,0.4F,true);
    public static final Item RAW_CAMEL = new ItemEatBase("raw_camel",2,0.3F,true);
    public static final Item COOKED_CAMEL = new ItemEatBase("cooked_camel",5,0.2F,true);
    public static final Item DUCK_MALE_FEATHER = new ItemBase("duck_male_feather");
    public static final Item DUCK_FEMALE_FEATHER = new ItemBase("duck_female_feather");
    public static final Item DUCK_BABY_FEATHER = new ItemBase("duck_baby_feather");

    public static final Item PEBBLE = new ItemThrowable("pebble", SoundEvents.ENTITY_SNOWBALL_THROW,Main.wnTabUnderground);


    ///
    public static final Item AMETHYST_ITEM = new ItemBase("amethyst", Main.wnTabUnderground);
    public static final Item AMETHYST_SHARD = new ItemBase("amethyst_shard",Main.wnTabUnderground);
    public static final Item AMETHYST_SWORD = new ItemCustomSword("amethyst_sword",AMETHYST);
    public static final Item AMETHYST_HOE = new ItemCustomHoe("amethyst_hoe",AMETHYST);
    public static final Item AMETHYST_AXE = new ItemCustomAxe("amethyst_axe",AMETHYST,9.5F,4F);
    public static final Item AMETHYST_PICKAXE = new ItemCustomPickaxe("amethyst_pickaxe",AMETHYST);
    public static final Item AMETHYST_SHOVEL = new ItemCustomShovel("amethyst_shovel",AMETHYST);

    public static final Item SAPPHIRE_ITEM = new ItemBase("sapphire", Main.wnTabUnderground);
    public static final Item SAPPHIRE_SHARD = new ItemBase("sapphire_shard",Main.wnTabUnderground);
    public static final Item SAPPHIRE_SWORD = new ItemCustomSword("sapphire_sword",SAPPHIRE);
    public static final Item SAPPHIRE_HOE = new ItemCustomHoe("sapphire_hoe",SAPPHIRE);
    public static final Item SAPPHIRE_AXE = new ItemCustomAxe("sapphire_axe",SAPPHIRE,9.5F,4F);
    public static final Item SAPPHIRE_PICKAXE = new ItemCustomPickaxe("sapphire_pickaxe",SAPPHIRE);
    public static final Item SAPPHIRE_SHOVEL = new ItemCustomShovel("sapphire_shovel",SAPPHIRE);

    public static final Item RUBY_ITEM = new ItemBase("ruby", Main.wnTabUnderground);
    public static final Item RUBY_SHARD = new ItemBase("ruby_shard",Main.wnTabUnderground);
    public static final Item RUBY_SWORD = new ItemCustomSword("ruby_sword",RUBY);
    public static final Item RUBY_HOE = new ItemCustomHoe("ruby_hoe",RUBY);
    public static final Item RUBY_AXE = new ItemCustomAxe("ruby_axe",RUBY,9.5F,4F);
    public static final Item RUBY_PICKAXE = new ItemCustomPickaxe("ruby_pickaxe",RUBY);
    public static final Item RUBY_SHOVEL = new ItemCustomShovel("ruby_shovel",RUBY);

    public static final Item AMBER_ITEM = new ItemBase("amber", Main.wnTabUnderground);
    public static final Item AMBER_SWORD = new ItemCustomSword("amber_sword",AMBER);
    public static final Item AMBER_HOE = new ItemCustomHoe("amber_hoe",AMBER);
    public static final Item AMBER_AXE = new ItemCustomAxe("amber_axe",AMBER,9.5F,4F);
    public static final Item AMBER_PICKAXE = new ItemCustomPickaxe("amber_pickaxe",AMBER);
    public static final Item AMBER_SHOVEL = new ItemCustomShovel("amber_shovel",AMBER);

    public static final Item MALACHITE_ITEM = new ItemBase("malachite", Main.wnTabUnderground);
    public static final Item MALACHITE_SHARD = new ItemBase("malachite_shard",Main.wnTabUnderground);
    public static final Item MALACHITE_SWORD = new ItemCustomSword("malachite_sword",MALACHITE);
    public static final Item MALACHITE_HOE = new ItemCustomHoe("malachite_hoe",MALACHITE);
    public static final Item MALACHITE_AXE = new ItemCustomAxe("malachite_axe",MALACHITE,9.5F,4F);
    public static final Item MALACHITE_PICKAXE = new ItemCustomPickaxe("malachite_pickaxe",MALACHITE);
    public static final Item MALACHITE_SHOVEL = new ItemCustomShovel("malachite_shovel",MALACHITE);

    public static final Item STEEL_INGOT = new ItemBase("steel_ingot",Main.wnTabUnderground);
    public static final Item STEEL_ROD = new ItemBase("steel_rod",Main.wnTabUnderground);
    public static final Item STEEL_SWORD = new ItemCustomSword("steel_sword",STEEL);
    public static final Item STEEL_HOE = new ItemCustomHoe("steel_hoe",STEEL);
    public static final Item STEEL_AXE = new ItemCustomAxe("steel_axe",STEEL,9.5F,4F);
    public static final Item STEEL_PICKAXE = new ItemCustomPickaxe("steel_pickaxe",STEEL);
    public static final Item STEEL_SHOVEL = new ItemCustomShovel("steel_shovel",STEEL);

    public static final Item SILVER_INGOT = new ItemBase("silver_ingot",Main.wnTabUnderground);
    public static final Item SILVER_ROD = new ItemBase("silver_rod",Main.wnTabUnderground);
    public static final Item SILVER_SWORD = new ItemCustomSword("silver_sword",SILVER);
    public static final Item SILVER_HOE = new ItemCustomHoe("silver_hoe",SILVER);
    public static final Item SILVER_AXE = new ItemCustomAxe("silver_axe",SILVER,9.5F,4F);
    public static final Item SILVER_PICKAXE = new ItemCustomPickaxe("silver_pickaxe",SILVER);
    public static final Item SILVER_SHOVEL = new ItemCustomShovel("silver_shovel",SILVER);

    public static final Item DIAMOND_ROD = new ItemBase("diamond_rod",Main.wnTabUnderground);


    public ModItems(){

    }

}