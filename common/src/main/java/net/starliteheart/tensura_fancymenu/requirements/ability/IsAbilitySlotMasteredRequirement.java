package net.starliteheart.tensura_fancymenu.requirements.ability;

import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.utils.AbilitySlotUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class IsAbilitySlotMasteredRequirement extends AbstractAbilitySlotRequirement {
    public IsAbilitySlotMasteredRequirement() {super("is_ability_slot_mastered");}

    @Override
    public boolean isAbilityRequirementMet(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                           @NotNull AbilitySlot abilitySlot) {
        Optional<ManasSkillInstance> optional = AbilitySlotUtils.getAbilitySkillInstanceFrom(player, abilitySlot);
        return optional.map(instance -> instance.getMastery() >= instance.getMaxMastery()).orElse(false);
    }
}
