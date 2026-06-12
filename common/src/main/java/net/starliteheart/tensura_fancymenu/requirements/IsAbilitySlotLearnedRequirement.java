package net.starliteheart.tensura_fancymenu.requirements;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class IsAbilitySlotLearnedRequirement extends AbstractAbilitySlotRequirement {
    public IsAbilitySlotLearnedRequirement() { super("visibility_requirement_is_ability_slot_learned"); }

    @Override
    public boolean isAbilityRequirementMet(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                           @NotNull AbilitySlot ability, @NotNull ManasSkill skill,
                                           @NotNull ManasSkillInstance instance) {
            return instance.getMastery() >= 0;
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.requirements.world.is_ability_slot_learned";
    }
}
