package com.danzo0l.flintlockpistols.item;

import com.danzo0l.flintlockpistols.entity.bullet.AbstractBullet;
import com.danzo0l.flintlockpistols.entity.bullet.PistolBulletEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PistolBulletItem extends Item {
    public PistolBulletItem(Item.Properties p_40512_) {
        super(p_40512_);
    }

    public AbstractBullet createArrow(Level p_40513_, ItemStack p_40514_, LivingEntity p_40515_) {
        return new PistolBulletEntity(p_40513_, p_40515_);
    }
}
