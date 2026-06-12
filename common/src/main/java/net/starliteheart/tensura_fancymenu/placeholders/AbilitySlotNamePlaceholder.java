package net.starliteheart.tensura_fancymenu.placeholders;

import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.TensuraSkill;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class AbilitySlotNamePlaceholder extends AbstractAbilitySlotPlaceholder {
    public AbilitySlotNamePlaceholder() {
        super("ability_slot_name");
    }

    @Override
    protected String getAbilityValue(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                     @NotNull AbilitySlot ability, @NotNull ManasSkill skill,
                                     @NotNull ManasSkillInstance instance) {
        return (skill instanceof TensuraSkill tensuraSkill && tensuraSkill.getColoredName() != null)
                ? tensuraSkill.getColoredName().getString()
                : Component.translatable("tensura.skill.empty").getString();
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.ability_slot_name";
    }
}