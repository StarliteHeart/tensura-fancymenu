package net.starliteheart.tensura_fancymenu.neoforge.datagen.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.starliteheart.tensura_fancymenu.TensuraFancyMenuCompat;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import net.starliteheart.tensura_fancymenu.placeholders.Placeholders;
import net.starliteheart.tensura_fancymenu.requirements.AbstractTensuraRequirement;
import net.starliteheart.tensura_fancymenu.requirements.Requirements;
import org.jetbrains.annotations.Nullable;

public class EnUsLanguageProvider extends LanguageProvider {
    public EnUsLanguageProvider(PackOutput output) {
        super(output, TensuraFancyMenuCompat.MOD_ID, "en_us");
    }

    private String appendSuffix(String str) {
        return String.format("%s §z[TR]§r", str);
    }

    private void addPlaceholderLanguage(AbstractTensuraPlaceholder placeholder, String displayName,
                                        @Nullable String description) {
        add(placeholder.getDisplayNameLocalization(), displayName);
        if (description != null) {
            add(placeholder.getDescriptionLocalization(), description);
        }
    }

    private void addRequirementLanguage(AbstractTensuraRequirement placeholder, String displayName,
                                        @Nullable String description) {
        add(placeholder.getDisplayNameLocalization(), displayName);
        if (description != null) {
            add(placeholder.getDescriptionLocalization(), description);
        }
    }

