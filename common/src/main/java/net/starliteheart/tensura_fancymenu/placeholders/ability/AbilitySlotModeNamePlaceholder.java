package net.starliteheart.tensura_fancymenu.placeholders.ability;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.TensuraSkill;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.starliteheart.tensura_fancymenu.utils.AbilitySlotUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class AbilitySlotModeNamePlaceholder extends AbstractTensuraAbilitySlotPlaceholder {
    public AbilitySlotModeNamePlaceholder() {
        super("ability_slot_mode_name");
    }

    @Override
    protected String getAbilitySlotString(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                          @NotNull AbilitySlot abilitySlot) {
        ManasSkill skill = abilitySlot.getSkill();
        if (skill instanceof TensuraSkill tensuraSkill) {
            Optional<ManasSkillInstance> optional = AbilitySlotUtils.getAbilitySkillInstanceFrom(player, skill);
            return optional.map(instance ->
                                        tensuraSkill.getModeName(instance, abilitySlot.getMode()).getString())
                           .orElseGet(this::getReplacementFallback);
        }
        return this.getReplacementFallback();
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return Component.translatable("tensura.skill.empty").getString();
    }
}