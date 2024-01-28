package com.danzo0l.flintlockpistols.sound;

import com.danzo0l.flintlockpistols.FlintlockPistolMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundMod {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FlintlockPistolMod.MODID);

    public static final RegistryObject<SoundEvent> PISTOL_SHOOT_SOUND = registrySoundEvent("pistol_shoot");
    public static final RegistryObject<SoundEvent> PISTOL_RELOAD_SOUND = registrySoundEvent("pistol_reload");
    public static final RegistryObject<SoundEvent> PISTOL_RELOAD_0_SOUND = registrySoundEvent("pistol_reload_0");
    public static final RegistryObject<SoundEvent> PISTOL_RELOAD_1_SOUND = registrySoundEvent("pistol_reload_1");
    public static final RegistryObject<SoundEvent> BULLET_SOUND = registrySoundEvent("bullet");

    private static RegistryObject<SoundEvent> registrySoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(FlintlockPistolMod.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}


