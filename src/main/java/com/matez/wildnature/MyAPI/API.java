package com.matez.wildnature.MyAPI;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Arrays;

import java.util.ArrayList;

public class API {

    public static ArrayList<BlockPos> mappedBlockPos = new ArrayList<>();
    public static ArrayList<BlockPos> mapBlocks(BlockPos startPos, World world, Block... blocks){
        ArrayList<BlockPos> blockMap = new ArrayList<>();
        ArrayList<Block> mappingBlocks = new ArrayList<>(Arrays.asList(blocks));
        blockMap.add(startPos);
        mapBlock(startPos,blockMap,mappingBlocks, world);

        return mappedBlockPos;
    }

    private static void mapBlock(BlockPos pos, ArrayList<BlockPos> blockMap , ArrayList<Block> mappingBlocks, World world){
        if(mappingBlocks.contains(world.getBlockState(pos.north()).getBlock())){
            BlockPos thisPos = pos.north();
            if(!blockMap.contains(thisPos)){
                blockMap.add(thisPos);
                mapBlock(thisPos,blockMap,mappingBlocks, world);
            }
        }
        if(mappingBlocks.contains(world.getBlockState(pos.west()).getBlock())){
            BlockPos thisPos = pos.west();
            if(!blockMap.contains(thisPos)){
                blockMap.add(thisPos);
                mapBlock(thisPos,blockMap,mappingBlocks, world);
            }
        }
        if(mappingBlocks.contains(world.getBlockState(pos.east()).getBlock())){
            BlockPos thisPos = pos.east();
            if(!blockMap.contains(thisPos)){
                blockMap.add(thisPos);
                mapBlock(thisPos,blockMap,mappingBlocks, world);
            }
        }
        if(mappingBlocks.contains(world.getBlockState(pos.south()).getBlock())){
            BlockPos thisPos = pos.south();
            if(!blockMap.contains(thisPos)){
                blockMap.add(thisPos);
                mapBlock(thisPos,blockMap,mappingBlocks, world);
            }
        }
        if(mappingBlocks.contains(world.getBlockState(pos.up()).getBlock())){
            BlockPos thisPos = pos.up();
            if(!blockMap.contains(thisPos)){
                blockMap.add(thisPos);
                mapBlock(thisPos,blockMap,mappingBlocks, world);
            }
        }
        if(mappingBlocks.contains(world.getBlockState(pos.down()).getBlock())){
            BlockPos thisPos = pos.down();
            if(!blockMap.contains(thisPos)){
                blockMap.add(thisPos);
                mapBlock(thisPos,blockMap,mappingBlocks, world);
            }
        }

        mappedBlockPos = blockMap;
    }
}