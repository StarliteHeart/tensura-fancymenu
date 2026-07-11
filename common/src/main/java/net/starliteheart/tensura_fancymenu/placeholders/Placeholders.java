package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.Placeholder;
import de.keksuccino.fancymenu.customization.placeholder.PlaceholderRegistry;
import net.starliteheart.tensura_fancymenu.placeholders.ability.*;
import net.starliteheart.tensura_fancymenu.placeholders.existence.*;
import net.starliteheart.tensura_fancymenu.placeholders.health.*;
import net.starliteheart.tensura_fancymenu.placeholders.misc.AreaMagiculePlaceholder;
import net.starliteheart.tensura_fancymenu.placeholders.misc.PlayerMagiculePoisonResistancePlaceholder;
import net.starliteheart.tensura_fancymenu.placeholders.player.*;

import java.util.LinkedList;
import java.util.List;

public class Placeholders {
    private static final List<Placeholder> placeholders = new LinkedList<>();

    private static <T extends Placeholder> T register(T placeholder) {
        placeholders.add(placeholder);
        return placeholder;
    }

    public static void registerAll() {
        placeholders.forEach(PlaceholderRegistry::register);
    }

    // Registered Placeholders
    public static final CurrentPlayerSpiritualHealthPlaceholder CURRENT_PLAYER_SPIRITUAL_HEALTH = register(
            new CurrentPlayerSpiritualHealthPlaceholder());
    public static final MaxPlayerSpiritualHealthPlaceholder MAX_PLAYER_SPIRITUAL_HEALTH = register(
            new MaxPlayerSpiritualHealthPlaceholder());
    public static final CurrentPlayerSpiritualHealthPercentagePlaceholder CURRENT_PLAYER_SPIRITUAL_HEALTH_PERCENT = register(
            new CurrentPlayerSpiritualHealthPercentagePlaceholder());

    public static final CurrentMountSpiritualHealthPlaceholder CURRENT_MOUNT_SPIRITUAL_HEALTH = register(
            new CurrentMountSpiritualHealthPlaceholder());
    public static final MaxMountSpiritualHealthPlaceholder MAX_MOUNT_SPIRITUAL_HEALTH = register(
            new MaxMountSpiritualHealthPlaceholder());
    public static final CurrentMountSpiritualHealthPercentagePlaceholder CURRENT_MOUNT_SPIRITUAL_HEALTH_PERCENT = register(
            new CurrentMountSpiritualHealthPercentagePlaceholder());

    public static final CurrentPlayerSeverancePlaceholder CURRENT_PLAYER_SEVERANCE = register(
            new CurrentPlayerSeverancePlaceholder());
    public static final CurrentPlayerSeverancePercentagePlaceholder CURRENT_PLAYER_SEVERANCE_PERCENT = register(
            new CurrentPlayerSeverancePercentagePlaceholder());
    public static final PlayerMultilayerBarrierPlaceholder PLAYER_MULTILAYER_BARRIER = register(
            new PlayerMultilayerBarrierPlaceholder());

    public static final CurrentPlayerMagiculePlaceholder CURRENT_PLAYER_MAGICULE = register(
            new CurrentPlayerMagiculePlaceholder());
    public static final MaxPlayerMagiculePlaceholder MAX_PLAYER_MAGICULE = register(new MaxPlayerMagiculePlaceholder());
    public static final CurrentPlayerMagiculePercentagePlaceholder CURRENT_PLAYER_MAGICULE_PERCENT = register(
            new CurrentPlayerMagiculePercentagePlaceholder());

    public static final CurrentPlayerAuraPlaceholder CURRENT_PLAYER_AURA = register(new CurrentPlayerAuraPlaceholder());
    public static final MaxPlayerAuraPlaceholder MAX_PLAYER_AURA = register(new MaxPlayerAuraPlaceholder());
    public static final CurrentPlayerAuraPercentagePlaceholder CURRENT_PLAYER_AURA_PERCENT = register(
            new CurrentPlayerAuraPercentagePlaceholder());

