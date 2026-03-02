package com.stonytark.usefultoolsmod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = UsefultoolsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // -------------------------------------------------------------------------
    // OP Tools / Armor
    // -------------------------------------------------------------------------
    private static final ForgeConfigSpec.BooleanValue OP_TOOL_EFFECTS_ENABLED = BUILDER
            .comment("If false, OP tools (Overpower set) will not grant status effects while held.")
            .define("opTools.toolEffectsEnabled", true);

    private static final ForgeConfigSpec.BooleanValue OP_ARMOR_EFFECTS_ENABLED = BUILDER
            .comment("If false, OP armor (Overpower set) will not grant status effects while worn.")
            .define("opTools.armorEffectsEnabled", true);

    // -------------------------------------------------------------------------
    // Ghost
    // -------------------------------------------------------------------------
    private static final ForgeConfigSpec.BooleanValue GHOST_ENABLED = BUILDER
            .comment("If false, ghosts will not spawn naturally in the world.")
            .define("ghost.enabled", true);

    private static final ForgeConfigSpec.DoubleValue GHOST_SPAWN_CHANCE = BUILDER
            .comment("Fraction of natural ghost spawn attempts that actually succeed (0.0 – 1.0).",
                     "Higher values make ghosts more common. Default is 0.65.")
            .defineInRange("ghost.spawnChance", 0.65, 0.0, 1.0);

    // -------------------------------------------------------------------------
    // Coal Tools / Armor
    // -------------------------------------------------------------------------
    private static final ForgeConfigSpec.BooleanValue COAL_FIRE_EFFECTS_ENABLED = BUILDER
            .comment("If false, coal tools and armor will NOT have the negative burning effects",
                     "(extended fire, durability loss, damage to holder). They can still be used",
                     "as furnace fuel.")
            .define("coalTools.fireEffectsEnabled", true);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    // Static fields read by the rest of the mod
    public static boolean opToolEffectsEnabled;
    public static boolean opArmorEffectsEnabled;
    public static boolean ghostEnabled;
    public static double ghostSpawnChance;
    public static boolean coalFireEffectsEnabled;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        opToolEffectsEnabled    = OP_TOOL_EFFECTS_ENABLED.get();
        opArmorEffectsEnabled   = OP_ARMOR_EFFECTS_ENABLED.get();
        ghostEnabled            = GHOST_ENABLED.get();
        ghostSpawnChance        = GHOST_SPAWN_CHANCE.get();
        coalFireEffectsEnabled  = COAL_FIRE_EFFECTS_ENABLED.get();
    }
}
