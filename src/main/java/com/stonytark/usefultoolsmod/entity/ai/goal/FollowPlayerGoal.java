package com.stonytark.usefultoolsmod.entity.ai.goal;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.List;

public class FollowPlayerGoal extends Goal {
    private final Mob mob;
    private Player targetPlayer;
    private final double speedModifier;
    private final double followRange;
    private final double stopDistance;

    public FollowPlayerGoal(Mob mob, double speedModifier, double followRange, double stopDistance) {
        this.mob = mob;
        this.speedModifier = speedModifier;
        this.followRange = followRange;
        this.stopDistance = stopDistance;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // Find closest visible player within range
        List<Player> players = mob.level().getEntitiesOfClass(Player.class,
                mob.getBoundingBox().inflate(followRange),
                player -> player.isAlive() && !player.isSpectator());

        double closestDistance = Double.MAX_VALUE;
        Player closestPlayer = null;

        for (Player player : players) {
            double dist = mob.distanceToSqr(player);
            if (dist < closestDistance && mob.hasLineOfSight(player)) {
                closestDistance = dist;
                closestPlayer = player;
            }
        }

        if (closestPlayer != null) {
            this.targetPlayer = closestPlayer;
            return true;
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return targetPlayer != null
                && targetPlayer.isAlive()
                && mob.distanceToSqr(targetPlayer) > stopDistance * stopDistance
                && mob.hasLineOfSight(targetPlayer);
    }

    @Override
    public void stop() {
        targetPlayer = null;
        mob.getNavigation().stop();
    }

    @Override
    public void tick() {
        if (targetPlayer == null) return;

        Vec3 targetPos = targetPlayer.position();
        mob.getLookControl().setLookAt(targetPlayer, 30.0F, 30.0F);
        mob.getNavigation().moveTo(targetPos.x, targetPos.y + 1.0D, targetPos.z, speedModifier);
    }
}