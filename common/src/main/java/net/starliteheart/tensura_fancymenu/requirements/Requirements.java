package net.starliteheart.tensura_fancymenu.requirements;

import de.keksuccino.fancymenu.customization.requirement.Requirement;
import de.keksuccino.fancymenu.customization.requirement.RequirementRegistry;
import net.starliteheart.tensura_fancymenu.requirements.ability.IsAbilitySlotFilledRequirement;
import net.starliteheart.tensura_fancymenu.requirements.ability.IsAbilitySlotLearnedRequirement;
import net.starliteheart.tensura_fancymenu.requirements.ability.IsAbilitySlotMasteredRequirement;
import net.starliteheart.tensura_fancymenu.requirements.ability.IsAbilitySlotOnCooldownRequirement;
import net.starliteheart.tensura_fancymenu.requirements.existence.*;

import java.util.LinkedList;
import java.util.List;

public class Requirements {
    private static final List<Requirement> requirements = new LinkedList<>();

    private static <T extends Requirement> T register(T requirement) {
        requirements.add(requirement);
        return requirement;
    }

    public static void registerAll() {
        requirements.forEach(RequirementRegistry::register);
    }

    // Registered Placeholders
    public static final IsAbilitySlotFilledRequirement IS_ABILITY_SLOT_FILLED = register(
            new IsAbilitySlotFilledRequirement());
    public static final IsAbilitySlotLearnedRequirement IS_ABILITY_SLOT_LEARNED = register(
            new IsAbilitySlotLearnedRequirement());
    public static final IsAbilitySlotMasteredRequirement IS_ABILITY_SLOT_MASTERED = register(
            new IsAbilitySlotMasteredRequirement());
    public static final IsAbilitySlotOnCooldownRequirement IS_ABILITY_SLOT_ON_COOLDOWN = register(
            new IsAbilitySlotOnCooldownRequirement());

    public static final IsPlayerDemonLordSeedRequirement IS_PLAYER_DEMON_LORD_SEED = register(
            new IsPlayerDemonLordSeedRequirement());
    public static final IsPlayerTrueDemonLordRequirement IS_PLAYER_TRUE_DEMON_LORD = register(
            new IsPlayerTrueDemonLordRequirement());
    public static final IsPlayerHeroEggRequirement IS_PLAYER_HERO_EGG = register(new IsPlayerHeroEggRequirement());
    public static final IsPlayerTrueHeroRequirement IS_PLAYER_TRUE_HERO = register(new IsPlayerTrueHeroRequirement());
    public static final IsPlayerInSpiritualFormRequirement IS_PLAYER_IN_SPIRITUAL_FORM = register(
            new IsPlayerInSpiritualFormRequirement());
}
