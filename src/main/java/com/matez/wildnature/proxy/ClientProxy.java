package com.matez.wildnature.proxy;

import com.matez.wildnature.Main;
import com.matez.wildnature.event.foresterEvent;
import com.matez.wildnature.init.WildNatureBlockColors;
import com.matez.wildnature.util.IProxy;
import com.matez.wildnature.util.Reference;
import com.matez.wildnature.util.handlers.RenderHandler;
import com.matez.wildnature.worldgen.type.WildNatureWorldType;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

import javax.xml.ws.handler.MessageContext;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MOD_ID)
public class ClientProxy implements IProxy {
    public void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item,meta,new ModelResourceLocation(item.getRegistryName(),id));
    }

    public void preInit(FMLPreInitializationEvent event){
        RenderHandler.registerEntityRenders();
        RenderHandler.registerCustomMeshesAndStates();
    }
    public void init(FMLInitializationEvent event){
        System.out.println("Init...");

        WildNatureBlockColors.registerBlockColors();

    }

    public void postInit(FMLPostInitializationEvent event)
    {
        // DEBUG
        FMLCommonHandler.instance().bus().register(new foresterEvent());
        System.out.println("PostInit...");
    }

    @Override
    public void serverStarting(FMLServerStartingEvent event) {

    }

    @Override
    public EntityPlayer getPlayerEntityFromContext(MessageContext parContext) {
        return null;
    }
}