package com.matez.wildnature.util.handlers;

import com.matez.wildnature.blocks.TileEntities.TileEntityIronworks;
import com.matez.wildnature.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityIronworks.class, new ResourceLocation(Reference.MOD_ID + ":ironworks"));
    }
}
