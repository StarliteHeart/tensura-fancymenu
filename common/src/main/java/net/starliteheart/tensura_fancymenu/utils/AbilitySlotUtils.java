package net.starliteheart.tensura_fancymenu.utils;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.tensura.ability.skill.resist.ResistSkill;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.player.LocalPlayer;

import java.util.Optional;

public class AbilitySlotUtils {
    public static Optional<ManasSkillInstance> getAbilitySkillInstanceFrom(LocalPlayer player, ManasSkill skill) {
        return skill != null ? SkillAPI.getSkillsFrom(player).getSkill(skill) : Optional.empty();
    }

    public static Optional<ManasSkillInstance> getAbilitySkillInstanceFrom(LocalPlayer player,
                                                                           AbilitySlot abilitySlot) {
        return getAbilitySkillInstanceFrom(player, abilitySlot.getSkill());
    }

    public static int getSkillMaxLearning(ManasSkill skill) {
        return (skill instanceof ResistSkill resistSkill) ? resistSkill.getLearningPointRequirement() : 100;
    }
}
