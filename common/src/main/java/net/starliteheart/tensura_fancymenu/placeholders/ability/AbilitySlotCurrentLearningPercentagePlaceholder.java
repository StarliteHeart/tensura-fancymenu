package net.starliteheart.tensura_fancymenu.placeholders.ability;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.utils.AbilitySlotUtils;
import net.starliteheart.tensura_fancymenu.utils.TensuraFancyMenuUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class AbilitySlotCurrentLearningPercentagePlaceholder extends AbstractTensuraAbilitySlotPlaceholder {
    public AbilitySlotCurrentLearningPercentagePlaceholder() {
        super("ability_slot_current_learning_percent");
    }

    @Override
    protected String getAbilitySlotString(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                          @NotNull AbilitySlot abilitySlot) {
        ManasSkill skill = abilitySlot.getSkill();
        Optional<ManasSkillInstance> optional = AbilitySlotUtils.getAbilitySkillInstanceFrom(player, skill);
        return optional.map(instance -> {
                           double mastery = instance.getMastery();
                           int max = AbilitySlotUtils.getSkillMaxLearning(skill);
                           double current = (mastery < 0) ? max + mastery : max;
                           return String.valueOf((int) TensuraFancyMenuUtils.calculatePercentage(current, max));
                       })
                       .orElseGet(this::getReplacementFallback);
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}