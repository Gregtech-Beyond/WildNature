package com.matez.wildnature.event;

import com.matez.wildnature.gui.screen.GenStatus;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class worldGenProgress{

    Timer timer,timer2;
    public boolean visible = false;
    public boolean generating = false;
    public int percent = 0;
    private GenStatus status;

    public worldGenProgress(){
        activateTimer();
    }

    private void activateTimer(){
        timer2 = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(generating && status!=null){
                    if(Minecraft.getMinecraft().currentScreen!=null) {
                        boolean focus = Minecraft.getMinecraft().currentScreen.isFocused();
                        status.setVisible(focus);
                        status.setAlwaysOnTop(focus);
                    }
                }else if(!generating){
                    status.setVisible(false);
                }
            }
        });

        timer2.setRepeats(true);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Minecraft.getMinecraft().getIntegratedServer()!=null) {
                    String message = Minecraft.getMinecraft().getIntegratedServer().currentTask + "";
                    percent = Minecraft.getMinecraft().getIntegratedServer().percentDone;



                    if (message.contains("Preparing spawn area")) {
                        visible = true;
                        generating=true;
                    }

                }

                if(generating){
                    if(status==null){
                        status = new GenStatus();

                    }
                    status.label.setText(percent+"%");
                    timer2.start();
                }else{
                    status=null;
                    timer2.stop();
                }
            }
        });

        timer.setRepeats(true);
        timer.start();



    }



}
