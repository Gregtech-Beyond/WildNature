package com.matez.wildnature.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentSelector;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.WorldType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.matez.wildnature.Main.*;

public class playerJoinEvent {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
        if(event.player!=null) {
            //worldGenProgress.visible = false;
            //worldGenProgress.setVisible(false);
            if (!(event.player.getEntityWorld().getWorldType() == WildNatureWORLDTYPE) && !(event.player.getEntityWorld().getWorldType() == WorldType.FLAT)) {
                sendMessage(event.player, megaPrefix + "You are using not reference world settings.");
                sendMessage(event.player, megaPrefix + "It may cause ugly and buggy terrain type.");
                sendMessage(event.player, megaPrefix + "Please create new world with WildNature world settings.");
                sendActionBar(event.player, 800, TextFormatting.RED + "This world isn't supported by WildNature.");
            } else if ((event.player.getEntityWorld().getWorldType() == WorldType.FLAT)) {
                sendMessage(event.player, megaPrefix + TextFormatting.AQUA + "Welcome " + event.player.getDisplayNameString() + " to this flat world!");
                sendActionBar(event.player, 800, TextFormatting.GREEN + "Welcome to flat world!");
            } else {
                String message = megaPrefix + TextFormatting.AQUA + "Welcome " + event.player.getDisplayNameString() + " to this fantastic world!";
                sendMessage(event.player, message);
                sendActionBar(event.player, 800, TextFormatting.GREEN + "Welcome to world generated by WildNature!");
            }
            ITextComponent msg = new TextComponentString(megaPrefix + TextFormatting.RED + "Remember, that WildNature mod is beta. All issues please report to mod Issue Tracker by clicking here.");
            msg.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://minecraft.curseforge.com/projects/wildnature/issues"));
            event.player.sendMessage(msg);
        }
    }



}