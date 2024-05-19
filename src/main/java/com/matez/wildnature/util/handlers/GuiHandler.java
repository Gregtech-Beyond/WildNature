package com.matez.wildnature.util.handlers;

import com.matez.wildnature.blocks.TileEntities.TileEntityIronworks;
import com.matez.wildnature.gui.containers.ironworks_container;
import com.matez.wildnature.gui.containers.ironworks_gui;
import com.matez.wildnature.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

    public class GuiHandler implements IGuiHandler
    {
        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
        {
            if(ID == Reference.GUI_IRONWORKS) return new ironworks_container(player.inventory, (TileEntityIronworks) world.getTileEntity(new BlockPos(x,y,z)));
            return null;
        }

        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
        {
            if(ID == Reference.GUI_IRONWORKS) return new ironworks_gui(player.inventory, (TileEntityIronworks) world.getTileEntity(new BlockPos(x,y,z)));
            return null;
        }
    }
