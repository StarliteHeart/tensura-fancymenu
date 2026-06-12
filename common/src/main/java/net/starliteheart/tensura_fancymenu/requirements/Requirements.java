package net.starliteheart.tensura_fancymenu.requirements;

import de.keksuccino.fancymenu.customization.requirement.Requirement;
import de.keksuccino.fancymenu.customization.requirement.RequirementRegistry;

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
    public static final IsAbilitySlotFilledRequirement IS_ABILITY_SLOT_FILLED = register(new IsAbilitySlotFilledRequirement());
    public static final IsAbilitySlotLearnedRequirement IS_ABILITY_SLOT_LEARNED = register(new IsAbilitySlotLearnedRequirement());
    public static final IsAbilitySlotMasteredRequirement IS_ABILITY_SLOT_MASTERED = register(new IsAbilitySlotMasteredRequirement());
    public static final IsAbilitySlotOnCooldownRequirement IS_ABILITY_SLOT_ON_COOLDOWN = register(new IsAbilitySlotOnCooldownRequirement());

}
