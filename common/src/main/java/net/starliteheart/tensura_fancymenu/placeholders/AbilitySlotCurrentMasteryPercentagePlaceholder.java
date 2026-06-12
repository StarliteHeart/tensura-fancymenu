package net.starliteheart.tensura_fancymenu.placeholders;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class AbilitySlotCurrentMasteryPercentagePlaceholder extends AbstractAbilitySlotPlaceholder {
    public AbilitySlotCurrentMasteryPercentagePlaceholder() {
        super("ability_slot_current_mastery_percent");
    }

    @Override
    protected String getAbilityValue(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                     @NotNull AbilitySlot ability, @NotNull ManasSkill skill,
                                     @NotNull ManasSkillInstance instance) {
        double current = Math.max(0, instance.getMastery());
        int max = instance.getMaxMastery();
        return String.valueOf((int) (current / max * 100.0F));
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.ability_slot_current_mastery_percent";
    }
}