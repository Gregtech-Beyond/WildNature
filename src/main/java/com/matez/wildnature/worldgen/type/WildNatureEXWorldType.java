package com.matez.wildnature.worldgen.type;

import com.matez.wildnature.worldgen.generators.Chunk.ChunkGeneratorWildNature2;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.layer.GenLayer;

public class WildNatureEXWorldType extends WorldType {
    /**
     * Creates a new world type, the ID is hidden and should not be referenced by modders.
     * It will automatically expand the underlying workdType array if there are no IDs left.
     *
     * @param name
     */
    public WildNatureEXWorldType(String name) {
        super(name);
    }

    @Override
    public boolean isCustomizable() {
        return false;
    }

    @Override
    public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkGeneratorSettings chunkSettings) {
        return super.getBiomeLayer(worldSeed, parentLayer, chunkSettings);
    }

    @Override
    public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {

        return new ChunkGeneratorWildNature2(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
    }
}