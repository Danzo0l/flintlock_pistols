package com.danzo0l.flintlockpistols;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.danzo0l.flintlockpistols.tab.CreativeTabMod.TABS;
import static com.danzo0l.flintlockpistols.entity.EntityMod.ENTITY_TYPES;
import static com.danzo0l.flintlockpistols.item.ItemMod.ITEMS;
import static com.danzo0l.flintlockpistols.sound.SoundMod.SOUND_EVENTS;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FlintlockPistolMod.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class FlintlockPistolMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "flintlock_pistols";

    public FlintlockPistolMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        TABS.register(bus);
        SOUND_EVENTS.register(bus);
        ENTITY_TYPES.register(bus);
    }
}
