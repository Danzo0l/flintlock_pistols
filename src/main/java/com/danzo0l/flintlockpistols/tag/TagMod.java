package com.danzo0l.flintlockpistols.tag;


import com.danzo0l.flintlockpistols.FlintlockPistolMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagMod {
    public static class Items {

        public static final TagKey<Item> BULLETS = createForgeTag("items/bullet");
        public static final TagKey<Item> PISTOLS = createForgeTag("items/flintlock_pistol");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(new ResourceLocation(FlintlockPistolMod.MODID, name));
        }

        private static TagKey<Item> createForgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
