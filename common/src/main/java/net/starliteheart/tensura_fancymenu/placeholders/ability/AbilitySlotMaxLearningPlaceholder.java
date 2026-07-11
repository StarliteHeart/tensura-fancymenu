package net.starliteheart.tensura_fancymenu.placeholders.ability;

import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

import static net.starliteheart.tensura_fancymenu.utils.AbilitySlotUtils.getSkillMaxLearning;

public class AbilitySlotMaxLearningPlaceholder extends AbstractTensuraAbilitySlotPlaceholder {
    public AbilitySlotMaxLearningPlaceholder() {super("ability_slot_max_learning");}

    @Override
    protected String getAbilitySlotString(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                          @NotNull AbilitySlot abilitySlot) {
        return String.valueOf(getSkillMaxLearning(abilitySlot.getSkill()));
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}