    public static final CurrentPlayerExistencePlaceholder CURRENT_PLAYER_EXISTENCE = register(
            new CurrentPlayerExistencePlaceholder());
    public static final MaxPlayerExistencePlaceholder MAX_PLAYER_EXISTENCE = register(
            new MaxPlayerExistencePlaceholder());
    public static final CurrentPlayerExistencePercentagePlaceholder CURRENT_PLAYER_EXISTENCE_PERCENT = register(
            new CurrentPlayerExistencePercentagePlaceholder());

    public static final PlayerAlignmentPlaceholder PLAYER_ALIGNMENT = register(new PlayerAlignmentPlaceholder());
    public static final PlayerSoulPointsPlaceholder PLAYER_SOUL_POINTS = register(new PlayerSoulPointsPlaceholder());

    public static final PlayerRaceNamePlaceholder PLAYER_RACE_NAME = register(new PlayerRaceNamePlaceholder());
    public static final PlayerTrackedEvolutionNamePlaceholder PLAYER_TRACKED_EVOLUTION_NAME = register(
            new PlayerTrackedEvolutionNamePlaceholder());
    public static final CurrentPlayerEvolutionProgressPercentPlaceholder CURRENT_PLAYER_EVOLUTION_PROGRESS_PERCENT = register(
            new CurrentPlayerEvolutionProgressPercentPlaceholder());
    public static final PlayerAnalysisModePlaceholder PLAYER_ANALYSIS_MODE = register(
            new PlayerAnalysisModePlaceholder());
    public static final PlayerPresenceSensePlaceholder PLAYER_PRESENCE_SENSE = register(
            new PlayerPresenceSensePlaceholder());
    public static final PlayerDodgeCooldownPlaceholder PLAYER_DODGE_COOLDOWN = register(
            new PlayerDodgeCooldownPlaceholder());

    public static final AbilityActivePresetPlaceholder ABILITY_ACTIVE_PRESET = register(
            new AbilityActivePresetPlaceholder());
    public static final AbilitySlotSkillNamePlaceholder ABILITY_SLOT_SKILL_NAME = register(
            new AbilitySlotSkillNamePlaceholder());
    public static final AbilitySlotSkillIconPlaceholder ABILITY_SLOT_SKILL_ICON = register(
            new AbilitySlotSkillIconPlaceholder());
    public static final AbilitySlotModeNamePlaceholder ABILITY_SLOT_MODE_NAME = register(
            new AbilitySlotModeNamePlaceholder());
    public static final AbilitySlotModeIndexPlaceholder ABILITY_SLOT_MODE_INDEX = register(
            new AbilitySlotModeIndexPlaceholder());
    public static final AbilitySlotCooldownPlaceholder ABILITY_SLOT_COOLDOWN = register(
            new AbilitySlotCooldownPlaceholder());

    public static final AbilitySlotCurrentLearningPlaceholder ABILITY_SLOT_CURRENT_LEARNING = register(
            new AbilitySlotCurrentLearningPlaceholder());
    public static final AbilitySlotMaxLearningPlaceholder ABILITY_SLOT_MAX_LEARNING = register(
            new AbilitySlotMaxLearningPlaceholder());
    public static final AbilitySlotCurrentLearningPercentagePlaceholder ABILITY_SLOT_CURRENT_LEARNING_PERCENT = register(
            new AbilitySlotCurrentLearningPercentagePlaceholder());

    public static final AbilitySlotCurrentMasteryPlaceholder ABILITY_SLOT_CURRENT_MASTERY = register(
            new AbilitySlotCurrentMasteryPlaceholder());
    public static final AbilitySlotMaxMasteryPlaceholder ABILITY_SLOT_MAX_MASTERY = register(
            new AbilitySlotMaxMasteryPlaceholder());
    public static final AbilitySlotCurrentMasteryPercentagePlaceholder ABILITY_SLOT_CURRENT_MASTERY_PERCENT = register(
            new AbilitySlotCurrentMasteryPercentagePlaceholder());

    public static final AreaMagiculePlaceholder AREA_MAGICULE = register(new AreaMagiculePlaceholder());
    public static final PlayerMagiculePoisonResistancePlaceholder PLAYER_MAGICULE_POISON_RESISTANCE = register(
            new PlayerMagiculePoisonResistancePlaceholder());
}
