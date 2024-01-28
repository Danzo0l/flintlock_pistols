package com.danzo0l.flintlockpistols.tab;

import com.danzo0l.flintlockpistols.FlintlockPistolMod;
import com.danzo0l.flintlockpistols.item.ItemMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

@Mod.EventBusSubscriber(modid = FlintlockPistolMod.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabMod {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, FlintlockPistolMod.MODID
    );

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(CreativeModeTabs.COMBAT)) {
            event.accept(ItemMod.FLINTLOCK_PISTOL);
            event.getEntries().putAfter(
                    Items.CROSSBOW.getDefaultInstance(),
                    ItemMod.FLINTLOCK_PISTOL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.getEntries().putAfter(
                    ItemMod.FLINTLOCK_PISTOL.get().getDefaultInstance(),
                    ItemMod.PISTOL_BULLET.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }
    }
}
