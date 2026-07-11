package net.starliteheart.tensura_fancymenu.placeholders.ability;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.tensura.ability.TensuraSkill;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class AbilitySlotModeIndexPlaceholder extends AbstractTensuraAbilitySlotPlaceholder {
    public AbilitySlotModeIndexPlaceholder() {
        super("ability_slot_mode_index");
    }

    @Override
    protected String getAbilitySlotString(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                          @NotNull AbilitySlot abilitySlot) {
        ManasSkill skill = abilitySlot.getSkill();
        return (skill instanceof TensuraSkill tensuraSkill && tensuraSkill.getColoredName() != null)
                ? String.valueOf(abilitySlot.getMode())
                : this.getReplacementFallback();
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}