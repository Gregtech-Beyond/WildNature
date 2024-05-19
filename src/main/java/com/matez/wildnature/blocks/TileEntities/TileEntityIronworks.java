package com.matez.wildnature.blocks.TileEntities;

import com.matez.wildnature.blocks.BlockIronworks;
import com.matez.wildnature.blocks.recipes.IronworksRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityIronworks extends TileEntity implements ITickable
{
    public ItemStackHandler handler = new ItemStackHandler(7);
    private String customName;
    private ItemStack smelting = ItemStack.EMPTY;
    private ItemStack smeltingTrash = ItemStack.EMPTY;

    private int burnTime;
    private int currentBurnTime;
    private int cookTime;
    private int totalCookTime = 400;




    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        else return false;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.handler;
        return super.getCapability(capability, facing);
    }

    public String getName()
    {
        return this.hasCustomName() ? this.customName : "container.ironworks";
    }

    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName()
    {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomInventoryName(String p_145951_1_)
    {
        this.customName = p_145951_1_;
    }
    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return this.hasCustomName() ? new TextComponentString(this.customName) : new TextComponentTranslation("container.ironworks");
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
        this.burnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentBurnTime = getItemBurnTime((ItemStack)this.handler.getStackInSlot(2));

        if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short)this.burnTime);
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
        compound.setTag("Inventory", this.handler.serializeNBT());

        if(this.hasCustomName()) compound.setString("CustomName", this.customName);
        return compound;
    }

    public boolean isBurning()
    {
        return this.burnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(TileEntityIronworks te)
    {
        return te.getField(0) > 0;
    }

    /*public void update()
    {
        if(this.isBurning())
        {
            --this.burnTime;
            BlockIronworks.setState(true, world, pos);
        }

        ItemStack[] inputs = new ItemStack[] {handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2), handler.getStackInSlot(3)};
        ItemStack fuel = this.handler.getStackInSlot(4);

        if(this.isBurning() || !fuel.isEmpty() && (!this.handler.getStackInSlot(0).isEmpty() || this.handler.getStackInSlot(1).isEmpty()|| this.handler.getStackInSlot(2).isEmpty()|| this.handler.getStackInSlot(3).isEmpty()))
        {
            if(!this.isBurning() && this.canSmelt())
            {
                this.burnTime = getItemBurnTime(fuel);
                this.currentBurnTime = burnTime;

                if(this.isBurning() && !fuel.isEmpty())
                {
                    Item item = fuel.getItem();
                    fuel.shrink(1);

                    if(fuel.isEmpty())
                    {
                        ItemStack item1 = item.getContainerItem(fuel);
                        this.handler.setStackInSlot(4, item1);
                    }
                }
            }
        }

        if(this.isBurning() && this.canSmelt() && cookTime > 0)
        {
            cookTime++;
            if(cookTime == totalCookTime)
            {
                if(handler.getStackInSlot(5).getCount() > 0)
                {
                    handler.getStackInSlot(5).grow(1);
                }
                else
                {
                    handler.insertItem(5, smeltingTrash, false);
                }

                if(handler.getStackInSlot(6).getCount() > 0)
                {
                    handler.getStackInSlot(6).grow(1);
                }
                else
                {
                    handler.insertItem(6, smelting, false);
                }

                smelting = ItemStack.EMPTY;
                smeltingTrash = ItemStack.EMPTY;
                cookTime = 0;
                return;
            }
        }
        else
        {
            if(this.canSmelt() && this.isBurning())
            {
                ItemStack output = IronworksRecipes.getInstance().getIronworksResult(inputs[0], inputs[1], inputs[2], inputs[3]);
                ItemStack trashOutput = IronworksRecipes.getInstance().getIronworksResultTrash(inputs[0], inputs[1], inputs[2], inputs[3]);
                if(!output.isEmpty())
                {
                    smelting = output;
                    smeltingTrash = trashOutput;
                    cookTime++;
                    inputs[0].shrink(1);
                    inputs[1].shrink(1);
                    inputs[2].shrink(1);
                    inputs[3].shrink(1);
                    handler.setStackInSlot(0, inputs[0]);
                    handler.setStackInSlot(1, inputs[1]);
                    handler.setStackInSlot(2, inputs[2]);
                    handler.setStackInSlot(3, inputs[3]);
                }
            }
        }
    }*/

    public void update()
    {

        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning())
        {
            --this.burnTime;
        }

        if (!this.world.isRemote)
        {
            ItemStack fuel = this.handler.getStackInSlot(4);

            if (this.isBurning() || !fuel.isEmpty() && (!this.handler.getStackInSlot(0).isEmpty() || !this.handler.getStackInSlot(1).isEmpty() || !this.handler.getStackInSlot(2).isEmpty() || !this.handler.getStackInSlot(3).isEmpty()))
            {
                if (!this.isBurning() && this.canSmelt())
                {
                    this.burnTime = getItemBurnTime(fuel);
                    this.currentBurnTime = this.burnTime;

                    if (this.isBurning())
                    {
                        flag1 = true;

                        if (!fuel.isEmpty())
                        {
                            Item item = fuel.getItem();
                            fuel.shrink(1);

                            if (fuel.isEmpty())
                            {
                                ItemStack item1 = item.getContainerItem(fuel);
                                this.handler.setStackInSlot(4, item1);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = 400;
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.cookTime = 0;
                }
            }
            else if (!this.isBurning() && this.cookTime > 0)
            {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }

            if (flag != this.isBurning())
            {
                flag1 = true;
                BlockIronworks.setState(this.isBurning(), this.world, this.pos);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    private void smeltItem(){
        if(canSmelt()) {
            ItemStack[] inputs = new ItemStack[]{handler.getStackInSlot(0), handler.getStackInSlot(1), handler.getStackInSlot(2), handler.getStackInSlot(3)};
            ItemStack output = IronworksRecipes.getIronworksResult(inputs[0], inputs[1], inputs[2], inputs[3]);
            ItemStack trashOutput = IronworksRecipes.getIronworksResultTrash(inputs[0], inputs[1], inputs[2], inputs[3]);
            if (handler.getStackInSlot(5).getCount() > 0 && !handler.getStackInSlot(5).isEmpty()) {
                handler.getStackInSlot(5).grow(1);
            } else {
                handler.setStackInSlot(5, trashOutput);
            }

            if (handler.getStackInSlot(6).getCount() > 0 && !handler.getStackInSlot(6).isEmpty()) {
                handler.getStackInSlot(6).grow(1);
            } else {
                handler.setStackInSlot(6, output);
            }

            inputs[0].shrink(1);
            inputs[1].shrink(1);
            inputs[2].shrink(1);
            inputs[3].shrink(1);
            handler.setStackInSlot(0, inputs[0]);
            handler.setStackInSlot(1, inputs[1]);
            handler.setStackInSlot(2, inputs[2]);
            handler.setStackInSlot(3, inputs[3]);
        }

    }

    private boolean canSmelt()
    {
        if(((ItemStack)this.handler.getStackInSlot(0)).isEmpty() || ((ItemStack)this.handler.getStackInSlot(1)).isEmpty()|| ((ItemStack)this.handler.getStackInSlot(2)).isEmpty()|| ((ItemStack)this.handler.getStackInSlot(3)).isEmpty()) return false;
        else
        {
            ItemStack result = IronworksRecipes.getIronworksResult((ItemStack)this.handler.getStackInSlot(0), (ItemStack)this.handler.getStackInSlot(1), (ItemStack)this.handler.getStackInSlot(2), (ItemStack)this.handler.getStackInSlot(3));
            ItemStack resultTrash = IronworksRecipes.getIronworksResultTrash((ItemStack)this.handler.getStackInSlot(0), (ItemStack)this.handler.getStackInSlot(1), (ItemStack)this.handler.getStackInSlot(2), (ItemStack)this.handler.getStackInSlot(3));
            boolean boolResult = false, boolTrash = false;

            {
                if(result.isEmpty()){
                    boolResult=false;
                }else {
                    ItemStack output = (ItemStack) this.handler.getStackInSlot(6);
                    if (output.isEmpty()) {
                        boolResult=true;
                    }
                    else if (!output.isItemEqual(result)){ boolResult=false;}
                    else {
                        int res = output.getCount() + result.getCount();
                        boolResult = res <= 64 && res <= output.getMaxStackSize();
                    }
                }

                if(resultTrash.isEmpty()){
                    boolTrash=true;
                }else{
                    ItemStack output = (ItemStack)this.handler.getStackInSlot(5);
                    if(output.isEmpty()) boolTrash=true;
                    else if(!output.isItemEqual(resultTrash)) boolTrash=false;
                    else {
                        int res = output.getCount() + resultTrash.getCount();
                        boolTrash = res <= 64 && res <= output.getMaxStackSize();
                    }
                }

                return boolTrash && boolResult;

            }
        }
    }

    public static int getItemBurnTime(ItemStack fuel)
    {
        if(fuel.isEmpty()) return 0;
        else
        {
            Item item = fuel.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.WOODEN_SLAB) return 150;
                if (block.getDefaultState().getMaterial() == Material.WOOD) return 300;
                if (block == Blocks.COAL_BLOCK) return 16000;
            }

            if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
            if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
            if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 200;
            if (item == Items.STICK) return 100;
            if (item == Items.COAL) return 1600;
            if (item == Items.LAVA_BUCKET) return 20000;
            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
            if (item == Items.BLAZE_ROD) return 2400;

            return GameRegistry.getFuelValue(fuel);
        }
    }

    public static boolean isItemFuel(ItemStack fuel)
    {
        return getItemBurnTime(fuel) > 0;
    }

    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }



    public int getField(int id)
    {
        switch(id)
        {
            case 0:
                return this.burnTime;
            case 1:
                return this.currentBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch(id)
        {
            case 0:
                this.burnTime = value;
                break;
            case 1:
                this.currentBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.isItemValidForSlot(index, itemStackIn);
    }


    private boolean isItemValidForSlot(int index, ItemStack stack){
        if(index==5||index==6){
            return false;
        }
        return true;

    }


}
