package net.starliteheart.tensura_fancymenu.placeholders;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.skill.resist.ResistSkill;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class AbilitySlotMaxLearningPlaceholder extends AbstractAbilitySlotPlaceholder {
    public AbilitySlotMaxLearningPlaceholder() { super("ability_slot_max_learning"); }

    @Override
    protected String getAbilityValue(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                     @NotNull AbilitySlot ability, @NotNull ManasSkill skill,
                                     @NotNull ManasSkillInstance instance) {
        return (skill instanceof ResistSkill resistSkill)
                ? String.valueOf(resistSkill.getLearningPointRequirement())
                : "100";
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.ability_slot_max_learning";
    }
}