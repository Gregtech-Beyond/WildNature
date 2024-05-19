package com.matez.wildnature;


import com.matez.wildnature.blocks.recipes.IronworksRecipeAdd;
import com.matez.wildnature.commands.WildNatureCommand;
import com.matez.wildnature.event.*;
import com.matez.wildnature.gui.tabs.wntab;
import com.matez.wildnature.gui.tabs.wntabunderground;
import com.matez.wildnature.init.*;


import com.matez.wildnature.util.IProxy;
import com.matez.wildnature.util.Reference;
import com.matez.wildnature.util.handlers.GuiHandler;
import com.matez.wildnature.util.handlers.SoundHandler;
import com.matez.wildnature.util.handlers.TileEntityHandler;
import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import com.matez.wildnature.worldgen.generators.WorldGenCustomStructures;
import com.matez.wildnature.worldgen.generators.block.WorldGenBlocks;
import com.matez.wildnature.worldgen.generators.block.WorldGenOres;
import com.matez.wildnature.worldgen.schematics.trees.listAdapter;
import com.matez.wildnature.worldgen.type.WildNatureEXWorldType;
import com.matez.wildnature.worldgen.type.WildNatureWorldType;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.matez.wildnature.util.Reference.CLIENT_PROXY_CLASS;
import static com.matez.wildnature.util.Reference.COMMON_PROXY_CLASS;


@Mod(modid = Reference.MOD_ID,name = Reference.NAME,version = Reference.VERSION)
public class Main {


    public static String megaPrefix = TextFormatting.GREEN+""+TextFormatting.BOLD+"[WildNature] "+TextFormatting.RESET+"" + TextFormatting.AQUA;

    public static WorldType WildNatureWORLDTYPE,ExperimentalWORLDTYPE;
    public static ArrayList<WorldGenSchematicTree> generatorList = new ArrayList<>();
    public static ArrayList<Biome> biomeList = new ArrayList<>();
    public static ArrayList<FogBiome> fogBiomeList = new ArrayList<>();
    public static ArrayList<Biome> BiomesICY = new ArrayList<>();
    public static ArrayList<Biome> BiomesWARM = new ArrayList<>();
    public static ArrayList<Biome> BiomesCOOL = new ArrayList<>();
    public static ArrayList<Biome> BiomesDESERT = new ArrayList<>();
    public static ArrayList<ChunkReplaceableBlocks> replaceableBlocks = new ArrayList<>();
    public static worldGenProgress worldGenProgress;
    public static ArrayList<Biome> mesaBiomes = new ArrayList<>();
    public static ArrayList<Biome> mistyMountainsBiomes = new ArrayList<>();
    public static ArrayList<Biome> volcanoBiomes = new ArrayList<>();

    @Mod.Instance
    public static Main instance;


    @SidedProxy(

            clientSide=CLIENT_PROXY_CLASS,

            serverSide=COMMON_PROXY_CLASS

    )
    public static IProxy proxy;




    static {
        FluidRegistry.enableUniversalBucket();
    }

