package com.pomagierko.tutorial;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

@Mod(modid = "tm", name = "TutorialMod", version = "1.0")
public class TutorialMod {

    public static Item itemTable;
    public static Block blockTable;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //Item/Block init and registering
        //Config handling
        itemTable = new ItemTable().setUnlocalizedName("ItemTable").setTextureName("tm:itemtable");

        blockTable = new BlockTable(Material.wood).setBlockName("BlockTable").setBlockTextureName("tm:blocktable");



        GameRegistry.registerItem(itemTable, itemTable.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockTable, blockTable.getUnlocalizedName().substring(5));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //Proxy, TileEntity, entity, GUI and Packet Registering

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
