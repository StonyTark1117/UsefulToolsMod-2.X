package com.stonytark.usefultoolsmod.entity.custom;

import com.stonytark.usefultoolsmod.entity.ModEntities;
import com.stonytark.usefultoolsmod.entity.ai.goal.FollowPlayerGoal;
import com.stonytark.usefultoolsmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class GhostEntity extends Animal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private int lifetime = 0; // ticks since spawn
    private static final int MAX_LIFETIME = 5 * 60 * 20; // 5 minutes


    public GhostEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level);
        this.moveControl = new FlyingMoveControl(this, 10, true);
        this.setNoGravity(true);
        this.noPhysics = true; // pass through blocks
    }

    /* ---------------- AI ---------------- */

    @Override
    protected void registerGoals() {
        // Wander a bit in the air
        this.goalSelector.addGoal(0, new RandomStrollGoal(this, 1.0D, 40));

        // Look at nearby players
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));

        // Occasionally look around
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));

        // Follow players when visible
        this.goalSelector.addGoal(3, new FollowPlayerGoal(this, 1.3D, 8.0F, 2.0F));
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation nav = new FlyingPathNavigation(this, level);
        nav.setCanFloat(true);
        nav.setCanPassDoors(true);
        return nav;
    }

    /* --------------- Attributes --------------- */

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.FLYING_SPEED, 0.6D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    /* --------------- Immunities / Physics --------------- */

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide) {
            this.clearFire();               // never burn
        }

        // Gentle hovering drift
        if (this.random.nextFloat() < 0.02F) {
            this.setDeltaMovement(this.getDeltaMovement().add(
                    (this.random.nextDouble() - 0.5D) * 0.05D,
                    (this.random.nextDouble() - 0.5D) * 0.05D,
                    (this.random.nextDouble() - 0.5D) * 0.05D
            ));
        }

        if(this.level().isClientSide()){
            this.setupAnimationStates();
        }

        // 🕒 Despawn after 5 minutes
        if (!this.level().isClientSide) {
            lifetime++;
            if (lifetime > MAX_LIFETIME) {
                this.discard(); // removes the entity safely
            }
        }
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
        // No-op — ghosts ignore fall distance
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        // Ignore most physical / environmental damage
        if (source.is(DamageTypeTags.IS_EXPLOSION)
                || source.is(DamageTypeTags.IS_PROJECTILE)
                || source.is(DamageTypeTags.IS_FIRE)
                || source.is(DamageTypeTags.IS_FALL)
                || source.is(DamageTypeTags.BYPASSES_ARMOR)
                || source.is(DamageTypeTags.IS_LIGHTNING)) {
            return true;
        }
        return super.isInvulnerableTo(source);
    }

    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return (AgeableMob) ModEntities.GHOST.get().create(pLevel);
    }


    public boolean isFood(ItemStack pStack) {
        return pStack.is(ModItems.OBINGOT.get());
    }

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout <+ 0) {
            this.idleAnimationTimeout = 110;
            this.idleAnimationState.start(this.tickCount);
        }
        else{
            --this.idleAnimationTimeout;
        }
    }


    /* SOUNDS */

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.GHAST_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.GHAST_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.GHAST_DEATH;
    }

}

