package net.starliteheart.tensura_fancymenu.placeholders;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.skill.resist.ResistSkill;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class AbilitySlotCurrentLearningPercentagePlaceholder extends AbstractAbilitySlotPlaceholder {
    public AbilitySlotCurrentLearningPercentagePlaceholder() {
        super("ability_slot_current_learning_percent");
    }

    @Override
    protected String getAbilityValue(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                     @NotNull AbilitySlot ability, @NotNull ManasSkill skill,
                                     @NotNull ManasSkillInstance instance) {
        double mastery = instance.getMastery();
        int max = (skill instanceof ResistSkill resistSkill) ? resistSkill.getLearningPointRequirement() : 100;
        double current = (mastery < 0) ? max + mastery : max;
        return String.valueOf((int) (current / max * 100.0F));
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.ability_slot_current_learning_percent";
    }
}