    @Override
    protected void addTranslations() {
        // Categories Language
        add("tensura_fancymenu.placeholders.categories.world.tensura", appendSuffix("World"));
        add("tensura_fancymenu.requirements.categories.world.tensura", appendSuffix("World"));

        // Placeholders Language
        addPlaceholderLanguage(Placeholders.ABILITY_ACTIVE_PRESET, appendSuffix("Ability Active Preset"),
                               "Returns the number of the currently active ability preset.\nReturns an empty string when not in a world.");
        addPlaceholderLanguage(Placeholders.ABILITY_SLOT_SKILL_NAME, appendSuffix("Ability Slot Skill Name"),
                               "Returns the name of the skill assigned to the selected ability slot.\nReturns an empty string when not in a world or no skill is assigned to that slot.");
        addPlaceholderLanguage(Placeholders.ABILITY_SLOT_SKILL_ICON, appendSuffix("Ability Slot Skill Icon"),
                               "Returns the icon for the skill assigned to the selected ability slot as a Resource Location string.\nReturns an empty string when not in a world or no skill is assigned to that slot.");
        addPlaceholderLanguage(Placeholders.ABILITY_SLOT_MODE_NAME, appendSuffix("Ability Slot Mode Name"),
                               "Returns the name of the current mode of the skill assigned to the selected ability slot.\nReturns an empty string when not in a world or no skill is assigned to that slot.");
        addPlaceholderLanguage(Placeholders.ABILITY_SLOT_MODE_INDEX, appendSuffix("Ability Slot Mode Index"),
                               "Returns the index of the current mode of the skill assigned to the selected ability slot.\nReturns '0' when not in a world or no skill is assigned to that slot.");
        addPlaceholderLanguage(Placeholders.ABILITY_SLOT_COOLDOWN, appendSuffix("Ability Slot Cooldown"),
                               "Returns the current cooldown of the current mode of the skill assigned to the selected ability slot.\nReturns '0' when not in a world or no skill is assigned to that slot.");
        addPlaceholderLanguage(Placeholders.ABILITY_SLOT_CURRENT_LEARNING,
                               appendSuffix("Ability Slot Current Learning"),
                               "Returns the current learning points of the skill assigned to the selected ability slot.\nReturns '0.0' when not in a world or no skill is assigned to that slot.");
        addPlaceholderLanguage(Placeholders.ABILITY_SLOT_MAX_LEARNING, appendSuffix("Ability Slot Max Learning"),
                               "Returns the the amount of learning points required to learn the skill assigned to the selected ability slot.\nReturns '0' when not in a world or no skill is assigned to that slot.");
        addPlaceholderLanguage(Placeholders.ABILITY_SLOT_CURRENT_LEARNING_PERCENT,
                               appendSuffix("Ability Slot Current Learning Percent"),
                               "Returns the current learning points of the skill assigned to the selected ability slot in percent.\nReturns '0' when not in a world or no skill is assigned to that slot.\nPossible Values: 0-100");
        addPlaceholderLanguage(Placeholders.ABILITY_SLOT_CURRENT_MASTERY, appendSuffix("Ability Slot Current Mastery"),
                               "Returns the current mastery points of the skill assigned to the selected ability slot.\nReturns '0.0' when not in a world, no skill is assigned to that slot or the skill has not yet been learned.");
        addPlaceholderLanguage(Placeholders.ABILITY_SLOT_MAX_MASTERY, appendSuffix("Ability Slot Max Mastery"),
                               "Returns the amount of mastery points required to master the skill assigned to the selected ability slot.\nReturns '0' when not in a world or no skill is assigned to that slot.");
        addPlaceholderLanguage(Placeholders.ABILITY_SLOT_CURRENT_MASTERY_PERCENT,
                               appendSuffix("Ability Slot Current Mastery Percent"),
                               "Returns the current mastery points of the skill assigned to the selected ability slot in percent.\nReturns '0' when not in a world, no skill is assigned to that slot or the skill has not yet been learned.\nPossible Values: 0-100");

        addPlaceholderLanguage(Placeholders.PLAYER_RACE_NAME, appendSuffix("Player Race Name"),
                               "Returns the name of the player's current race.\nReturns an empty string when not in a world or the player does not currently have a race selected.");
        addPlaceholderLanguage(Placeholders.PLAYER_TRACKED_EVOLUTION_NAME,
                               appendSuffix("Ability Slot Current Mastery Percent"),
                               "Returns the name of the player's currently tracked evolution.\nReturns an empty string when not in a world or the player does not have a next evolution selected for tracking.");
        addPlaceholderLanguage(Placeholders.CURRENT_PLAYER_EVOLUTION_PROGRESS_PERCENT,
                               appendSuffix("Current Player Evolution Progress Percent"),
                               "Returns the current progress toward the player's currently tracked evolution in percent.\nReturns '0' when not in a world or the player does not have a next evolution selected for tracking.\nPossible Values: 0-100");
        addPlaceholderLanguage(Placeholders.PLAYER_ANALYSIS_MODE, appendSuffix("Player Analysis Mode Level"),
                               "Returns the player's current level of Analysis.\nReturns '0' when not in a world.");
        addPlaceholderLanguage(Placeholders.PLAYER_PRESENCE_SENSE, appendSuffix("Player Presence Sense Level"),
                               "Returns the player's current level of Presence Sense.\nReturns '0' when not in a world.");
        addPlaceholderLanguage(Placeholders.PLAYER_DODGE_COOLDOWN, appendSuffix("Player Dodge Cooldown"),
                               "Returns the player's current dodge cooldown.\nReturns '0' when not in a world.");

        addPlaceholderLanguage(Placeholders.CURRENT_PLAYER_SPIRITUAL_HEALTH,
                               appendSuffix("Current Player Spiritual Health"),
                               "Returns the current spiritual health of the player.\nReturns '0.0' when not in a world.");
        addPlaceholderLanguage(Placeholders.MAX_PLAYER_SPIRITUAL_HEALTH, appendSuffix("Max Player Spiritual Health"),
                               "Returns the max spiritual health of the player.\nReturns '0.0' when not in a world.");
        addPlaceholderLanguage(Placeholders.CURRENT_PLAYER_SPIRITUAL_HEALTH_PERCENT,
                               appendSuffix("Current Player Spiritual Health Percent"),
                               "Returns the current spiritual health of the player in percent.\nReturns '0' when not in a world.\nPossible Values: 0-100");
        addPlaceholderLanguage(Placeholders.CURRENT_MOUNT_SPIRITUAL_HEALTH,
                               appendSuffix("Current Mount Spiritual Health"),
                               "Returns the current spiritual health of the player's mount.\nReturns '0.0' when not in a world or not riding an entity with health.");
        addPlaceholderLanguage(Placeholders.MAX_MOUNT_SPIRITUAL_HEALTH, appendSuffix("Max Mount Spiritual Health"),
                               "Returns the max spiritual health of the player's mount.\nReturns '0.0' when not in a world or not riding an entity with health.");
        addPlaceholderLanguage(Placeholders.CURRENT_MOUNT_SPIRITUAL_HEALTH_PERCENT,
                               appendSuffix("Current Mount Spiritual Health Percent"),
                               "Returns the current spiritual health of the player's mount in percent.\nReturns '0' when not in a world or not riding an entity with health.\nPossible Values: 0-100");
        addPlaceholderLanguage(Placeholders.CURRENT_PLAYER_SEVERANCE, appendSuffix("Current Player Severance"),
                               "Returns the current health severance of the player.\nReturns '0.0' when not in a world.");
        addPlaceholderLanguage(Placeholders.CURRENT_PLAYER_SEVERANCE_PERCENT,
                               appendSuffix("Current Player Severance Percent"),
                               "Returns the current health severance of the player in percent.\nReturns '0' when not in a world.\nPossible Values: 0-100");
        addPlaceholderLanguage(Placeholders.PLAYER_MULTILAYER_BARRIER, appendSuffix("Player Multilayer Barrier"),
                               "Returns the player's current amount of multilayer barrier.\nReturns '0.0' when not in a world.");

        addPlaceholderLanguage(Placeholders.CURRENT_PLAYER_MAGICULE, appendSuffix("Current Player Magicules"),
                               "Returns the current magicules of the player.\nReturns '0.0' when not in a world.");
        addPlaceholderLanguage(Placeholders.MAX_PLAYER_MAGICULE, appendSuffix("Max Player Magicules"),
                               "Returns the max magicules of the player.\nReturns '0.0' when not in a world.");
        addPlaceholderLanguage(Placeholders.CURRENT_PLAYER_MAGICULE_PERCENT,
                               appendSuffix("Current Player Magicules Percent"),
                               "Returns the current magicules of the player in percent.\nReturns '0' when not in a world.\nPossible Values: 0-100");
        addPlaceholderLanguage(Placeholders.CURRENT_PLAYER_AURA, appendSuffix("Current Player Aura"),
                               "Returns the current aura of the player.\nReturns '0.0' when not in a world.");
        addPlaceholderLanguage(Placeholders.MAX_PLAYER_AURA, appendSuffix("Max Player Aura"),
                               "Returns the max aura of the player.\nReturns '0.0' when not in a world.");
        addPlaceholderLanguage(Placeholders.CURRENT_PLAYER_AURA_PERCENT, appendSuffix("Current Player Aura Percent"),
                               "Returns the current aura of the player in percent.\nReturns '0' when not in a world.\nPossible Values: 0-100");
        addPlaceholderLanguage(Placeholders.CURRENT_PLAYER_EXISTENCE, appendSuffix("Current Player Existence"),
                               "Returns the current existence of the player.\nReturns '0.0' when not in a world.");
        addPlaceholderLanguage(Placeholders.MAX_PLAYER_EXISTENCE, appendSuffix("Max Player Existence"),
                               "Returns the max existence of the player.\nReturns '0.0' when not in a world.");
        addPlaceholderLanguage(Placeholders.CURRENT_PLAYER_EXISTENCE_PERCENT,
                               appendSuffix("Current Player Existence Percent"),
                               "Returns the current existence of the player in percent.\nReturns '0' when not in a world.\nPossible Values: 0-100");
        addPlaceholderLanguage(Placeholders.PLAYER_ALIGNMENT, appendSuffix("Player Alignment"),
                               "Returns the current alignment of the player.\nReturns an empty string when not in a world.");
        addPlaceholderLanguage(Placeholders.PLAYER_SOUL_POINTS, appendSuffix("Player Soul Points"),
                               "Returns the current soul points of the player.\nReturns '0' when not in a world.");

        addPlaceholderLanguage(Placeholders.AREA_MAGICULE, appendSuffix("Area Magicules"),
                               "Returns the ambient magicule levels of the player's current area.\nReturns '0.0' when not in a world.");
        addPlaceholderLanguage(Placeholders.PLAYER_MAGICULE_POISON_RESISTANCE,
                               appendSuffix("Player Magicule Poison Resistance"),
                               "Returns the player's current level of magicule poison resistance.\nReturns '0' when not in a world.");

        // Requirements Language
        addRequirementLanguage(Requirements.IS_PLAYER_DEMON_LORD_SEED, appendSuffix("Is Player Demon Lord Seed"),
                               "Returns true if the player has a Demon Lord Seed.\nReturns false when not in a world.");
        addRequirementLanguage(Requirements.IS_PLAYER_TRUE_DEMON_LORD, appendSuffix("Is Player Demon Lord Seed"),
                               "Returns true if the player has awoken as a True Demon Lord.\nReturns false when not in a world.");
        addRequirementLanguage(Requirements.IS_PLAYER_HERO_EGG, appendSuffix("Is Player Demon Lord Seed"),
                               "Returns true if the player has a Hero Egg.\nReturns false when not in a world.");
        addRequirementLanguage(Requirements.IS_PLAYER_TRUE_HERO, appendSuffix("Is Player Demon Lord Seed"),
                               "Returns true if the player has awoken as a True Hero.\nReturns false when not in a world.");
        addRequirementLanguage(Requirements.IS_PLAYER_IN_SPIRITUAL_FORM, appendSuffix("Is Player Demon Lord Seed"),
                               "Returns true if the player is currently in Spiritual Form.\nReturns false when not in a world.");

        addRequirementLanguage(Requirements.IS_ABILITY_SLOT_FILLED, appendSuffix("Is Ability Slot Filled"),
                               "Returns true if there is a skill assigned to the selected ability slot.\nReturns false when not in a world.");
        addRequirementLanguage(Requirements.IS_ABILITY_SLOT_LEARNED, appendSuffix("Is Ability Slot Learned"),
                               "Returns true if the skill assigned to the selected ability slot has been fully learned.\nReturns false when not in a world or no skill is assigned to that slot.");
        addRequirementLanguage(Requirements.IS_ABILITY_SLOT_MASTERED, appendSuffix("Is Ability Slot Mastered"),
                               "Returns true if the skill assigned to the selected ability slot has been fully mastered.\nReturns false when not in a world, no skill is assigned to that slot or the skill has not yet been learned.");
        addRequirementLanguage(Requirements.IS_ABILITY_SLOT_ON_COOLDOWN, appendSuffix("Is Ability Slot On Cooldown"),
                               "Returns true if the skill assigned to the selected ability slot, in its current mode, is currently on cooldown.\nReturns false when not in a world or no skill is assigned to that slot.");

        add("tensura_fancymenu.requirements.world.tensura.ability_slot.value_name", "Slot Number");
    }
}
