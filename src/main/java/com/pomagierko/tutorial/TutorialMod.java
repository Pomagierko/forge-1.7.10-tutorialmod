package com.pomagierko.tutorial;

import com.pomagierko.tutorial.item.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = "tm", name = "TutorialMod", version = "1.0")
public class TutorialMod {

    public static Item itemTable;
    public static Item itemCheese;
    public static Block blockTable;
    public static Block rubyOre;

    public static Item cheesePickaxe;
    public static Item cheeseAxe;
    public static Item cheeseShovel;
    public static Item cheeseHoe;
    public static Item cheeseSword;

    public static final Item.ToolMaterial cheeseToolMaterial = EnumHelper.addToolMaterial("cheeseToolMaterial",
            4, 9999, 12.0f, 999.0f, 30);



    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //Item/Block init and registering
        //Config handling
        itemTable = new ItemTable().setUnlocalizedName("ItemTable").setTextureName("tm:itemtable").setCreativeTab(tabTutorialMod);
        itemCheese = new ItemFood(6, 3.0F, false).setUnlocalizedName("ItemCheese").setTextureName("tm:itemcheese").setCreativeTab(tabTutorialMod);

        blockTable = new BlockTable(Material.wood).setBlockName("BlockTable").setBlockTextureName("tm:blocktable").setCreativeTab(tabTutorialMod);
        rubyOre = new RubyOre(Material.rock).setBlockName("RubyOre").setBlockTextureName("tm:rubyore").setCreativeTab(tabTutorialMod);

        cheesePickaxe = new ItemCheesePickaxe(cheeseToolMaterial).setUnlocalizedName("CheesePickaxe").setTextureName("tm:itemcheesepickaxe").setCreativeTab(tabTutorialMod);
        cheeseAxe = new ItemCheeseAxe(cheeseToolMaterial).setUnlocalizedName("CheeseAxe").setTextureName("tm:itemcheeseaxe").setCreativeTab(tabTutorialMod);
        cheeseShovel = new ItemCheeseShovel(cheeseToolMaterial).setUnlocalizedName("CheeseShovel").setTextureName("tm:itemcheeseshovel").setCreativeTab(tabTutorialMod);
        cheeseHoe = new ItemCheeseHoe(cheeseToolMaterial).setUnlocalizedName("CheeseHoe").setTextureName("tm:itemcheesehoe").setCreativeTab(tabTutorialMod);
        cheeseSword = new ItemCheeseSword(cheeseToolMaterial).setUnlocalizedName("CheeseSword").setTextureName("tm:itemcheesesword").setCreativeTab(tabTutorialMod);

        GameRegistry.registerItem(cheesePickaxe, cheesePickaxe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(cheeseAxe, cheeseAxe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(cheeseShovel, cheeseShovel.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(cheeseHoe, cheeseHoe.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(cheeseSword, cheeseSword.getUnlocalizedName().substring(5));

        GameRegistry.registerItem(itemTable, itemTable.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(itemCheese, itemCheese.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockTable, blockTable.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(rubyOre, rubyOre.getUnlocalizedName().substring(5));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //Proxy, TileEntity, entity, GUI and Packet Registering
        GameRegistry.addRecipe(new ItemStack(itemTable, 2), new Object[]{"###","# #","# #", '#', Blocks.planks});
        GameRegistry.addRecipe(new ItemStack(blockTable), new Object[]{"###","#R#","# #", '#', Blocks.planks, 'R', Blocks.redstone_block});
        GameRegistry.addSmelting(Items.milk_bucket, new ItemStack(itemCheese), 3.0f);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    public static CreativeTabs tabTutorialMod = new CreativeTabs("tabTutorialMod") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(itemCheese).getItem();
        }
    };
}
