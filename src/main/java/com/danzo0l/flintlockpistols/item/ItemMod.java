package com.danzo0l.flintlockpistols.item;

import com.danzo0l.flintlockpistols.FlintlockPistolMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemMod {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FlintlockPistolMod.MODID);

    public static final RegistryObject<Item> FLINTLOCK_PISTOL = ITEMS.register("flintlock_pistol",
            () -> new FlintlockPistolItem(new Item.Properties().stacksTo(1).defaultDurability(628))
    );

    public static final RegistryObject<Item> PISTOL_BULLET = ITEMS.register("pistol_bullet",
            () -> new PistolBulletItem(new Item.Properties())
    );
}
