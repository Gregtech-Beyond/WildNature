package com.matez.wildnature.util.handlers;

import com.matez.wildnature.entity.*;
import com.matez.wildnature.entity.render.*;
import com.matez.wildnature.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RenderHandler {


    public static void registerEntityRenders(){

        RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new IRenderFactory<EntityBoar>() {
            @Override
            public Render<? super EntityBoar> createRenderFor(RenderManager manager) {

                return new RenderBoar(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityDuckMale.class, new IRenderFactory<EntityDuckMale>() {
            @Override
            public Render<? super EntityDuckMale> createRenderFor(RenderManager manager) {
                return new RenderDuckMale(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityDuckFemale.class, new IRenderFactory<EntityDuckFemale>() {
            @Override
            public Render<? super EntityDuckFemale> createRenderFor(RenderManager manager) {
                return new RenderDuckFemale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityDuckChild.class, new IRenderFactory<EntityDuckChild>() {
            @Override
            public Render<? super EntityDuckChild> createRenderFor(RenderManager manager) {
                return new RenderDuckBaby(manager);
            }
        });


        RenderingRegistry.registerEntityRenderingHandler(EntityGoatMale.class, new IRenderFactory<EntityGoatMale>() {
            @Override
            public Render<? super EntityGoatMale> createRenderFor(RenderManager manager) {
                return new RenderGoatMale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityGoatFemale.class, new IRenderFactory<EntityGoatFemale>() {
            @Override
            public Render<? super EntityGoatFemale> createRenderFor(RenderManager manager) {
                return new RenderGoatFemale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityGoatChild.class, new IRenderFactory<EntityGoatChild>() {
            @Override
            public Render<? super EntityGoatChild> createRenderFor(RenderManager manager) {
                return new RenderGoatBaby(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityGoatSaanenMale.class, new IRenderFactory<EntityGoatSaanenMale>() {
            @Override
            public Render<? super EntityGoatSaanenMale> createRenderFor(RenderManager manager) {
                return new RenderGoatSaanenMale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityGoatSaanenFemale.class, new IRenderFactory<EntityGoatSaanenFemale>() {
            @Override
            public Render<? super EntityGoatSaanenFemale> createRenderFor(RenderManager manager) {
                return new RenderGoatSaanenFemale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityGoatSaanenChild.class, new IRenderFactory<EntityGoatSaanenChild>() {
            @Override
            public Render<? super EntityGoatSaanenChild> createRenderFor(RenderManager manager) {
                return new RenderGoatSaanenBaby(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCamelMale.class, new IRenderFactory<EntityCamelMale>() {
            @Override
            public Render<? super EntityCamelMale> createRenderFor(RenderManager manager) {
                return new RenderCamelMale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCamelFemale.class, new IRenderFactory<EntityCamelFemale>() {
            @Override
            public Render<? super EntityCamelFemale> createRenderFor(RenderManager manager) {
                return new RenderCamelFemale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCamelChild.class, new IRenderFactory<EntityCamelChild>() {
            @Override
            public Render<? super EntityCamelChild> createRenderFor(RenderManager manager) {
                return new RenderCamelBaby(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityBisonMale.class, new IRenderFactory<EntityBisonMale>() {
            @Override
            public Render<? super EntityBisonMale> createRenderFor(RenderManager manager) {
                return new RenderBisonMale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityBisonFemale.class, new IRenderFactory<EntityBisonFemale>() {
            @Override
            public Render<? super EntityBisonFemale> createRenderFor(RenderManager manager) {
                return new RenderBisonFemale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityBisonChild.class, new IRenderFactory<EntityBisonChild>() {
            @Override
            public Render<? super EntityBisonChild> createRenderFor(RenderManager manager) {
                return new RenderBisonBaby(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCowMale.class, new IRenderFactory<EntityCowMale>() {
            @Override
            public Render<? super EntityCowMale> createRenderFor(RenderManager manager) {
                return new RenderCowMale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCowFemale.class, new IRenderFactory<EntityCowFemale>() {
            @Override
            public Render<? super EntityCowFemale> createRenderFor(RenderManager manager) {
                return new RenderCowFemale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityCowChild.class, new IRenderFactory<EntityCowChild>() {
            @Override
            public Render<? super EntityCowChild> createRenderFor(RenderManager manager) {
                return new RenderCowBaby(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityWisentMale.class, new IRenderFactory<EntityWisentMale>() {
            @Override
            public Render<? super EntityWisentMale> createRenderFor(RenderManager manager) {
                return new RenderWisentMale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityWisentFemale.class, new IRenderFactory<EntityWisentFemale>() {
            @Override
            public Render<? super EntityWisentFemale> createRenderFor(RenderManager manager) {
                return new RenderWisentFemale(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityWisentChild.class, new IRenderFactory<EntityWisentChild>() {
            @Override
            public Render<? super EntityWisentChild> createRenderFor(RenderManager manager) {
                return new RenderWisentBaby(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityForester.class, new IRenderFactory<EntityForester>() {
            @Override
            public Render<? super EntityForester> createRenderFor(RenderManager manager) {
                return new RenderCustomPlayer(manager);
            }
        });
    }



    public static void registerCustomMeshesAndStates(){
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.NEW_WATER), new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return new ModelResourceLocation("wildnature:mb_water","fluid");
            }
        });

        ModelLoader.setCustomStateMapper(ModBlocks.NEW_WATER, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return new ModelResourceLocation("wildnature:mb_water","fluid");
            }
        });
    }
}