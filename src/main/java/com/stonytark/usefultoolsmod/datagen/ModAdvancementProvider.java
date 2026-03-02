package com.stonytark.usefultoolsmod.datagen;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import com.stonytark.usefultoolsmod.block.ModBlocks;
import com.stonytark.usefultoolsmod.entity.ModEntities;
import com.stonytark.usefultoolsmod.item.ModItems;
import com.stonytark.usefultoolsmod.trigger.CoalToolIgnitedTrigger;
import com.stonytark.usefultoolsmod.trigger.GhostNearbyTrigger;
import com.stonytark.usefultoolsmod.trigger.ModTriggers;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {

    public ModAdvancementProvider(PackOutput output,
                                   CompletableFuture<HolderLookup.Provider> lookupProvider,
                                   ExistingFileHelper efh) {
        super(output, lookupProvider, List.of(new UsefulToolsAdvancements()));
    }

    // -----------------------------------------------------------------------
    // Sub-provider — builds the entire advancement tree
    // -----------------------------------------------------------------------
    static class UsefulToolsAdvancements implements AdvancementSubProvider {

        private static final ResourceLocation BACKGROUND =
                ResourceLocation.withDefaultNamespace("textures/block/netherrack.png");

        @Override
        public void generate(HolderLookup.Provider registries,
                             Consumer<AdvancementHolder> saver) {

            // ==================================================================
            // ROOT
            // ==================================================================
            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(
                            ModItems.RAW_RGOLD.get(),
                            title("root"),
                            desc("root"),
                            BACKGROUND,
                            AdvancementType.TASK,
                            false, false, false
                    )
                    .addCriterion("has_raw_rgold", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_RGOLD.get()))
                    .save(saver, id("root"));

            // ==================================================================
            // RGOLD ingot (smelt raw ore → ingot) — bridges root to tools/armor
            // ==================================================================
            AdvancementHolder rgold = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.RGOLD.get(), title("rgold"), desc("rgold"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_rgold",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RGOLD.get()))
                    .save(saver, id("rgold"));

            // ==================================================================
            // BRANCH: Ore Discovery (from root)
            // ==================================================================
            AdvancementHolder oreFound = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModBlocks.RGOLDORE.get(), title("ore_found"), desc("ore_found"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_rgold_ore",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.RGOLDORE.get()))
                    .save(saver, id("ore_found"));

            Advancement.Builder.advancement()
                    .parent(oreFound)
                    .display(ModBlocks.RGOLD_NETHER_ORE.get(), title("nether_ore"), desc("nether_ore"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_nether_ore",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.RGOLD_NETHER_ORE.get()))
                    .save(saver, id("nether_ore"));

            Advancement.Builder.advancement()
                    .parent(oreFound)
                    .display(ModBlocks.RGOLD_END_ORE.get(), title("end_ore"), desc("end_ore"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_end_ore",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.RGOLD_END_ORE.get()))
                    .save(saver, id("end_ore"));

            Advancement.Builder.advancement()
                    .parent(oreFound)
                    .display(ModBlocks.RGOLD_DEEPSLATE_ORE.get(), title("deepslate_ore"), desc("deepslate_ore"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_deepslate_ore",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.RGOLD_DEEPSLATE_ORE.get()))
                    .save(saver, id("deepslate_ore"));

            // ==================================================================
            // BRANCH: Reinforced Gold Tools / Armor (from rgold ingot)
            // ==================================================================
            AdvancementHolder rgoldSword = Advancement.Builder.advancement()
                    .parent(rgold)
                    .display(ModItems.RGOLD_SWORD.get(), title("rgold_tools"), desc("rgold_tools"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_rgold_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RGOLD_SWORD.get()))
                    .save(saver, id("rgold_tools"));

            Advancement.Builder.advancement()
                    .parent(rgoldSword)
                    .display(ModItems.RGOLD_HELMET.get(), title("rgold_armor"), desc("rgold_armor"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_rgold_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RGOLD_HELMET.get()))
                    .save(saver, id("rgold_armor"));

            // ==================================================================
            // BRANCH: Obsidian (from root)
            // ==================================================================
            AdvancementHolder obshard = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.OBSHARD.get(), title("obshard"), desc("obshard"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_obshard",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OBSHARD.get()))
                    .save(saver, id("obshard"));

            AdvancementHolder obingot = Advancement.Builder.advancement()
                    .parent(obshard)
                    .display(ModItems.OBINGOT.get(), title("obingot"), desc("obingot"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_obingot",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OBINGOT.get()))
                    .save(saver, id("obingot"));

            Advancement.Builder.advancement()
                    .parent(obingot)
                    .display(ModItems.JOBSIDIAN_SWORD.get(), title("jobsidian"), desc("jobsidian"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_jobsidian_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JOBSIDIAN_SWORD.get()))
                    .save(saver, id("jobsidian"));

            Advancement.Builder.advancement()
                    .parent(obingot)
                    .display(ModItems.SOBSIDIAN_SWORD.get(), title("sobsidian"), desc("sobsidian"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_sobsidian_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SOBSIDIAN_SWORD.get()))
                    .save(saver, id("sobsidian"));

            // Full Obsidian armor (CHALLENGE — requires all 4 pieces)
            Advancement.Builder.advancement()
                    .parent(obingot)
                    .display(ModItems.OBSIDIAN_CHESTPLATE.get(), title("obsidian_armor"), desc("obsidian_armor"),
                            null, AdvancementType.CHALLENGE, true, true, false)
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OBSIDIAN_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OBSIDIAN_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OBSIDIAN_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OBSIDIAN_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("obsidian_armor"));

            // ==================================================================
            // BRANCH: Smooth Emerald (from root)
            // ==================================================================
            AdvancementHolder sem = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.SEM.get(), title("sem"), desc("sem"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_sem",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEM.get()))
                    .save(saver, id("sem"));

            Advancement.Builder.advancement()
                    .parent(sem)
                    .display(ModItems.JEMERALD_SWORD.get(), title("jemerald"), desc("jemerald"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_jemerald_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JEMERALD_SWORD.get()))
                    .save(saver, id("jemerald"));

            Advancement.Builder.advancement()
                    .parent(sem)
                    .display(ModItems.SEMERALD_SWORD.get(), title("semerald"), desc("semerald"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_semerald_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SEMERALD_SWORD.get()))
                    .save(saver, id("semerald"));

            Advancement.Builder.advancement()
                    .parent(sem)
                    .display(ModItems.EMERALD_HELMET.get(), title("emerald_armor"), desc("emerald_armor"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMERALD_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("emerald_armor"));

            // ==================================================================
            // BRANCH: Hardened Redstone (from root)
            // ==================================================================
            AdvancementHolder hred = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.HRED.get(), title("hred"), desc("hred"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_hred",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HRED.get()))
                    .save(saver, id("hred"));

            Advancement.Builder.advancement()
                    .parent(hred)
                    .display(ModItems.HREDSTONE_SWORD.get(), title("hredstone_tools"), desc("hredstone_tools"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_hredstone_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HREDSTONE_SWORD.get()))
                    .save(saver, id("hredstone_tools"));

            Advancement.Builder.advancement()
                    .parent(hred)
                    .display(ModItems.HRED_HELMET.get(), title("hred_armor"), desc("hred_armor"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HRED_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HRED_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HRED_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HRED_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("hred_armor"));

            // ==================================================================
            // BRANCH: Hardened Glowstone (from root)
            // ==================================================================
            AdvancementHolder hglow = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.HGLOW.get(), title("hglow"), desc("hglow"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_hglow",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HGLOW.get()))
                    .save(saver, id("hglow"));

            Advancement.Builder.advancement()
                    .parent(hglow)
                    .display(ModItems.HGLOWSTONE_SWORD.get(), title("hglowstone_tools"), desc("hglowstone_tools"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_hglowstone_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HGLOWSTONE_SWORD.get()))
                    .save(saver, id("hglowstone_tools"));

            Advancement.Builder.advancement()
                    .parent(hglow)
                    .display(ModItems.HGLOW_HELMET.get(), title("hglow_armor"), desc("hglow_armor"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HGLOW_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HGLOW_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HGLOW_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HGLOW_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("hglow_armor"));

            // ==================================================================
            // BRANCH: Reinforced Lapis (from root)
            // ==================================================================
            AdvancementHolder rlapis = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.RLAPIS.get(), title("rlapis"), desc("rlapis"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_rlapis",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RLAPIS.get()))
                    .save(saver, id("rlapis"));

            Advancement.Builder.advancement()
                    .parent(rlapis)
                    .display(ModItems.RLAPIS_SWORD.get(), title("rlapis_tools"), desc("rlapis_tools"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_rlapis_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RLAPIS_SWORD.get()))
                    .save(saver, id("rlapis_tools"));

            Advancement.Builder.advancement()
                    .parent(rlapis)
                    .display(ModItems.RLAPIS_HELMET.get(), title("rlapis_armor"), desc("rlapis_armor"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RLAPIS_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RLAPIS_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RLAPIS_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RLAPIS_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("rlapis_armor"));

            // ==================================================================
            // BRANCH: Coal Tools / Armor (from root)
            // ==================================================================
            AdvancementHolder coalDust = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.COAL_DUST.get(), title("coal_dust"), desc("coal_dust"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_coal_dust",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COAL_DUST.get()))
                    .save(saver, id("coal_dust"));

            AdvancementHolder hardenedCoal = Advancement.Builder.advancement()
                    .parent(coalDust)
                    .display(ModItems.HARDENED_COAL.get(), title("hardened_coal"), desc("hardened_coal"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_hardened_coal",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HARDENED_COAL.get()))
                    .save(saver, id("hardened_coal"));

            AdvancementHolder coalTools = Advancement.Builder.advancement()
                    .parent(hardenedCoal)
                    .display(ModItems.COAL_PICKAXE.get(), title("coal_tools"), desc("coal_tools"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COAL_PICKAXE.get()))
                    .save(saver, id("coal_tools"));

            // Trial by Fire — custom trigger (CHALLENGE)
            Advancement.Builder.advancement()
                    .parent(coalTools)
                    .display(ModItems.COAL_SWORD.get(), title("coal_trial_by_fire"), desc("coal_trial_by_fire"),
                            null, AdvancementType.CHALLENGE, true, true, false)
                    .addCriterion("coal_tool_ignited",
                            ModTriggers.COAL_TOOL_IGNITED.get().createCriterion(
                                    new CoalToolIgnitedTrigger.TriggerInstance(Optional.empty())))
                    .save(saver, id("coal_trial_by_fire"));

            AdvancementHolder coalArmor = Advancement.Builder.advancement()
                    .parent(hardenedCoal)
                    .display(ModItems.COAL_HELMET.get(), title("coal_armor"), desc("coal_armor"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_coal_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COAL_HELMET.get()))
                    .save(saver, id("coal_armor"));

            // Burning Commitment — full coal armor set (CHALLENGE)
            Advancement.Builder.advancement()
                    .parent(coalArmor)
                    .display(ModItems.COAL_CHESTPLATE.get(), title("coal_full_set"), desc("coal_full_set"),
                            null, AdvancementType.CHALLENGE, true, true, true)
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COAL_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COAL_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COAL_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COAL_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("coal_full_set"));

            // ==================================================================
            // BRANCH: Explosives (from root)
            // ==================================================================
            AdvancementHolder grenade = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.GRENADE.get(), title("grenade"), desc("grenade"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_grenade",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GRENADE.get()))
                    .save(saver, id("grenade"));

            Advancement.Builder.advancement()
                    .parent(grenade)
                    .display(ModItems.DYNAMITE.get(), title("dynamite"), desc("dynamite"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_dynamite",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DYNAMITE.get()))
                    .save(saver, id("dynamite"));

            // ==================================================================
            // BRANCH: Ghost (from root)
            // ==================================================================
            AdvancementHolder ghostEncounter = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.GHOST_SPAWN_EGG.get(), title("ghost_encounter"), desc("ghost_encounter"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("ghost_nearby",
                            ModTriggers.GHOST_NEARBY.get().createCriterion(
                                    new GhostNearbyTrigger.TriggerInstance(Optional.empty())))
                    .save(saver, id("ghost_encounter"));

            Advancement.Builder.advancement()
                    .parent(ghostEncounter)
                    .display(ModItems.GHOST_SPAWN_EGG.get(), title("ghost_companion"), desc("ghost_companion"),
                            null, AdvancementType.GOAL, true, true, true)
                    .addCriterion("ghost_nearby_again",
                            ModTriggers.GHOST_NEARBY.get().createCriterion(
                                    new GhostNearbyTrigger.TriggerInstance(Optional.empty())))
                    .save(saver, id("ghost_companion"));

            // ==================================================================
            // BRANCH: Raw Metal Jagged Tools (all from root)
            // ==================================================================

            // Raw Gold → Jagged Raw Gold tools → full set
            AdvancementHolder jrawGold = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.JRAW_GOLD_SWORD.get(), title("jraw_gold"), desc("jraw_gold"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_jraw_gold_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_GOLD_SWORD.get()))
                    .save(saver, id("jraw_gold"));

            Advancement.Builder.advancement()
                    .parent(jrawGold)
                    .display(ModItems.JRAW_GOLD_PICKAXE.get(), title("jraw_gold_set"), desc("jraw_gold_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_GOLD_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_GOLD_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_GOLD_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_GOLD_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_GOLD_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("jraw_gold_set"));

            // Raw Copper → Jagged Raw Copper tools → full set
            AdvancementHolder jrawCopper = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.JRAW_COPPER_SWORD.get(), title("jraw_copper"), desc("jraw_copper"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_jraw_copper_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_COPPER_SWORD.get()))
                    .save(saver, id("jraw_copper"));

            Advancement.Builder.advancement()
                    .parent(jrawCopper)
                    .display(ModItems.JRAW_COPPER_PICKAXE.get(), title("jraw_copper_set"), desc("jraw_copper_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_COPPER_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_COPPER_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_COPPER_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_COPPER_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_COPPER_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("jraw_copper_set"));

            // Raw Iron → Jagged Raw Iron tools → full set
            AdvancementHolder jrawIron = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.JRAW_IRON_SWORD.get(), title("jraw_iron"), desc("jraw_iron"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_jraw_iron_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_IRON_SWORD.get()))
                    .save(saver, id("jraw_iron"));

            Advancement.Builder.advancement()
                    .parent(jrawIron)
                    .display(ModItems.JRAW_IRON_PICKAXE.get(), title("jraw_iron_set"), desc("jraw_iron_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_IRON_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_IRON_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_IRON_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_IRON_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_IRON_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("jraw_iron_set"));

            // Raw Ferrous Gold → Jagged Raw Ferrous Gold tools → full set
            AdvancementHolder jrawRgold = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.JRAW_RGOLD_SWORD.get(), title("jraw_rgold"), desc("jraw_rgold"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_jraw_rgold_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_RGOLD_SWORD.get()))
                    .save(saver, id("jraw_rgold"));

            Advancement.Builder.advancement()
                    .parent(jrawRgold)
                    .display(ModItems.JRAW_RGOLD_PICKAXE.get(), title("jraw_rgold_set"), desc("jraw_rgold_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_RGOLD_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_RGOLD_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_RGOLD_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_RGOLD_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JRAW_RGOLD_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("jraw_rgold_set"));

            // Netherite Scrap → Jagged Scrap tools → full set
            AdvancementHolder jscrap = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.JSCRAP_SWORD.get(), title("jscrap"), desc("jscrap"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_jscrap_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JSCRAP_SWORD.get()))
                    .save(saver, id("jscrap"));

            Advancement.Builder.advancement()
                    .parent(jscrap)
                    .display(ModItems.JSCRAP_PICKAXE.get(), title("jscrap_set"), desc("jscrap_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JSCRAP_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JSCRAP_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JSCRAP_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JSCRAP_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JSCRAP_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("jscrap_set"));

            // ==================================================================
            // BRANCH: Crystal / element sets (all from root)
            // ==================================================================

            // Jagged Amethyst
            AdvancementHolder jamethyst = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.JAMETHYST_SWORD.get(), title("jamethyst"), desc("jamethyst"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_jamethyst_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JAMETHYST_SWORD.get()))
                    .save(saver, id("jamethyst"));

            Advancement.Builder.advancement()
                    .parent(jamethyst)
                    .display(ModItems.JAMETHYST_PICKAXE.get(), title("jamethyst_set"), desc("jamethyst_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JAMETHYST_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JAMETHYST_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JAMETHYST_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JAMETHYST_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JAMETHYST_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("jamethyst_set"));

            // Snow tools
            AdvancementHolder snowTools = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.SNOW_SWORD.get(), title("snow_tools"), desc("snow_tools"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_snow_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SNOW_SWORD.get()))
                    .save(saver, id("snow_tools"));

            Advancement.Builder.advancement()
                    .parent(snowTools)
                    .display(ModItems.SNOW_PICKAXE.get(), title("snow_set"), desc("snow_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SNOW_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SNOW_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SNOW_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SNOW_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SNOW_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("snow_set"));

            // Jagged Quartz
            AdvancementHolder jquartz = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.JQUARTZ_SWORD.get(), title("jquartz"), desc("jquartz"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_jquartz_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JQUARTZ_SWORD.get()))
                    .save(saver, id("jquartz"));

            Advancement.Builder.advancement()
                    .parent(jquartz)
                    .display(ModItems.JQUARTZ_PICKAXE.get(), title("jquartz_set"), desc("jquartz_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JQUARTZ_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JQUARTZ_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JQUARTZ_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JQUARTZ_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JQUARTZ_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("jquartz_set"));

            // Jagged Prismarine
            AdvancementHolder jprism = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.JPRISM_SWORD.get(), title("jprism"), desc("jprism"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_jprism_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JPRISM_SWORD.get()))
                    .save(saver, id("jprism"));

            Advancement.Builder.advancement()
                    .parent(jprism)
                    .display(ModItems.JPRISM_PICKAXE.get(), title("jprism_set"), desc("jprism_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JPRISM_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JPRISM_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JPRISM_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JPRISM_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JPRISM_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("jprism_set"));

            // Calcified Amethyst (smooth) — material + tools/armor
            AdvancementHolder calciteAmethyst = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.CALCIFIED_AMETHYST.get(), title("calcified_amethyst"), desc("calcified_amethyst"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_calcified_amethyst",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CALCIFIED_AMETHYST.get()))
                    .save(saver, id("calcified_amethyst"));

            AdvancementHolder camethystTools = Advancement.Builder.advancement()
                    .parent(calciteAmethyst)
                    .display(ModItems.CAMETHYST_SWORD.get(), title("camethyst_tools"), desc("camethyst_tools"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_camethyst_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CAMETHYST_SWORD.get()))
                    .save(saver, id("camethyst_tools"));

            Advancement.Builder.advancement()
                    .parent(camethystTools)
                    .display(ModItems.CAMETHYST_HELMET.get(), title("camethyst_set"), desc("camethyst_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CAMETHYST_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CAMETHYST_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CAMETHYST_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CAMETHYST_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CAMETHYST_HOE.get()))
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CAMETHYST_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CAMETHYST_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CAMETHYST_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CAMETHYST_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("camethyst_set"));

            // Ice / Glacial (smooth) — material + tools/armor
            AdvancementHolder glacialShard = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.GLACIAL_SHARD.get(), title("glacial_shard"), desc("glacial_shard"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_glacial_shard",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GLACIAL_SHARD.get()))
                    .save(saver, id("glacial_shard"));

            AdvancementHolder iceTools = Advancement.Builder.advancement()
                    .parent(glacialShard)
                    .display(ModItems.ICE_SWORD.get(), title("ice_tools"), desc("ice_tools"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_ice_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ICE_SWORD.get()))
                    .save(saver, id("ice_tools"));

            Advancement.Builder.advancement()
                    .parent(iceTools)
                    .display(ModItems.ICE_HELMET.get(), title("ice_set"), desc("ice_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ICE_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ICE_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ICE_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ICE_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ICE_HOE.get()))
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ICE_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ICE_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ICE_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ICE_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("ice_set"));

            // Smooth Quartz — material + tools/armor
            AdvancementHolder polishedQuartz = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.POLISHED_QUARTZ.get(), title("polished_quartz"), desc("polished_quartz"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_polished_quartz",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.POLISHED_QUARTZ.get()))
                    .save(saver, id("polished_quartz"));

            AdvancementHolder squartzTools = Advancement.Builder.advancement()
                    .parent(polishedQuartz)
                    .display(ModItems.SQUARTZ_SWORD.get(), title("squartz_tools"), desc("squartz_tools"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_squartz_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SQUARTZ_SWORD.get()))
                    .save(saver, id("squartz_tools"));

            Advancement.Builder.advancement()
                    .parent(squartzTools)
                    .display(ModItems.SQUARTZ_HELMET.get(), title("squartz_set"), desc("squartz_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SQUARTZ_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SQUARTZ_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SQUARTZ_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SQUARTZ_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SQUARTZ_HOE.get()))
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SQUARTZ_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SQUARTZ_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SQUARTZ_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SQUARTZ_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("squartz_set"));

            // Smooth Prismarine — material + tools/armor
            AdvancementHolder polishedPrismarine = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.POLISHED_PRISMARINE.get(), title("polished_prismarine"), desc("polished_prismarine"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_polished_prismarine",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.POLISHED_PRISMARINE.get()))
                    .save(saver, id("polished_prismarine"));

            AdvancementHolder sprismTools = Advancement.Builder.advancement()
                    .parent(polishedPrismarine)
                    .display(ModItems.SPRISM_SWORD.get(), title("sprism_tools"), desc("sprism_tools"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_sprism_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPRISM_SWORD.get()))
                    .save(saver, id("sprism_tools"));

            Advancement.Builder.advancement()
                    .parent(sprismTools)
                    .display(ModItems.SPRISM_HELMET.get(), title("sprism_set"), desc("sprism_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPRISM_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPRISM_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPRISM_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPRISM_AXE.get()))
                    .addCriterion("has_hoe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPRISM_HOE.get()))
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPRISM_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPRISM_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPRISM_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SPRISM_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("sprism_set"));

            // ==================================================================
            // BRANCH: Overpower (from root) — CHALLENGE
            // ==================================================================
            AdvancementHolder overpowerSword = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.OVERPOWER_SWORD.get(), title("overpower"), desc("overpower"),
                            null, AdvancementType.CHALLENGE, true, true, false)
                    .addCriterion("has_overpower_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OVERPOWER_SWORD.get()))
                    .save(saver, id("overpower"));

            // Full Overpower set (GOAL)
            Advancement.Builder.advancement()
                    .parent(overpowerSword)
                    .display(ModItems.OVERPOWER_HELMET.get(), title("overpower_set"), desc("overpower_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OVERPOWER_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OVERPOWER_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OVERPOWER_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OVERPOWER_AXE.get()))
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OVERPOWER_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OVERPOWER_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OVERPOWER_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OVERPOWER_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("overpower_set"));

            // ==================================================================
            // BRANCH: Flint / FNI (from root)
            // ==================================================================
            AdvancementHolder jflintSword = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.JFLINT_SWORD.get(), title("jflint"), desc("jflint"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_jflint_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.JFLINT_SWORD.get()))
                    .save(saver, id("jflint"));

            AdvancementHolder fniSword = Advancement.Builder.advancement()
                    .parent(jflintSword)
                    .display(ModItems.FNI_SWORD.get(), title("fni_tools"), desc("fni_tools"),
                            null, AdvancementType.TASK, true, true, false)
                    .addCriterion("has_fni_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FNI_SWORD.get()))
                    .save(saver, id("fni_tools"));

            Advancement.Builder.advancement()
                    .parent(fniSword)
                    .display(ModItems.FNI_BOOTS.get(), title("fni_set"), desc("fni_set"),
                            null, AdvancementType.GOAL, true, true, false)
                    .addCriterion("has_sword",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FNI_SWORD.get()))
                    .addCriterion("has_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FNI_PICKAXE.get()))
                    .addCriterion("has_shovel",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FNI_SHOVEL.get()))
                    .addCriterion("has_axe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FNI_AXE.get()))
                    .addCriterion("has_helmet",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FNI_HELMET.get()))
                    .addCriterion("has_chestplate",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FNI_CHESTPLATE.get()))
                    .addCriterion("has_leggings",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FNI_LEGGINGS.get()))
                    .addCriterion("has_boots",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FNI_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("fni_set"));

            // ==================================================================
            // BRANCH: Stone Toolkit (from root) — CHALLENGE
            // Collect a pickaxe crafted from every rock variant
            // ==================================================================
            Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.GRANITE_PICKAXE.get(), title("stone_toolkit"), desc("stone_toolkit"),
                            null, AdvancementType.CHALLENGE, true, true, false)
                    .addCriterion("has_andesite_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ANDESITE_PICKAXE.get()))
                    .addCriterion("has_basalt_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BASALT_PICKAXE.get()))
                    .addCriterion("has_blackstone_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BLACKSTONE_PICKAXE.get()))
                    .addCriterion("has_calcite_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CALCITE_PICKAXE.get()))
                    .addCriterion("has_deepslate_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DEEPSLATE_PICKAXE.get()))
                    .addCriterion("has_diorite_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DIORITE_PICKAXE.get()))
                    .addCriterion("has_end_stone_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.END_STONE_PICKAXE.get()))
                    .addCriterion("has_granite_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GRANITE_PICKAXE.get()))
                    .addCriterion("has_netherrack_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERRACK_PICKAXE.get()))
                    .addCriterion("has_sandstone_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SANDSTONE_PICKAXE.get()))
                    .addCriterion("has_smooth_basalt_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SMOOTH_BASALT_PICKAXE.get()))
                    .addCriterion("has_terracotta_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TERRACOTTA_PICKAXE.get()))
                    .addCriterion("has_tuff_pickaxe",
                            InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TUFF_PICKAXE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(saver, id("stone_toolkit"));
        }

        // -----------------------------------------------------------------------
        // Helpers
        // -----------------------------------------------------------------------

        private static String id(String path) {
            return UsefultoolsMod.MOD_ID + ":" + path;
        }

        private static Component title(String key) {
            return Component.translatable("advancements." + UsefultoolsMod.MOD_ID + "." + key + ".title");
        }

        private static Component desc(String key) {
            return Component.translatable("advancements." + UsefultoolsMod.MOD_ID + "." + key + ".description");
        }
    }
}
