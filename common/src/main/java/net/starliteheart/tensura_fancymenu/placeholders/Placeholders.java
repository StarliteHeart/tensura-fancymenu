package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.Placeholder;
import de.keksuccino.fancymenu.customization.placeholder.PlaceholderRegistry;

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
    public static final CurrentSpiritualHealthPlaceholder CURRENT_SPIRITUAL_HEALTH = register(new CurrentSpiritualHealthPlaceholder());
    public static final MaxSpiritualHealthPlaceholder MAX_SPIRITUAL_HEALTH = register(new MaxSpiritualHealthPlaceholder());
    public static final CurrentSpiritualHealthPercentagePlaceholder CURRENT_SPIRITUAL_HEALTH_PERCENT = register(new CurrentSpiritualHealthPercentagePlaceholder());

    public static final CurrentMountSpiritualHealthPlaceholder CURRENT_MOUNT_SPIRITUAL_HEALTH = register(new CurrentMountSpiritualHealthPlaceholder());
    public static final MaxMountSpiritualHealthPlaceholder MAX_MOUNT_SPIRITUAL_HEALTH = register(new MaxMountSpiritualHealthPlaceholder());
    public static final CurrentMountSpiritualHealthPercentagePlaceholder CURRENT_MOUNT_SPIRITUAL_HEALTH_PERCENT = register(new CurrentMountSpiritualHealthPercentagePlaceholder());

    public static final CurrentMagiculePlaceholder CURRENT_MAGICULE = register(new CurrentMagiculePlaceholder());
    public static final MaxMagiculePlaceholder MAX_MAGICULE = register(new MaxMagiculePlaceholder());
    public static final CurrentMagiculePercentagePlaceholder CURRENT_MAGICULE_PERCENT = register(new CurrentMagiculePercentagePlaceholder());

    public static final CurrentAuraPlaceholder CURRENT_AURA = register(new CurrentAuraPlaceholder());
    public static final MaxAuraPlaceholder MAX_AURA = register(new MaxAuraPlaceholder());
    public static final CurrentAuraPercentagePlaceholder CURRENT_AURA_PERCENT = register(new CurrentAuraPercentagePlaceholder());

    public static final CurrentExistencePlaceholder CURRENT_EXISTENCE = register(new CurrentExistencePlaceholder());
    public static final MaxExistencePlaceholder MAX_EXISTENCE = register(new MaxExistencePlaceholder());
    public static final CurrentExistencePercentagePlaceholder CURRENT_EXISTENCE_PERCENT = register(new CurrentExistencePercentagePlaceholder());

    public static final CurrentSeverancePlaceholder CURRENT_SEVERANCE = register(new CurrentSeverancePlaceholder());
    public static final CurrentSeverancePercentagePlaceholder CURRENT_SEVERANCE_PERCENT = register(new CurrentSeverancePercentagePlaceholder());

    public static final AbilitySlotNamePlaceholder ABILITY_SLOT_NAME = register(new AbilitySlotNamePlaceholder());
    public static final AbilitySlotIconPlaceholder ABILITY_SLOT_ICON = register(new AbilitySlotIconPlaceholder());
    public static final AbilitySlotModeNamePlaceholder ABILITY_SLOT_MODE_NAME = register(new AbilitySlotModeNamePlaceholder());
    public static final AbilitySlotModeIndexPlaceholder ABILITY_SLOT_MODE_INDEX = register(new AbilitySlotModeIndexPlaceholder());
    public static final AbilitySlotCooldownPlaceholder ABILITY_SLOT_COOLDOWN = register(new AbilitySlotCooldownPlaceholder());

    public static final AbilitySlotCurrentLearningPlaceholder ABILITY_SLOT_CURRENT_LEARNING = register(new AbilitySlotCurrentLearningPlaceholder());
    public static final AbilitySlotMaxLearningPlaceholder ABILITY_SLOT_MAX_LEARNING = register(new AbilitySlotMaxLearningPlaceholder());
    public static final AbilitySlotCurrentLearningPercentagePlaceholder ABILITY_SLOT_CURRENT_LEARNING_PERCENT = register(new AbilitySlotCurrentLearningPercentagePlaceholder());

    public static final AbilitySlotCurrentMasteryPlaceholder ABILITY_SLOT_CURRENT_MASTERY = register(new AbilitySlotCurrentMasteryPlaceholder());
    public static final AbilitySlotMaxMasteryPlaceholder ABILITY_SLOT_MAX_MASTERY = register(new AbilitySlotMaxMasteryPlaceholder());
    public static final AbilitySlotCurrentMasteryPercentagePlaceholder ABILITY_SLOT_CURRENT_MASTERY_PERCENT = register(new AbilitySlotCurrentMasteryPercentagePlaceholder());

    public static final AreaMagiculePlaceholder AREA_MAGICULE = register(new AreaMagiculePlaceholder());
    public static final MagiculePoisonResistancePlaceholder MAGICULE_POISON_RESISTANCE = register(new MagiculePoisonResistancePlaceholder());
    public static final MultilayerBarrierPlaceholder MULTILAYER_BARRIER = register(new MultilayerBarrierPlaceholder());

}
