package com.stonytark.usefultoolsmod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = UsefultoolsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // =====================================================================
    //  Set toggles — "enabled" hides the entire set from the creative tab
    // =====================================================================

    // --- Explosives (Dynamite, Grenade) ---
    private static final ForgeConfigSpec.BooleanValue EXPLOSIVES_ENABLED;

    // --- Obsidian (Jagged Obsidian tools, Smooth Obsidian tools, Obsidian armor) ---
    private static final ForgeConfigSpec.BooleanValue OBSIDIAN_ENABLED;

    // --- Emerald (Smooth Emerald tools, Jagged Emerald tools, Emerald armor) ---
    private static final ForgeConfigSpec.BooleanValue EMERALD_ENABLED;

    // --- Lapis (Reinforced Lapis tools + armor) ---
    private static final ForgeConfigSpec.BooleanValue LAPIS_ENABLED;

    // --- Ferrous Gold (tools, armor, ores, blocks) ---
    private static final ForgeConfigSpec.BooleanValue FERROUS_GOLD_ENABLED;

    // --- Hardened Redstone (tools + armor) ---
    private static final ForgeConfigSpec.BooleanValue HARDENED_REDSTONE_ENABLED;

    // --- Hardened Glowstone (tools + armor) ---
    private static final ForgeConfigSpec.BooleanValue HARDENED_GLOWSTONE_ENABLED;

    // --- Overpower (tools + armor) ---
    private static final ForgeConfigSpec.BooleanValue OVERPOWER_ENABLED;
    private static final ForgeConfigSpec.BooleanValue OVERPOWER_TOOL_EFFECTS;
    private static final ForgeConfigSpec.BooleanValue OVERPOWER_ARMOR_EFFECTS;

    // --- Ghost + Ectoplasm ---
    private static final ForgeConfigSpec.BooleanValue GHOST_ENABLED;
    private static final ForgeConfigSpec.DoubleValue GHOST_SPAWN_CHANCE;

    // --- Spectral Infuser ---
    private static final ForgeConfigSpec.BooleanValue SPECTRAL_INFUSER_ENABLED;

    // --- Raw Metal Jagged (raw gold/copper/iron/rgold/scrap tools) ---
    private static final ForgeConfigSpec.BooleanValue RAW_METAL_JAGGED_ENABLED;

    // --- Jagged Crystal (Jagged Amethyst, Jagged Quartz, Jagged Prismarine) ---
    private static final ForgeConfigSpec.BooleanValue JAGGED_CRYSTAL_ENABLED;

    // --- Snow (tools only) ---
    private static final ForgeConfigSpec.BooleanValue SNOW_ENABLED;
    private static final ForgeConfigSpec.BooleanValue SNOW_MELT_EFFECTS;

    // --- Smooth Crystal (Calcite Amethyst, Smooth Quartz — tools + armor) ---
    private static final ForgeConfigSpec.BooleanValue SMOOTH_CRYSTAL_ENABLED;

    // --- Ice / Glacial (tools + armor) ---
    private static final ForgeConfigSpec.BooleanValue ICE_ENABLED;
    private static final ForgeConfigSpec.BooleanValue ICE_EFFECTS;

    // --- Smooth Prismarine (tools + armor) ---
    private static final ForgeConfigSpec.BooleanValue SPRISM_ENABLED;
    private static final ForgeConfigSpec.BooleanValue SPRISM_WATER_EFFECTS;

    // --- Flint (Jagged Flint tools) ---
    private static final ForgeConfigSpec.BooleanValue FLINT_ENABLED;

    // --- Flint-Iron / FNI (tools + armor) ---
    private static final ForgeConfigSpec.BooleanValue FNI_ENABLED;
    private static final ForgeConfigSpec.BooleanValue FNI_FIRE_EFFECTS;

    // --- Stone Variants (13 stone-type tool sets) ---
    private static final ForgeConfigSpec.BooleanValue STONE_VARIANTS_ENABLED;

    // --- Coal (tools + armor) ---
    private static final ForgeConfigSpec.BooleanValue COAL_ENABLED;
    private static final ForgeConfigSpec.BooleanValue COAL_FIRE_EFFECTS;

    // =====================================================================
    //  Build the spec using push/pop for clean TOML sections
    // =====================================================================
    static {
        BUILDER.push("explosives");
        EXPLOSIVES_ENABLED = BUILDER
                .comment("Enable the Explosives set (Dynamite, Grenade).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("obsidian");
        OBSIDIAN_ENABLED = BUILDER
                .comment("Enable the Obsidian set (Jagged/Smooth Obsidian tools, Obsidian armor).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("emerald");
        EMERALD_ENABLED = BUILDER
                .comment("Enable the Emerald set (Smooth/Jagged Emerald tools, Emerald armor).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("lapis");
        LAPIS_ENABLED = BUILDER
                .comment("Enable the Reinforced Lapis set (tools + armor).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("ferrousGold");
        FERROUS_GOLD_ENABLED = BUILDER
                .comment("Enable the Ferrous Gold set (tools, armor, ores, blocks).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("hardenedRedstone");
        HARDENED_REDSTONE_ENABLED = BUILDER
                .comment("Enable the Hardened Redstone set (tools + armor).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("hardenedGlowstone");
        HARDENED_GLOWSTONE_ENABLED = BUILDER
                .comment("Enable the Hardened Glowstone set (tools + armor).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("overpower");
        OVERPOWER_ENABLED = BUILDER
                .comment("Enable the Overpower set (tools + armor).")
                .define("enabled", true);
        OVERPOWER_TOOL_EFFECTS = BUILDER
                .comment("If false, Overpower tools will not grant status effects while held.",
                         "The tools themselves still function normally.")
                .define("toolEffectsEnabled", true);
        OVERPOWER_ARMOR_EFFECTS = BUILDER
                .comment("If false, Overpower armor will not grant status effects when wearing a full set.",
                         "The armor itself still provides protection.")
                .define("armorEffectsEnabled", true);
        BUILDER.pop();

        BUILDER.push("ghost");
        GHOST_ENABLED = BUILDER
                .comment("If false, ghosts will not spawn naturally in the world.",
                         "Ghost spawn eggs and ectoplasm will also be hidden from the creative tab.")
                .define("enabled", true);
        GHOST_SPAWN_CHANCE = BUILDER
                .comment("Fraction of natural ghost spawn attempts that actually succeed (0.0 - 1.0).",
                         "Higher values make ghosts more common. Default is 0.65.")
                .defineInRange("spawnChance", 0.65, 0.0, 1.0);
        BUILDER.pop();

        BUILDER.push("spectralInfuser");
        SPECTRAL_INFUSER_ENABLED = BUILDER
                .comment("Enable the Spectral Infuser block (ectoplasm weapon infusion station).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("rawMetalJagged");
        RAW_METAL_JAGGED_ENABLED = BUILDER
                .comment("Enable the Raw Metal Jagged tool sets",
                         "(Raw Gold, Raw Copper, Raw Iron, Raw Ferrous Gold, Netherite Scrap).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("jaggedCrystal");
        JAGGED_CRYSTAL_ENABLED = BUILDER
                .comment("Enable the Jagged Crystal tool sets",
                         "(Jagged Amethyst, Jagged Quartz, Jagged Prismarine).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("snow");
        SNOW_ENABLED = BUILDER
                .comment("Enable the Snow tool set.")
                .define("enabled", true);
        SNOW_MELT_EFFECTS = BUILDER
                .comment("If false, snow tools will not melt (lose durability) over time when held.",
                         "Also disables the fire-protection durability trade-off.")
                .define("meltEffectsEnabled", true);
        BUILDER.pop();

        BUILDER.push("smoothCrystal");
        SMOOTH_CRYSTAL_ENABLED = BUILDER
                .comment("Enable the Smooth Crystal sets (Calcite Amethyst, Smooth Quartz — tools + armor).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("ice");
        ICE_ENABLED = BUILDER
                .comment("Enable the Ice / Glacial set (tools + armor).")
                .define("enabled", true);
        ICE_EFFECTS = BUILDER
                .comment("If false, ice tools/armor will not melt over time",
                         "and will not provide fire protection.")
                .define("effectsEnabled", true);
        BUILDER.pop();

        BUILDER.push("sprism");
        SPRISM_ENABLED = BUILDER
                .comment("Enable the Smooth Prismarine set (tools + armor).")
                .define("enabled", true);
        SPRISM_WATER_EFFECTS = BUILDER
                .comment("If false, smooth prismarine tools/armor will not grant",
                         "underwater status effects (Water Breathing, Haste, Dolphin's Grace, etc.).")
                .define("waterEffectsEnabled", true);
        BUILDER.pop();

        BUILDER.push("flint");
        FLINT_ENABLED = BUILDER
                .comment("Enable the Jagged Flint tool set.")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("fni");
        FNI_ENABLED = BUILDER
                .comment("Enable the Flint-Iron / FNI set (tools + armor).")
                .define("enabled", true);
        FNI_FIRE_EFFECTS = BUILDER
                .comment("If false, FNI tools will not place fire on sneak+right-click,",
                         "FNI boots will not ignite flammable blocks, and the full FNI set",
                         "will not reduce fire duration.")
                .define("fireEffectsEnabled", true);
        BUILDER.pop();

        BUILDER.push("stoneVariants");
        STONE_VARIANTS_ENABLED = BUILDER
                .comment("Enable all 13 Stone Rock Variant tool sets",
                         "(Andesite, Basalt, Blackstone, Calcite, Deepslate, Diorite,",
                         " End Stone, Granite, Netherrack, Sandstone, Smooth Basalt,",
                         " Terracotta, Tuff).")
                .define("enabled", true);
        BUILDER.pop();

        BUILDER.push("coal");
        COAL_ENABLED = BUILDER
                .comment("Enable the Coal set (Coal Dust, Hardened Coal, tools + armor).")
                .define("enabled", true);
        COAL_FIRE_EFFECTS = BUILDER
                .comment("If false, coal tools and armor will NOT have the negative burning effects",
                         "(extended fire, durability loss, damage to holder). They can still be used",
                         "as furnace fuel.")
                .define("fireEffectsEnabled", true);
        BUILDER.pop();
    }

    static final ForgeConfigSpec SPEC = BUILDER.build();

    // =====================================================================
    //  Static fields — default to true so everything works before config loads
    // =====================================================================

    // Set enabled flags
    public static boolean explosivesEnabled = true;
    public static boolean obsidianEnabled = true;
    public static boolean emeraldEnabled = true;
    public static boolean lapisEnabled = true;
    public static boolean ferrousGoldEnabled = true;
    public static boolean hardenedRedstoneEnabled = true;
    public static boolean hardenedGlowstoneEnabled = true;
    public static boolean overpowerEnabled = true;
    public static boolean ghostEnabled = true;
    public static boolean spectralInfuserEnabled = true;
    public static boolean rawMetalJaggedEnabled = true;
    public static boolean jaggedCrystalEnabled = true;
    public static boolean snowEnabled = true;
    public static boolean smoothCrystalEnabled = true;
    public static boolean iceEnabled = true;
    public static boolean sprismEnabled = true;
    public static boolean flintEnabled = true;
    public static boolean fniEnabled = true;
    public static boolean stoneVariantsEnabled = true;
    public static boolean coalEnabled = true;

    // Effect flags
    public static boolean opToolEffectsEnabled = true;
    public static boolean opArmorEffectsEnabled = true;
    public static double ghostSpawnChance = 0.65;
    public static boolean snowMeltEffects = true;
    public static boolean iceEffects = true;
    public static boolean sprismWaterEffects = true;
    public static boolean fniFireEffects = true;
    public static boolean coalFireEffects = true;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        // Set enabled
        explosivesEnabled        = EXPLOSIVES_ENABLED.get();
        obsidianEnabled          = OBSIDIAN_ENABLED.get();
        emeraldEnabled           = EMERALD_ENABLED.get();
        lapisEnabled             = LAPIS_ENABLED.get();
        ferrousGoldEnabled       = FERROUS_GOLD_ENABLED.get();
        hardenedRedstoneEnabled  = HARDENED_REDSTONE_ENABLED.get();
        hardenedGlowstoneEnabled = HARDENED_GLOWSTONE_ENABLED.get();
        overpowerEnabled         = OVERPOWER_ENABLED.get();
        ghostEnabled             = GHOST_ENABLED.get();
        spectralInfuserEnabled   = SPECTRAL_INFUSER_ENABLED.get();
        rawMetalJaggedEnabled    = RAW_METAL_JAGGED_ENABLED.get();
        jaggedCrystalEnabled     = JAGGED_CRYSTAL_ENABLED.get();
        snowEnabled              = SNOW_ENABLED.get();
        smoothCrystalEnabled     = SMOOTH_CRYSTAL_ENABLED.get();
        iceEnabled               = ICE_ENABLED.get();
        sprismEnabled            = SPRISM_ENABLED.get();
        flintEnabled             = FLINT_ENABLED.get();
        fniEnabled               = FNI_ENABLED.get();
        stoneVariantsEnabled     = STONE_VARIANTS_ENABLED.get();
        coalEnabled              = COAL_ENABLED.get();

        // Effects
        opToolEffectsEnabled     = OVERPOWER_TOOL_EFFECTS.get();
        opArmorEffectsEnabled    = OVERPOWER_ARMOR_EFFECTS.get();
        ghostSpawnChance         = GHOST_SPAWN_CHANCE.get();
        snowMeltEffects          = SNOW_MELT_EFFECTS.get();
        iceEffects               = ICE_EFFECTS.get();
        sprismWaterEffects       = SPRISM_WATER_EFFECTS.get();
        fniFireEffects           = FNI_FIRE_EFFECTS.get();
        coalFireEffects          = COAL_FIRE_EFFECTS.get();
    }
}
