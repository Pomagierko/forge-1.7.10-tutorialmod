package com.pomagierko.tutorial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RubyOre extends Block {
    public RubyOre(Material material) {
        super(material);
        this.setResistance(2000.0f);
        this.setHardness(2.0f);
        this.setHarvestLevel("pickaxe", 4);
        this.setLightLevel(0.5f);
        this.setStepSound(soundTypeStone);
        this.canProvidePower();
    }


}
