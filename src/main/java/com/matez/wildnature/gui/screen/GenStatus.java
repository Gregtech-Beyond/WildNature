package com.matez.wildnature.gui.screen;

import com.matez.wildnature.Main;
import net.minecraft.client.Minecraft;

import javax.swing.*;
import java.awt.*;


public class GenStatus extends JFrame {

    private JPanel panel;
    public JLabel label;
    public GenStatus(){
        setSize(150,90);
        setUndecorated(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout());
        setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        label = new JLabel(Main.worldGenProgress.percent+"%");
        label.setFont(new Font("Consolas",Font.PLAIN,20));
        panel.add(label,BorderLayout.CENTER);
        add(panel);


    }

}
