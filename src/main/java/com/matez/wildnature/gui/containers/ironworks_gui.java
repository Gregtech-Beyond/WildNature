package com.matez.wildnature.gui.containers;

import com.matez.wildnature.blocks.TileEntities.TileEntityIronworks;
import com.matez.wildnature.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class ironworks_gui extends GuiContainer
{
    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/ironworks.png");
    private final InventoryPlayer player;
    private final TileEntityIronworks tileentity;

    public ironworks_gui(InventoryPlayer player, TileEntityIronworks tileentity)
    {
        super(new ironworks_container(player, tileentity));
        this.ySize=182;
        this.player = player;
        this.tileentity = tileentity;

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String tileName = this.tileentity.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) + 3, 8, 4210752);
        this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
    }

    int abc = 0, abcd = 0;

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if(TileEntityIronworks.isBurning(tileentity))
        {
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(this.guiLeft + 50, this.guiTop + 60 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.getCookProgressScaled(38);
        this.drawTexturedModalRect(this.guiLeft + 74, this.guiTop + 34, 176, 14, l + 1, 10);

        if(l == 19){
            abc = this.tileentity.getField(2);
            abcd = this.tileentity.getField(3);
        }
        if(l>=19) {
            int m = this.getCookHalfProgressScaled(12,abc,abcd);
            this.drawTexturedModalRect(this.guiLeft + 74, this.guiTop + 44, 176, 24, 38, m + 1);
        }
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = this.tileentity.getField(1);
        if(i == 0) i = 200;
        return this.tileentity.getField(0) * pixels / i;
    }

    private int getCookProgressScaled(int pixels)
    {
        int i = this.tileentity.getField(2);
        int j = this.tileentity.getField(3);
        if(j==0){
            return 0;
        }
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
    private int getCookHalfProgressScaled(int pixels, int ix, int jx)
    {
        int i = this.tileentity.getField(2);
        int j = this.tileentity.getField(3);
        if(j==0){
            return 0;
        }
        return j != 0 && i != 0 ? (i * pixels / j) : 0;
    }

}
