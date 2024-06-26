package com.matez.wildnature.gui.containers;

import com.matez.wildnature.blocks.TileEntities.TileEntityIronworks;
import com.matez.wildnature.blocks.recipes.IronworksRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import static com.matez.wildnature.blocks.TileEntities.TileEntityIronworks.getItemBurnTime;

public class ironworks_container extends Container
{
    private final TileEntityIronworks tileentity;
    private int cookTime, totalCookTime, burnTime, currentBurnTime;

    public ironworks_container(InventoryPlayer player, TileEntityIronworks tileentity)
    {
        this.tileentity = tileentity;
        IItemHandler handler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        this.addSlotToContainer(new SlotItemHandler(handler, 0, 39, 23));//#___
        this.addSlotToContainer(new SlotItemHandler(handler, 1, 57, 23));//_#__
        this.addSlotToContainer(new SlotItemHandler(handler, 2, 39, 41));//__#_
        this.addSlotToContainer(new SlotItemHandler(handler, 3, 57, 41));//___#

        this.addSlotToContainer(new SlotItemHandler(handler, 4, 48, 76));//coal
        this.addSlotToContainer(new SlotItemHandler(handler, 5, 85, 57));//resultTrash
        this.addSlotToContainer(new SlotItemHandler(handler, 6, 113, 32));//result


        for(int y = 0; y < 3; y++)
        {
            for(int x = 0; x < 9; x++)
            {
                this.addSlotToContainer(new Slot(player, x + y*9 + 9, 8 + x*18, 100 + y*18));
            }
        }

        for(int x = 0; x < 9; x++)
        {
            this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 158));
        }
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for(int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener listener = (IContainerListener)this.listeners.get(i);

            if(this.cookTime != this.tileentity.getField(2)) listener.sendWindowProperty(this, 2, this.tileentity.getField(2));
            if(this.burnTime != this.tileentity.getField(0)) listener.sendWindowProperty(this, 0, this.tileentity.getField(0));
            if(this.currentBurnTime != this.tileentity.getField(1)) listener.sendWindowProperty(this, 1, this.tileentity.getField(1));
            if(this.totalCookTime != this.tileentity.getField(3)) listener.sendWindowProperty(this, 3, this.tileentity.getField(3));
            tileentity.update();
        }

        this.cookTime = this.tileentity.getField(2);
        this.burnTime = this.tileentity.getField(0);
        this.currentBurnTime = this.tileentity.getField(1);
        this.totalCookTime = this.tileentity.getField(3);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.tileentity.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.tileentity.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        System.out.println("TRANSFER " + index);
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);

        /*if(slot != null && slot.getHasStack())
        {
            ItemStack stack1 = slot.getStack();
            stack = stack1.copy();

            if(index == 3)
            {
                if(!this.mergeItemStack(stack1, 4, 40, true)) return ItemStack.EMPTY;
                slot.onSlotChange(stack1, stack);
            }
            else if(index != 2 && index != 1 && index != 0)
            {
                Slot slot1 = (Slot)this.inventorySlots.get(index + 1);
                Slot slot2 = (Slot)this.inventorySlots.get(index + 2);
                Slot slot3 = (Slot)this.inventorySlots.get(index + 3);
                Slot slot4 = (Slot)this.inventorySlots.get(index + 4);

                if(!IronworksRecipes.getIronworksResult(stack1, slot1.getStack(),slot2.getStack(),slot3.getStack()).isEmpty())
                {
                    if(!this.mergeItemStack(stack1, 0, 2, false))
                    {
                        return ItemStack.EMPTY;
                    }
                    else if(TileEntityIronworks.isItemFuel(stack1))
                    {
                        if(!this.mergeItemStack(stack1, 2, 3, false)) return ItemStack.EMPTY;
                    }
                    else if(TileEntityIronworks.isItemFuel(stack1))
                    {
                        if(!this.mergeItemStack(stack1, 2, 3, false)) return ItemStack.EMPTY;
                    }
                    else if(TileEntityIronworks.isItemFuel(stack1))
                    {
                        if(!this.mergeItemStack(stack1, 2, 3, false)) return ItemStack.EMPTY;
                    }
                    else if(index >= 7 && index < 34)
                    {
                        if(!this.mergeItemStack(stack1, 31, 40, false)) return ItemStack.EMPTY;
                    }
                    else if(index >= 34 && index < 43 && !this.mergeItemStack(stack1, 4, 31, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
            }
            else if(!this.mergeItemStack(stack1, 7, 43, false))
            {
                return ItemStack.EMPTY;
            }
            if(stack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();

            }
            if(stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
            slot.onTake(playerIn, stack1);
        }*/
        return stack;
    }



}