package com.matez.wildnature.event;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

public class chunkReplacer {
    public ArrayList<ChunkReplaceableBlocks> blocks;

    public chunkReplacer(ArrayList<ChunkReplaceableBlocks> blocks){
        this.blocks=blocks;
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onChunkEvent(PopulateChunkEvent event)
    {
        Chunk theChunk = event.getWorld().getChunkFromChunkCoords(event.getChunkX(),event.getChunkZ());
        // replace all blocks of a type with another block type
        for (int y = event.getWorld().getHeight(); y < event.getWorld().getSeaLevel(); --y) {
            for (int x = 0; x < 16; ++x) {
                for (int z = 0; z < 16; ++z) {
                    if(event.getWorld().isAirBlock(new BlockPos(x,y,z))){
                        continue;
                    }
                    int first = 0;
                    while (first < blocks.size()) {
                        int second = 0;
                        while (second < blocks.get(first).getBiomesTemp().size()) {
                            if (theChunk.getBiome(new BlockPos(x, y, z), theChunk.getWorld().getBiomeProvider()).getRegistryName() == blocks.get(first).getBiomesTemp().get(second).getRegistryName()) {
                                int third = 0;
                                while (third < blocks.get(first).getBases().size()) {
                                    if (theChunk.getBlockState(x, y, z) == blocks.get(first).getBases().get(third).fromBlockstate) {
                                        theChunk.setBlockState(new BlockPos(x, y, z), blocks.get(first).getBases().get(third).toBlockstate);
                                    }
                                    third++;
                                }
                                break;
                            }
                            second++;

                        }
                        first++;
                    }

                }
            }
        }
        theChunk.markDirty();
    }

}
