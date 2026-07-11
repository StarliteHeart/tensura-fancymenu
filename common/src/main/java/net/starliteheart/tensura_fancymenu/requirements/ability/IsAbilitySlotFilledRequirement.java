package net.starliteheart.tensura_fancymenu.requirements.ability;

import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class IsAbilitySlotFilledRequirement extends AbstractAbilitySlotRequirement {
    public IsAbilitySlotFilledRequirement() {super("is_ability_slot_filled");}

    @Override
    public boolean isAbilityRequirementMet(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                           @NotNull AbilitySlot abilitySlot) {
        return abilitySlot.getSkill() != null;
    }
}
