package net.starliteheart.tensura_fancymenu.placeholders.ability;

import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.utils.AbilitySlotUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class AbilitySlotMaxMasteryPlaceholder extends AbstractTensuraAbilitySlotPlaceholder {
    public AbilitySlotMaxMasteryPlaceholder() {
        super("ability_slot_max_mastery");
    }

    @Override
    protected String getAbilitySlotString(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                          @NotNull AbilitySlot abilitySlot) {
        Optional<ManasSkillInstance> optional = AbilitySlotUtils.getAbilitySkillInstanceFrom(player, abilitySlot);
        return optional.map(instance -> String.valueOf(instance.getMaxMastery()))
                       .orElseGet(this::getReplacementFallback);
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}