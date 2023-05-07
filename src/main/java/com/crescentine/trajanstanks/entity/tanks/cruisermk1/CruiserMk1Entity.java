package com.crescentine.trajanstanks.entity.tanks.cruisermk1;

import com.crescentine.trajanscore.TankModClient;
import com.crescentine.trajanscore.basetank.BaseTankEntity;
import com.crescentine.trajanstanks.config.TankModConfig;
import net.minecraft.client.player.Input;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class CruiserMk1Entity extends BaseTankEntity {
    public CruiserMk1Entity(EntityType<?> entityType, Level world) {
        super(entityType, world);
        this.health = TankModConfig.cruisermk1_health.get();
        this.speedMultiplier = TankModConfig.cruisermk1_speed.get();
        this.shootingCooldown = TankModConfig.cruisermk1_shot_cooldown.get();
        this.armor = 3.0;
        this.healAmount = TankModConfig.cruisermk1_heal_amount.get();
        this.maxFuel = TankModConfig.cruisermk1_maxfuel.get() * 20;
        this.armored = true;
        this.canUseAPCR = false;
        this.canUseHeat = false;
        this.canUseArmorPiercing = false;
        this.canUseHighExplosive = false;
        this.canUseStandard = true;
        this.showFuel = true;
    }
    protected <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }
}