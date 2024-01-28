package com.danzo0l.flintlockpistols.entity;

import com.danzo0l.flintlockpistols.FlintlockPistolMod;
import com.danzo0l.flintlockpistols.entity.bullet.PistolBulletEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityMod {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FlintlockPistolMod.MODID);

    public static final RegistryObject<EntityType<PistolBulletEntity>> PISTOL_BULLET = ENTITY_TYPES.register("explosive_arrow",
            () -> EntityType.Builder.of((EntityType.EntityFactory<PistolBulletEntity>) PistolBulletEntity::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).build("pistol_bullet"));
}