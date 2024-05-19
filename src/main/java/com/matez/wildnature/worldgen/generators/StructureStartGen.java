package com.matez.wildnature.worldgen.generators;

import com.google.common.collect.Lists;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

import java.util.List;

public class StructureStartGen extends StructureStart {
    protected List<StructureComponentGen> components = Lists.<StructureComponentGen>newLinkedList();
}
