package net.starliteheart.tensura_fancymenu.requirements.ability;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.TensuraSkill;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.utils.AbilitySlotUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class IsAbilitySlotOnCooldownRequirement extends AbstractAbilitySlotRequirement {
    public IsAbilitySlotOnCooldownRequirement() {super("is_ability_slot_on_cooldown");}

    @Override
    public boolean isAbilityRequirementMet(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                           @NotNull AbilitySlot abilitySlot) {
        ManasSkill skill = abilitySlot.getSkill();
        Optional<ManasSkillInstance> optional = AbilitySlotUtils.getAbilitySkillInstanceFrom(player, skill);
        return optional.map(instance -> (skill instanceof TensuraSkill tensuraSkill)
                               ? tensuraSkill.shouldShowCoolDown(instance, player, abilitySlot.getMode())
                               : instance.onCoolDown(abilitySlot.getMode()) && !instance.canIgnoreCoolDown(player,
                                                                                                           abilitySlot.getMode()))
                       .orElse(false);
    }
}
