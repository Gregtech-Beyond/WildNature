package com.matez.wildnature.util;

import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.fml.common.FMLCommonHandler;

public interface IStructure {
    public static final WorldServer worldserver = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(0);
    public static final PlacementSettings settings = (new PlacementSettings()).setChunk(null).setIgnoreEntities(false).setIgnoreStructureBlock(true).setMirror(Mirror.NONE).setRotation(Rotation.NONE);
}