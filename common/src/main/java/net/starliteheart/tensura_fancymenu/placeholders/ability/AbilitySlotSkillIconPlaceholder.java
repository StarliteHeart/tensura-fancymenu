package net.starliteheart.tensura_fancymenu.placeholders.ability;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class AbilitySlotSkillIconPlaceholder extends AbstractTensuraAbilitySlotPlaceholder {
    public AbilitySlotSkillIconPlaceholder() {super("ability_slot_skill_icon");}

    @Override
    protected String getAbilitySlotString(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                          @NotNull AbilitySlot abilitySlot) {
        ManasSkill skill = abilitySlot.getSkill();
        if (skill != null && skill.getSkillIcon() != null) {
            return skill.getSkillIcon().toString();
        }
        return this.getReplacementFallback();
    }
}