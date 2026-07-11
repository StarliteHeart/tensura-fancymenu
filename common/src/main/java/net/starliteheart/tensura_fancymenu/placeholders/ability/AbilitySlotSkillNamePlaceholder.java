package net.starliteheart.tensura_fancymenu.placeholders.ability;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.tensura.ability.TensuraSkill;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class AbilitySlotSkillNamePlaceholder extends AbstractTensuraAbilitySlotPlaceholder {
    public AbilitySlotSkillNamePlaceholder() {
        super("ability_slot_skill_name");
    }

    @Override
    protected String getAbilitySlotString(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                          @NotNull AbilitySlot abilitySlot) {
        ManasSkill skill = abilitySlot.getSkill();
        return (skill instanceof TensuraSkill tensuraSkill && tensuraSkill.getColoredName() != null)
                ? tensuraSkill.getColoredName().getString()
                : this.getReplacementFallback();
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return Component.translatable("tensura.skill.empty").getString();
    }
}