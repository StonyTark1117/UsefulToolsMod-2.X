package com.stonytark.usefultoolsmod.item;

import com.stonytark.usefultoolsmod.block.ModBlocks;
import com.stonytark.usefultoolsmod.util.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier JEMERALD = new ForgeTier(1361, 6, 4.5f, 22,
            ModTags.Blocks.NEEDS_JEM_TOOL, () -> Ingredient.of(Items.EMERALD),
            ModTags.Blocks.INCORRECT_JEM_TOOL);

    public static final Tier SEMERALD = new ForgeTier(1561, 7, 3.2f, 30,
            ModTags.Blocks.NEEDS_SEM_TOOL, () -> Ingredient.of(ModItems.SEM.get()),
            ModTags.Blocks.INCORRECT_SEM_TOOL);

    public static final Tier JOBSIDIAN = new ForgeTier(1650, 9, 6f, 15,
            ModTags.Blocks.NEEDS_JOB_TOOL, () -> Ingredient.of(ModItems.OBSHARD.get()),
            ModTags.Blocks.INCORRECT_JOB_TOOL);

    public static final Tier SOBSIDIAN = new ForgeTier(2031, 10, 5f, 18,
            ModTags.Blocks.NEEDS_SOB_TOOL, () -> Ingredient.of(ModItems.OBINGOT.get()),
            ModTags.Blocks.INCORRECT_SOB_TOOL);

    public static final Tier OVERPOWER = new ForgeTier(9999, 25, 30f, 35,
            ModTags.Blocks.NEEDS_OP_TOOL, () -> Ingredient.of(ModBlocks.SOBLOCK.get()),
            ModTags.Blocks.INCORRECT_OP_TOOL);

    public static final Tier HREDSTONE = new ForgeTier(600, 8, 3f, 20,
            ModTags.Blocks.NEEDS_HRED_TOOL, () -> Ingredient.of(ModItems.HRED.get()),
            ModTags.Blocks.INCORRECT_HRED_TOOL);

    /**
     * Hardened Glowstone — iron mining level, magical/light-based complement to HREDSTONE.
     * Lower durability and attack than HRED, but significantly higher enchantability.
     * Sacrifices raw power for synergy with enchantments.
     */
    public static final Tier HGLOWSTONE = new ForgeTier(500, 7.0f, 2f, 28,
            ModTags.Blocks.NEEDS_HGLOW_TOOL, () -> Ingredient.of(ModItems.HGLOW.get()),
            ModTags.Blocks.INCORRECT_HGLOW_TOOL);

    public static final Tier RGOLD = new ForgeTier(1200, 8, 3.5f, 16,
            ModTags.Blocks.NEEDS_RGOLD_TOOL, () -> Ingredient.of(ModItems.RGOLD.get()),
            ModTags.Blocks.INCORRECT_RGOLD_TOOL);

    public static final Tier RLAPIS = new ForgeTier(1100, 9, 3.2f, 32,
            ModTags.Blocks.NEEDS_RLAPIS_TOOL, () -> Ingredient.of(ModItems.RGOLD.get()),
            ModTags.Blocks.INCORRECT_RLAPIS_TOOL);

    /**
     * Coal tool tier — sits between wood and stone.
     * Durability closer to stone, mining level equivalent to wood.
     */
    public static final Tier COAL_TOOL = new ForgeTier(120, 0, 3.0f, 5,
            BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            () -> Ingredient.of(ModItems.HARDENED_COAL.get()),
            BlockTags.INCORRECT_FOR_WOODEN_TOOL);

    // ── Raw material jagged tiers ────────────────────────────────────────────

    /** Jagged Raw Gold — wood mining level, very fast but fragile and inaccurate. */
    public static final Tier JRAW_GOLD = new ForgeTier(80, 12.0f, 0.0f, 25,
            BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(Items.RAW_GOLD),
            BlockTags.INCORRECT_FOR_WOODEN_TOOL);

    /** Jagged Raw Copper — stone mining level, decent all-rounder from raw ore. */
    public static final Tier JRAW_COPPER = new ForgeTier(170, 5.0f, 1.0f, 10,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.RAW_COPPER),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Jagged Raw Iron — iron mining level, slightly weaker than refined iron. */
    public static final Tier JRAW_IRON = new ForgeTier(200, 5.5f, 1.5f, 10,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.RAW_IRON),
            BlockTags.INCORRECT_FOR_IRON_TOOL);

    /** Jagged Raw Ferrous Gold — iron mining level, bridge between raw and refined rgold. */
    public static final Tier JRAW_RGOLD = new ForgeTier(600, 7.0f, 2.0f, 14,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.RAW_RGOLD.get()),
            BlockTags.INCORRECT_FOR_IRON_TOOL);

    /** Jagged Netherite Scrap — diamond mining level, partially processed ancient metal. */
    public static final Tier JSCRAP = new ForgeTier(800, 7.5f, 2.5f, 12,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.NETHERITE_SCRAP),
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

    // ── Crystal / element jagged tiers (tools-only) ────────────────────────────

    /**
     * Jagged Amethyst — stone mining level.
     * Geode shards are mid-game but unrefined; comparable to JRAW_COPPER but enchantable.
     */
    public static final Tier JAMETHYST = new ForgeTier(250, 5.0f, 1.5f, 12,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.AMETHYST_SHARD),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /**
     * Snow — wood mining level, barely functional.
     * Snowballs are free and abundant; tools shatter almost immediately.
     */
    public static final Tier SNOW_TOOL = new ForgeTier(45, 3.0f, 0.0f, 4,
            BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(Items.SNOWBALL),
            BlockTags.INCORRECT_FOR_WOODEN_TOOL);

    /**
     * Jagged Quartz — stone mining level, slightly faster than amethyst.
     * Nether quartz requires portal access, giving it a speed edge.
     */
    public static final Tier JQUARTZ = new ForgeTier(310, 5.5f, 1.5f, 10,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.QUARTZ),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /**
     * Jagged Prismarine — stone mining level, slightly weaker than amethyst.
     * Prismarine shards require defeating guardians but are still raw crystal.
     */
    public static final Tier JPRISM = new ForgeTier(240, 4.5f, 1.5f, 8,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.PRISMARINE_SHARD),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    // ── Stone rock variant tiers ─────────────────────────────────────────────────
    // All stone-level: NEEDS_IRON_TOOL correct, INCORRECT_FOR_STONE_TOOL drops.
    // Repair = the respective block item.  Stats reflect real-world hardness/weight.

    /** Andesite — baseline igneous rock.  Matches vanilla stone exactly. */
    public static final Tier STONE_ANDESITE = new ForgeTier(131, 4.0f, 1.5f, 5,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.ANDESITE),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Basalt — dense columnar volcanic rock.  Durable but heavy and slow. */
    public static final Tier STONE_BASALT = new ForgeTier(155, 3.8f, 2.0f, 4,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.BASALT),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Blackstone — hardened Nether volcanic rock.  Toughest stone variant. */
    public static final Tier STONE_BLACKSTONE = new ForgeTier(170, 3.7f, 2.0f, 5,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.BLACKSTONE),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Calcite — soft crystalline mineral (Mohs ~3).  Fragile but enchantable and light. */
    public static final Tier STONE_CALCITE = new ForgeTier(75, 4.5f, 0.5f, 8,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.CALCITE),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Cobbled Deepslate — compressed deep-layer rock.  Very durable, noticeably sluggish. */
    public static final Tier STONE_DEEPSLATE = new ForgeTier(178, 3.5f, 2.0f, 4,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.COBBLED_DEEPSLATE),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Diorite — coarser igneous rock.  Slightly better all-round than andesite. */
    public static final Tier STONE_DIORITE = new ForgeTier(140, 3.9f, 1.5f, 6,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.DIORITE),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** End Stone — dense alien material.  Hard and reliable, high enchantability. */
    public static final Tier STONE_END_STONE = new ForgeTier(145, 4.1f, 1.5f, 7,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.END_STONE),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Granite — very hard igneous rock.  Strong and heavy. */
    public static final Tier STONE_GRANITE = new ForgeTier(158, 3.7f, 2.0f, 5,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.GRANITE),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Netherrack — crumbly Nether rock.  Barely functional; fastest but weakest. */
    public static final Tier STONE_NETHERRACK = new ForgeTier(80, 4.8f, 0.5f, 6,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.NETHERRACK),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Sandstone — soft sedimentary rock.  Light and nimble but brittle. */
    public static final Tier STONE_SANDSTONE = new ForgeTier(100, 4.2f, 0.5f, 5,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.SANDSTONE),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Smooth Basalt — polished volcanic rock.  Balanced; sits between basalt and andesite. */
    public static final Tier STONE_SMOOTH_BASALT = new ForgeTier(148, 3.9f, 1.8f, 5,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.SMOOTH_BASALT),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Terracotta — baked clay.  Moderate stats; more enchantable than plain stone. */
    public static final Tier STONE_TERRACOTTA = new ForgeTier(120, 4.0f, 1.0f, 7,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.TERRACOTTA),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /** Tuff — compressed volcanic ash.  Below-average damage and durability. */
    public static final Tier STONE_TUFF = new ForgeTier(110, 4.0f, 1.0f, 5,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.TUFF),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    // ── Flint / Flint-Iron tiers ─────────────────────────────────────────────────

    /**
     * Jagged Flint — stone mining level, primitive but accessible.
     * Chipped shards from flint nodules; worse stats than JAMETHYST but found near surface.
     */
    public static final Tier JFLINT = new ForgeTier(200, 4.5f, 0.5f, 5,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.FLINT),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /**
     * Flint-Iron (FNI) — iron mining level, slightly below refined iron.
     * A hybrid of sharp flint edges and an iron frame; durable but not quite polished.
     */
    public static final Tier FNI_TOOLS = new ForgeTier(220, 5.5f, 2.0f, 9,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(Items.FLINT),
            BlockTags.INCORRECT_FOR_IRON_TOOL);

    // ── Crystal / element smooth tiers (tools + armor) ─────────────────────────

    /**
     * Calcified Amethyst — iron mining level.
     * Refined geode alloy; sits below HREDSTONE.
     */
    public static final Tier CAMETHYST = new ForgeTier(580, 6.5f, 2.5f, 14,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.CALCIFIED_AMETHYST.get()),
            BlockTags.INCORRECT_FOR_IRON_TOOL);

    /**
     * Glacial — stone mining level, worst of the stone crystal tier.
     * Ancient ice shards; brittle and temporary — melts over time.
     */
    public static final Tier ICE_TOOL = new ForgeTier(180, 4.0f, 1.0f, 6,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.GLACIAL_SHARD.get()),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    /**
     * Smooth Quartz — iron mining level, best durability of the smooth set.
     * Polished nether quartz; durable and reliable.
     */
    public static final Tier SQUARTZ = new ForgeTier(640, 7.0f, 2.5f, 10,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.POLISHED_QUARTZ.get()),
            BlockTags.INCORRECT_FOR_IRON_TOOL);

    /**
     * Smooth Prismarine — iron mining level.
     * Polished ocean crystal; balanced between camethyst and glacial.
     */
    public static final Tier SPRISM = new ForgeTier(560, 6.5f, 2.0f, 12,
            BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.POLISHED_PRISMARINE.get()),
            BlockTags.INCORRECT_FOR_IRON_TOOL);
}
