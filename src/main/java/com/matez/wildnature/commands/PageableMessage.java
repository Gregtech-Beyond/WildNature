package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PageableMessage {
    private ArrayList<String> lines;
    private ArrayList<ArrayList<String>> pages = new ArrayList<>();
    private int linesPerPage,allLines;
    private ArrayList<String> page;
    private String startString,endString, prefix;
    public PageableMessage(ArrayList<String> lines,int linesPerPage,String startString, String endString, String prefix){
        this.lines=lines;
        this.linesPerPage=linesPerPage;
        this.startString=startString;
        this.endString=endString;
        this.prefix=prefix;

        int a = 0;
        int curr = 0;

        while(a<lines.size()){
            if(curr>=linesPerPage){
                curr = 0;
                allLines++;
                pages.add(page);
            }
            if(curr==0) {
                page = new ArrayList<>();
            }
            page.add(lines.get(a));
            curr++;

            a++;
        }
        if(curr!=0){
            allLines++;
            pages.add(page);
        }
    }

    public int getAllLines(){
        return allLines;
    }
    public void setStartString(String string){
        this.startString=string;
    }
    public void setEndString(String string){
        this.endString=string;
    }
    public void setPrefix(String string){
        this.prefix=string;
    }
    public void show(EntityPlayer player, int page){
        if(page>allLines || page<1){
            throw new ArrayIndexOutOfBoundsException("Page not found");
        }
        if(!startString.isEmpty()) {
            Main.sendMessage(player, startString);
        }
        int a = 0;
        try {
            while (a < pages.get(page - 1).size()) {
                String pfx = prefix.replace("<$line>", (a * pages.indexOf(pages.get(page - 1))) + "");
                Main.sendMessage(player, pfx + pages.get(page - 1).get(a));
                a++;
            }
        }catch(IndexOutOfBoundsException e){
            Main.sendMessage(player, prefix.replace("<$line>", "#") + " ");
        }
        if(!endString.isEmpty()) {
            Main.sendMessage(player, endString);
        }
    }
}
