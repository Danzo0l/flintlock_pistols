package com.danzo0l.flintlockpistols.entity.bullet;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class AbstractBullet extends AbstractArrow {
    private static final double BULLET_BASE_DAMAGE = 2.0D;
    private static final EntityDataAccessor<Byte> ID_FLAGS = SynchedEntityData.defineId(AbstractBullet.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Byte> PIERCE_LEVEL = SynchedEntityData.defineId(AbstractBullet.class, EntityDataSerializers.BYTE);
    @Nullable
    protected boolean inGround;
    protected int inGroundTime;
    public AbstractBullet.Pickup pickup = AbstractBullet.Pickup.DISALLOWED;
    private int life;
    private double baseDamage = BULLET_BASE_DAMAGE;
    private int knockback;
    private AbstractArrow abstractArrow;
    private SoundEvent soundEvent = this.getDefaultHitGroundSoundEvent();
    @Nullable
    private IntOpenHashSet piercingIgnoreEntityIds;
    @Nullable
    private List<Entity> piercedAndKilledEntities;

    private final IntOpenHashSet ignoredEntities = new IntOpenHashSet();

    protected AbstractBullet(EntityType<? extends AbstractArrow> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);
    }

    protected AbstractBullet(EntityType<? extends AbstractArrow> p_36711_, double p_36712_, double p_36713_, double p_36714_, Level p_36715_) {
        this(p_36711_, p_36715_);
        this.setPos(p_36712_, p_36713_, p_36714_);
    }

    protected AbstractBullet(EntityType<? extends AbstractArrow> p_36717_, LivingEntity p_36718_, Level p_36719_) {
        this(p_36717_, p_36718_.getX(), p_36718_.getEyeY() - (double)0.1F, p_36718_.getZ(), p_36719_);
        this.setOwner(p_36718_);
        if (p_36718_ instanceof Player) {
            this.pickup = AbstractBullet.Pickup.ALLOWED;
        }

    }

    public void setSoundEvent(SoundEvent p_36741_) {
        this.soundEvent = p_36741_;
    }

    public boolean shouldRenderAtSqrDistance(double p_36726_) {
        double d0 = this.getBoundingBox().getSize() * 10.0D;
        if (Double.isNaN(d0)) {
            d0 = 1.0D;
        }

        d0 *= 64.0D * getViewScale();
        return p_36726_ < d0 * d0;
    }

    protected void defineSynchedData() {
        this.entityData.define(ID_FLAGS, (byte)0);
        this.entityData.define(PIERCE_LEVEL, (byte)0);
    }

    public void shoot(double p_36775_, double p_36776_, double p_36777_, float p_36778_, float p_36779_) {
        super.shoot(p_36775_, p_36776_, p_36777_, p_36778_, p_36779_);
        this.life = 0;
    }

    public void lerpTo(double p_36728_, double p_36729_, double p_36730_, float p_36731_, float p_36732_, int p_36733_, boolean p_36734_) {
        this.setPos(p_36728_, p_36729_, p_36730_);
        this.setRot(p_36731_, p_36732_);
    }

    public void lerpMotion(double p_36786_, double p_36787_, double p_36788_) {
        super.lerpMotion(p_36786_, p_36787_, p_36788_);
        this.life = 0;
    }
}
