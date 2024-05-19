package com.matez.wildnature.commands;

import com.jcraft.jogg.Page;
import com.matez.wildnature.Main;
import com.matez.wildnature.worldgen.WorldGenFromFile;
import com.matez.wildnature.worldgen.WorldGenSchematicTree;
import com.matez.wildnature.worldgen.schematics.trees.listAdapter;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nullable;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WildNatureCommand implements ICommand {
    private final int badInt = -987654321;
    @Override
    public String getName() {
        return "wildnature";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        String s = "";
        int a = 0;
        ArrayList<String> strings = help();
        while(a<strings.size()){
            if(s.isEmpty()){
                s = strings.get(a);
            }else{
                s = s + "\n"+strings.get(a);
            }
            a++;
        }
        return s;
    }





    @Override
    public List<String> getAliases() {
        ArrayList<String> list = new ArrayList<>();
        list.add("wn");
        return list;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        ArrayList<String> arrayArgs = new ArrayList<>(Arrays.asList(args));
        System.out.println("COMMAND: " + arrayArgs.toString());
        String cmd1 = "",cmd2 = "",cmd3 = "";
        try {
            cmd1 = arrayArgs.get(0);
            cmd2 = arrayArgs.get(1);
            cmd3 = arrayArgs.get(2);
        }catch (Exception e){}
        int g = 0;

        System.out.println(Main.generatorList.toString());


        int x = 0;
        int y = 0;
        int lists = 0;
        int currentList = 1;

        if(cmd1.equals("help")){
            if(cmd2.isEmpty()){
                cmd3 = 1+"";
            }
            int currentPage = parseInt(cmd2,sender);
            PageableMessage pageableMessage = new PageableMessage(help(),5,"","","");
            String startString = TextFormatting.DARK_PURPLE+"[#]"+TextFormatting.DARK_AQUA+"["+currentPage+"/"+pageableMessage.getAllLines()+"]"+TextFormatting.GOLD+" List of all WildNature commands:";
            String endString = TextFormatting.DARK_PURPLE+"[#]"+TextFormatting.DARK_AQUA+"-----------------------------------=-\n";
            String prefix = TextFormatting.DARK_PURPLE+"[<$line>] ";
            pageableMessage.setStartString(startString);
            pageableMessage.setEndString(endString);
            pageableMessage.setPrefix(prefix);
        }else if(cmd1.equals("generate")){


            if(cmd2.equals("list")){
                if(cmd3.isEmpty()){
                    cmd3 = 1+"";
                }
                ArrayList<String> generators = new ArrayList<>();
                int a = 0;
                while(a<Main.generatorList.size()){
                    String s = Main.generatorList.get(a).getClass().getSimpleName();
                    if(Main.generatorList.get(a) instanceof WorldGenFromFile){
                        s=((WorldGenFromFile)Main.generatorList.get(a)).getName();
                    }
                    generators.add(TextFormatting.GOLD+s);
                    a++;
                }
                int currentPage = parseInt(cmd3,sender);
                PageableMessage pageableMessage = new PageableMessage(generators,8,"","","");
                String startString = TextFormatting.DARK_PURPLE+"[#]"+TextFormatting.DARK_AQUA+"["+currentPage+"/"+pageableMessage.getAllLines()+"]"+TextFormatting.GOLD+" List of all generators:";
                String endString = TextFormatting.DARK_PURPLE+"[#]"+TextFormatting.DARK_AQUA+"-----------------------------------=-\n";
                String prefix = TextFormatting.DARK_PURPLE+"[<$line>] ";
                pageableMessage.setStartString(startString);
                pageableMessage.setEndString(endString);
                pageableMessage.setPrefix(prefix);
                try {
                    if(currentPage!=badInt) {
                        pageableMessage.show((EntityPlayer) sender.getCommandSenderEntity(), currentPage);
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    ITextComponent msg =  new TextComponentString(Main.megaPrefix+ TextFormatting.RED+"Unknown page.");
                    sender.sendMessage(msg);
                }

            }else {
                x = 0;
                WorldGenSchematicTree clazz = null;
                boolean correct = false;
                while(x<Main.generatorList.size()){
                    if(cmd2.equals(Main.generatorList.get(x).getClass().getSimpleName())){
                        clazz = Main.generatorList.get(x);
                        correct= true;
                        break;
                    }
                    x++;
                }
                if(!correct){
                    ITextComponent msg =  new TextComponentString(Main.megaPrefix+ TextFormatting.RED+"Unknown generator! Type /nw generate list to see all generators.");
                    sender.sendMessage(msg);
                }else{

                    clazz.generate(sender.getEntityWorld(),new Random(),sender.getPosition());

                }

            }
        }else if(cmd1.equals("biome")){
            String oldCmd3 = cmd3;
            if(cmd3.isEmpty()){
                cmd3 = 1+"";
            }
            ArrayList<String> biomes = new ArrayList<>();
            int a = 0;
            while(a<Main.biomeList.size()){
                biomes.add(TextFormatting.DARK_PURPLE+"["+ Biome.getIdForBiome(Main.biomeList.get(a))+"] "+TextFormatting.GOLD+Main.biomeList.get(a).getBiomeName());
                a++;
            }
            int currentPage = parseInt(cmd3,sender);
            PageableMessage pageableMessage = new PageableMessage(biomes,8,"","","");
            String startString = TextFormatting.DARK_PURPLE+"[#]"+TextFormatting.DARK_AQUA+"["+currentPage+"/"+pageableMessage.getAllLines()+"]"+TextFormatting.GOLD+" List of all WildNature biomes:\n"+TextFormatting.DARK_AQUA+"[ID]    [NAME]";
            String endString = TextFormatting.DARK_PURPLE+"[#]"+TextFormatting.DARK_AQUA+"-----------------------------------=-\n";
            String prefix = "";
            pageableMessage.setStartString(startString);
            pageableMessage.setEndString(endString);
            pageableMessage.setPrefix(prefix);
            cmd3 = oldCmd3;

            if(cmd2.equals("name")){
                String name ="unknown";
                int id = parseInt(cmd3,sender);
                int b = 0;
                ArrayList<Biome> biomeSet = new ArrayList<>(ForgeRegistries.BIOMES.getValuesCollection());
                while(b<ForgeRegistries.BIOMES.getEntries().size()){
                    Biome test = biomeSet.get(b);
                    if(id==Biome.getIdForBiome(test)){
                        name = test.getBiomeName();
                    }
                    b++;
                }

                Main.sendMessage((EntityPlayer) sender,Main.megaPrefix+ TextFormatting.GOLD+"Name of biome with ID "+TextFormatting.DARK_AQUA + cmd3 +TextFormatting.GOLD + " is " + TextFormatting.DARK_AQUA + name);
            }else if(cmd2.equals("tp")){

            }else if(cmd2.equals("list")){

                try {
                    if(currentPage!=badInt) {
                        pageableMessage.show((EntityPlayer) sender.getCommandSenderEntity(), currentPage);
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    ITextComponent msg =  new TextComponentString(Main.megaPrefix+ TextFormatting.RED+"Unknown page.");
                    sender.sendMessage(msg);
                }
            }else{

            }
        }else{
            ITextComponent msg =  new TextComponentString(Main.megaPrefix+ TextFormatting.RED+"Unknown command! Type /wn help to get list of all commands.");
            sender.sendMessage(msg);
        }

    }

    private int parseInt(String string, ICommandSender sender){
        int a = -987654321;
        try{
           a = Integer.parseInt(string);
        }catch(Exception e){
            ITextComponent msg =  new TextComponentString(Main.megaPrefix+ TextFormatting.RED+"Cannot convert \"" + string + "\" into a number");
            sender.sendMessage(msg);
        }
        return a;
    }

    private ArrayList<String> help(){
        ArrayList<String> helpList = new ArrayList<>();
        helpList.add(TextFormatting.GOLD+"/wn generate <id> "+TextFormatting.GRAY+"- generates structure with id <id>");
        helpList.add(TextFormatting.GOLD+"/wn generate list <page> "+TextFormatting.GRAY+"- shows list of all WildNature structures");
        helpList.add(TextFormatting.GOLD+"/wn biome name <id> "+TextFormatting.GRAY+"- shows biome name with id <id>");
        helpList.add(TextFormatting.GOLD+"/wn biome list <page> "+TextFormatting.GRAY+"- shows list of all WildNature biomes");
        return helpList;
    }

    private void unknownUse(ICommandSender sender){
        ITextComponent msg =  new TextComponentString(Main.megaPrefix+ TextFormatting.RED+"Unknown subcommand! Type /wn help to get list of all commands.");
        sender.sendMessage(msg);
    }


    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }


}