    public static final CreativeTabs mbtab = new wntab("WildNature");
    public static final CreativeTabs wnTabUnderground = new wntabunderground("WildNature Underground");
    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event){
        //Locale.setDefault(Locale.ENGLISH);
        FMLCommonHandler.instance().bus().register(new playerJoinEvent());
        //FMLCommonHandler.instance().bus().register(new fogEvent());

        FluidInit.registerFluid();


        proxy.preInit(event);
    }




    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        new listAdapter();
        SoundHandler.registerSounds();
        ModEntities.registerEntities();


        BiomeInit.registerBiomes();

        addBiomeCategories();
        //GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(),0);
        GameRegistry.registerWorldGenerator(new WorldGenOres(),0);
        //GameRegistry.registerWorldGenerator(new WorldGenBlocks(),1);


        TileEntityHandler.registerTileEntities();
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());

        GameRegistry.addSmelting(ModItems.RAW_BOAR,new ItemStack(ModItems.COOKED_BOAR),2);
        GameRegistry.addSmelting(ModItems.RAW_GOAT,new ItemStack(ModItems.COOKED_GOAT),3);
        GameRegistry.addSmelting(ModItems.RAW_CAMEL,new ItemStack(ModItems.COOKED_CAMEL),4);
        GameRegistry.addSmelting(ModItems.RAW_BISON,new ItemStack(ModItems.COOKED_BISON),5);
        GameRegistry.addSmelting(Blocks.SANDSTONE,new ItemStack(ModBlocks.HARDENED_SANDSTONE),1);
        GameRegistry.addSmelting(Blocks.RED_SANDSTONE,new ItemStack(ModBlocks.RED_HARDENED_SANDSTONE),1);
        GameRegistry.addSmelting(ModBlocks.FROZEN_COBBLESTONE,new ItemStack(ModBlocks.FROZEN_STONE),1);
        GameRegistry.addSmelting(ModBlocks.SILVER_ORE,new ItemStack(ModItems.SILVER_INGOT),7);
        new CraftingDictionary().registerAll();
        new IronworksRecipeAdd();


        proxy.init(event);
    }

    @Mod.EventHandler
    public static void PostInit(FMLPostInitializationEvent event){



        Main.WildNatureWORLDTYPE = new WildNatureWorldType("WildNature");
        Main.ExperimentalWORLDTYPE = new WildNatureEXWorldType("WildNature EX");

        //FMLCommonHandler.instance().bus().register(new chunkReplacer(replaceableBlocks));
        FMLCommonHandler.instance().bus().register(new entityJoinEvent());


        //worldGenProgress progress = new worldGenProgress();

        proxy.postInit(event);
    }



    private static void addBiomeCategories(){

        addBiomeList(BiomesICY, BiomeManager.BiomeType.ICY);
        addBiomeList(BiomesCOOL, BiomeManager.BiomeType.COOL);
        addBiomeList(BiomesWARM, BiomeManager.BiomeType.WARM);
        addBiomeList(BiomesDESERT, BiomeManager.BiomeType.DESERT);


        BiomesICY.remove(BiomeInit.ROCKY_MOUNTAINS);
        BiomesDESERT.remove(BiomeInit.VOLCANO);
        BiomesDESERT.remove(BiomeInit.GRAND_CANYON);
        BiomesDESERT.remove(BiomeInit.LIGHT_MESA);
        BiomesDESERT.add(getBiomeByName("desert"));
        BiomesDESERT.add(getBiomeByName("desert_hills"));
        BiomesDESERT.add(getBiomeByName("mutated_desert"));


        volcanoBiomes.add(BiomeInit.VOLCANO);

        mistyMountainsBiomes.add(BiomeInit.MISTY_MOUNTAINS);

        mesaBiomes.add(BiomeInit.LIGHT_MESA);
        mesaBiomes.add(BiomeInit.GRAND_CANYON);
        mesaBiomes.add(getBiomeByName("mesa"));
        mesaBiomes.add(getBiomeByName("mesa_rock"));
        mesaBiomes.add(getBiomeByName("mesa_clear_rock"));
        mesaBiomes.add(getBiomeByName("mutated_mesa"));
        mesaBiomes.add(getBiomeByName("mutated_mesa_rock"));
        mesaBiomes.add(getBiomeByName("mutated_mesa_clear_rock"));




        ArrayList<ReplaceBase> icyReplace = new ArrayList<>();
        ArrayList<ReplaceBase> desertReplace = new ArrayList<>();
        ArrayList<ReplaceBase> volcanoReplace = new ArrayList<>();
        ArrayList<ReplaceBase> mistyMountainsReplace = new ArrayList<>();
        ArrayList<ReplaceBase> mesaReplace = new ArrayList<>();

        icyReplace.add(new ReplaceBase(Blocks.STONE.getDefaultState(),ModBlocks.FROZEN_STONE.getDefaultState()));
        icyReplace.add(new ReplaceBase(Blocks.DIRT.getDefaultState(),ModBlocks.FROZEN_DIRT.getDefaultState()));
        desertReplace.add(new ReplaceBase(Blocks.STONE.getDefaultState(),ModBlocks.HARDENED_SANDSTONE.getDefaultState()));
        desertReplace.add(new ReplaceBase(Blocks.DIRT.getDefaultState(),ModBlocks.ZIEMA_PUSTYNNA.getDefaultState()));
        mesaReplace.add(new ReplaceBase(Blocks.STONE.getDefaultState(),ModBlocks.RED_HARDENED_SANDSTONE.getDefaultState()));

        volcanoReplace.add(new ReplaceBase(Blocks.STONE.getDefaultState(),ModBlocks.ASH_BLOCK.getDefaultState()));
        mistyMountainsReplace.add(new ReplaceBase(Blocks.STONE.getDefaultState(),ModBlocks.DARK_STONE.getDefaultState()));

        replaceableBlocks.add(new ChunkReplaceableBlocks(icyReplace,BiomesICY));
        replaceableBlocks.add(new ChunkReplaceableBlocks(desertReplace, BiomesDESERT));
        replaceableBlocks.add(new ChunkReplaceableBlocks(volcanoReplace, volcanoBiomes));
        replaceableBlocks.add(new ChunkReplaceableBlocks(mistyMountainsReplace, mistyMountainsBiomes));
        replaceableBlocks.add(new ChunkReplaceableBlocks(mesaReplace, mesaBiomes));
    }

    public static void sendMessage(EntityPlayer player, String message){
        ITextComponent msg =  new TextComponentString(message);
        player.sendMessage(msg);
    }
    public static void sendActionBar(EntityPlayer player,int ticks, String message){
        ITextComponent msg =  new TextComponentString(message);
        SPacketTitle title = new SPacketTitle(SPacketTitle.Type.ACTIONBAR,msg,20,ticks,70);
        EntityPlayerMP mp = (EntityPlayerMP) player;
        mp.connection.sendPacket(title);

    }


    private static void addBiomeList(ArrayList<Biome> list, BiomeManager.BiomeType type){
        int idk = 0;
        while(idk<BiomeManager.getBiomes(type).size()){
            list.add(BiomeManager.getBiomes(type).get(idk).biome);
            idk++;
        }
    }

    @Nullable
    public static Biome getBiomeByName(String name){
        List<Biome> values = ForgeRegistries.BIOMES.getValues();
        int idk = 0;
        while(idk<values.size()){
            if(values.get(idk).getRegistryName().getResourcePath().equals(name)){
                return values.get(idk);
            }
            idk++;
        }
        return null;
    }



    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event){
        event.registerServerCommand(new WildNatureCommand());
    }

    public static int generateRandomInt(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public static int generateRandomInt(int min, int max, Random rand) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }


        return rand.nextInt((max - min) + 1) + min;
    }


    public static List<Block> getNearBlockName(World world,BlockPos pos){
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        List<Block> list = new ArrayList<>();

        list.add(world.getBlockState(new BlockPos(x+1,y,z)).getBlock());
        list.add(world.getBlockState(new BlockPos(x-1,y,z)).getBlock());
        list.add(world.getBlockState(new BlockPos(x,y,z+1)).getBlock());
        list.add(world.getBlockState(new BlockPos(x,y,z-1)).getBlock());
        list.add(world.getBlockState(new BlockPos(x,y+1,z)).getBlock());
        list.add(world.getBlockState(new BlockPos(x,y-1,z)).getBlock());

        return list;

    }
    public static List getNearBlockState(World world,BlockPos pos){
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        List<IBlockState> list = new ArrayList<>();

        list.add(world.getBlockState(new BlockPos(x+1,y,z)));
        list.add(world.getBlockState(new BlockPos(x-1,y,z)));
        list.add(world.getBlockState(new BlockPos(x,y,z+1)));
        list.add(world.getBlockState(new BlockPos(x,y,z-1)));
        list.add(world.getBlockState(new BlockPos(x,y+1,z)));
        list.add(world.getBlockState(new BlockPos(x,y-1,z)));

        return list;

    }

    public static List getNearBlockStateUpDown(World world,BlockPos pos){
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        List<IBlockState> list = new ArrayList<>();

        list.add(world.getBlockState(new BlockPos(x,y+1,z)));
        list.add(world.getBlockState(new BlockPos(x,y-1,z)));

        return list;

    }

    public static boolean isTheSameBlockNear(World world, BlockPos pos,boolean withState){
        List<Block> listBlock = getNearBlockName(world,pos);
        List<IBlockState> listState = getNearBlockState(world,pos);
        Block thisBlock = world.getBlockState(pos).getBlock();
        IBlockState thisState = world.getBlockState(pos);
        IBlockState thisBlockState = world.getBlockState(pos);
        int listLoop = 0;
        boolean sameBlockEIsNear = false;

        while(listLoop < listBlock.size() && !sameBlockEIsNear){
                if (listBlock.get(listLoop) == thisBlock) {
                    if(withState) {
                        if (listState.get(listLoop) == thisState) {
                            sameBlockEIsNear = true;
                            break;
                        }
                    }else{
                        sameBlockEIsNear = true;
                        break;
                    }
                }


            listLoop++;
        }

        return sameBlockEIsNear;

    }



    public static String stringToRainbow(String parString, boolean parReturnToBlack)
    {
        int stringLength = parString.length();
        if (stringLength < 1)
        {
            return "";

        }
        String outputString = "";
        TextFormatting[] colorChar =
                {

                        TextFormatting.RED,

                        TextFormatting.GOLD,

                        TextFormatting.YELLOW,

                        TextFormatting.GREEN,

                        TextFormatting.AQUA,

                        TextFormatting.BLUE,

                        TextFormatting.LIGHT_PURPLE,

                        TextFormatting.DARK_PURPLE

                };

        for (int i = 0; i < stringLength; i++)
        {
            outputString = outputString+colorChar[i%8]+parString.substring(i, i+1);

        }
        // return color to a common one after (most chat is white, but for other GUI might want black)
        if (parReturnToBlack)
        {
            return outputString+TextFormatting.BLACK;

        }
        return outputString+TextFormatting.WHITE;
    }



    public static String stringToGolden(String parString, int parShineLocation, boolean parReturnToBlack)
    {
        int stringLength = parString.length();
        if (stringLength < 1)
        {
            return "";

        }
        String outputString = "";
        for (int i = 0; i < stringLength; i++)
        {
            if ((i+parShineLocation+ Minecraft.getSystemTime()/20)%88==0)

            {

                outputString = outputString+ TextFormatting.WHITE+parString.substring(i, i+1);

            }

            else if ((i+parShineLocation+Minecraft.getSystemTime()/20)%88==1)

            {

                outputString = outputString+TextFormatting.YELLOW+parString.substring(i, i+1);

            }

            else if ((i+parShineLocation+Minecraft.getSystemTime()/20)%88==87)

            {

                outputString = outputString+TextFormatting.YELLOW+parString.substring(i, i+1);

            }

            else

            {

                outputString = outputString+TextFormatting.GOLD+parString.substring(i, i+1);

            }

        }
        // return color to a common one after (most chat is white, but for other GUI might want black)
        if (parReturnToBlack)
        {
            return outputString+TextFormatting.BLACK;

        }
        return outputString+TextFormatting.WHITE;
    }



    public static boolean isTheSameBlockNear(IBlockState thisBlock, World world, BlockPos pos,boolean withState){
        List<Block> listBlock = getNearBlockName(world,pos);
        List<IBlockState> listState = getNearBlockState(world,pos);

        IBlockState thisState = world.getBlockState(pos);
        IBlockState thisBlockState = world.getBlockState(pos);
        int listLoop = 0;
        boolean sameBlockEIsNear = false;

        while(listLoop < listBlock.size() && !sameBlockEIsNear){
            if (listBlock.get(listLoop) == thisBlock) {
                if(withState) {
                    if (listState.get(listLoop) == thisState) {
                        sameBlockEIsNear = true;
                        break;
                    }
                }else{
                    sameBlockEIsNear = true;
                    break;
                }
            }


            listLoop++;
        }

        return sameBlockEIsNear;

    }

    public static boolean isWaterCorrect(BlockPos waterBlock, World worldIn, ChunkPrimer chunkPrimer, IBlockState replace, IBlockState riverBottom){
        try {

            /*if(!worldIn.getBlockState(waterBlock.down()).getBlock().equals(Blocks.WATER) || !worldIn.getBlockState(waterBlock.down()).getBlock().equals(Blocks.FLOWING_WATER)) {
                if (worldIn.getBlockState(waterBlock.up()).getBlock().equals(Blocks.WATER) || worldIn.getBlockState(waterBlock.up()).getBlock().equals(Blocks.FLOWING_WATER)) {
                    chunkPrimer.setBlockState(waterBlock.down().getX(), waterBlock.down().getY(), waterBlock.down().getZ(), riverBottom);
                    ArrayList<EnumFacing> facings = new ArrayList<>();

                    if (!worldIn.getBlockState(waterBlock.south()).getBlock().equals(Blocks.WATER) || !worldIn.getBlockState(waterBlock.south()).getBlock().equals(Blocks.FLOWING_WATER)) {
                        facings.add(EnumFacing.SOUTH);
                    }
                    if (!worldIn.getBlockState(waterBlock.north()).getBlock().equals(Blocks.WATER) || !worldIn.getBlockState(waterBlock.north()).getBlock().equals(Blocks.FLOWING_WATER)) {
                        facings.add(EnumFacing.NORTH);
                    }
                    if (!worldIn.getBlockState(waterBlock.east()).getBlock().equals(Blocks.WATER) || !worldIn.getBlockState(waterBlock.east()).getBlock().equals(Blocks.FLOWING_WATER)) {
                        facings.add(EnumFacing.EAST);
                    }
                    if (!worldIn.getBlockState(waterBlock.west()).getBlock().equals(Blocks.WATER) || !worldIn.getBlockState(waterBlock.west()).getBlock().equals(Blocks.FLOWING_WATER)) {
                        facings.add(EnumFacing.WEST);
                    }

                    if (facings.size() >= 2) {
                        System.out.println("RIVER " + waterBlock.toString());
                        chunkPrimer.setBlockState(waterBlock.getX(), waterBlock.getY(), waterBlock.getZ(), riverBottom);
                    }

                }
            }*/

            boolean toReturn = true;
            ArrayList<EnumFacing> facings = new ArrayList<>();

            if (worldIn.getBlockState(waterBlock.up()).getBlock().equals(Blocks.AIR)) {
                if (worldIn.getBlockState(waterBlock.south()).getBlock().equals(Blocks.AIR)) {
                    facings.add(EnumFacing.SOUTH);
                }
                if (worldIn.getBlockState(waterBlock.north()).getBlock().equals(Blocks.AIR)) {
                    facings.add(EnumFacing.NORTH);
                }
                if (worldIn.getBlockState(waterBlock.east()).getBlock().equals(Blocks.AIR)) {
                    facings.add(EnumFacing.EAST);
                }
                if (worldIn.getBlockState(waterBlock.west()).getBlock().equals(Blocks.AIR)) {
                    facings.add(EnumFacing.WEST);
                }
            }

            waterBlock = waterBlock.down();

            if (worldIn.getBlockState(waterBlock.south()).getBlock().equals(Blocks.WATER) || worldIn.getBlockState(waterBlock.south()).getBlock().equals(Blocks.FLOWING_WATER)) {
                facings.remove(EnumFacing.SOUTH);
            }
            if (worldIn.getBlockState(waterBlock.north()).getBlock().equals(Blocks.WATER) || worldIn.getBlockState(waterBlock.south()).getBlock().equals(Blocks.FLOWING_WATER)) {
                facings.remove(EnumFacing.NORTH);
            }
            if (worldIn.getBlockState(waterBlock.east()).getBlock().equals(Blocks.WATER) || worldIn.getBlockState(waterBlock.south()).getBlock().equals(Blocks.FLOWING_WATER)) {
                facings.remove(EnumFacing.EAST);
            }
            if (worldIn.getBlockState(waterBlock.west()).getBlock().equals(Blocks.WATER) || worldIn.getBlockState(waterBlock.south()).getBlock().equals(Blocks.FLOWING_WATER)) {
                facings.remove(EnumFacing.WEST);
            }


            if (facings.contains(EnumFacing.NORTH)) {
                int a = 0;
                boolean does = false;
                while (a < 8) {
                    if (worldIn.getBlockState(waterBlock.north().down(a)).getBlock().equals(Blocks.WATER) || worldIn.getBlockState(waterBlock.north().down(a)).getBlock().equals(Blocks.FLOWING_WATER)) {

                    } else {
                        does = true;
                        toReturn = false;
                    }
                    a++;
                }
                if (does) {
                    chunkPrimer.setBlockState(waterBlock.north().getX(), waterBlock.north().getY(), waterBlock.north().getZ(), replace);
                }
            }

            if (facings.contains(EnumFacing.SOUTH)) {
                int a = 0;
                boolean does = false;
                while (a < 8) {
                    if (worldIn.getBlockState(waterBlock.south().down(a)).getBlock().equals(Blocks.WATER) || worldIn.getBlockState(waterBlock.south().down(a)).getBlock().equals(Blocks.FLOWING_WATER)) {

                    } else {
                        does = true;
                        toReturn = false;
                    }
                    a++;
                }
                if (does) {
                    chunkPrimer.setBlockState(waterBlock.south().getX(), waterBlock.south().getY(), waterBlock.south().getZ(), replace);
                }
            }

            if (facings.contains(EnumFacing.EAST)) {
                int a = 0;
                boolean does = false;
                while (a < 8) {
                    if (worldIn.getBlockState(waterBlock.east().down(a)).getBlock().equals(Blocks.WATER) || worldIn.getBlockState(waterBlock.east().down(a)).getBlock().equals(Blocks.FLOWING_WATER)) {

                    } else {
                        does = true;
                        toReturn = false;
                    }
                    a++;
                }
                if (does) {
                    chunkPrimer.setBlockState(waterBlock.east().getX(), waterBlock.east().getY(), waterBlock.east().getZ(), replace);
                }
            }

            if (facings.contains(EnumFacing.WEST)) {
                int a = 0;
                boolean does = false;
                while (a < 8) {
                    if (worldIn.getBlockState(waterBlock.west().down(a)).getBlock().equals(Blocks.WATER) || worldIn.getBlockState(waterBlock.west().down(a)).getBlock().equals(Blocks.FLOWING_WATER)) {

                    } else {
                        does = true;
                        toReturn = false;
                    }
                    a++;
                }
                if (does) {
                    chunkPrimer.setBlockState(waterBlock.west().getX(), waterBlock.west().getY(), waterBlock.west().getZ(), replace);
                }
            }

            return toReturn;
        }catch (Exception e){
            return true;
        }
    }

    public static boolean isTheSameBlockNearUpDown(IBlockState thisBlock, World world, BlockPos pos){
        IBlockState UP = world.getBlockState(pos.up());
        IBlockState DOWN = world.getBlockState(pos.down());
        boolean isNearUP =false;
        boolean isNearDOWN =false;

        if(UP.equals(thisBlock)){
            isNearUP = true;
        } else{
            isNearUP = false;
        }

        if(DOWN.equals(thisBlock)){
            isNearDOWN = true;
        }else{
            isNearDOWN = false;
        }

        if(isNearUP==true){
            return true;
        }else if(isNearDOWN==true){
            return true;
        }else{
            return false;
        }

    }

    public static IBlockState getStateForSameNearBlock(World world, BlockPos pos){
        List<Block> listBlock = getNearBlockName(world,pos);
        List<IBlockState> listState = getNearBlockState(world,pos);
        Block thisBlock = world.getBlockState(pos).getBlock();
        IBlockState thisState = world.getBlockState(pos);
        IBlockState thisBlockState = world.getBlockState(pos);
        int listLoop = 0;



        while(listLoop < listBlock.size()){
            if (listBlock.get(listLoop) == thisBlock) {
                return listState.get(listLoop);
            }


            listLoop++;
        }

        return null;

    }

    public static Block getBlockAt(World world, BlockPos pos){
        Block thisBlock = world.getBlockState(pos).getBlock();
        return thisBlock;
    }

    public static ArrayList<BlockPos> generateNaturalLeaves(BlockPos startPos, int X,int Y,int Z,IBlockState blockstate){
        ArrayList<BlockPos> posList = new ArrayList<BlockPos>();

        int whileCounter = 0;

        posList.add(new BlockPos(startPos));


        return posList;
    }



}