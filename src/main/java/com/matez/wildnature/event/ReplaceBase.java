package com.matez.wildnature.event;

import net.minecraft.block.state.IBlockState;

public class ReplaceBase {
    public IBlockState fromBlockstate, toBlockstate;
    public ReplaceBase(IBlockState fromBlockstate, IBlockState toBlockstate){
        this.fromBlockstate=fromBlockstate;
        this.toBlockstate=toBlockstate;
    }

    public IBlockState getFromBlockstate() {
        return fromBlockstate;
    }

    public IBlockState getToBlockstate() {
        return toBlockstate;
    }
}
