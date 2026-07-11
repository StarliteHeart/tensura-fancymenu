package net.starliteheart.tensura_fancymenu.placeholders.misc;

import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.registry.skill.ResistanceSkills;
import io.github.manasmods.tensura.storage.Alignment;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ep.IExistence;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class PlayerMagiculePoisonResistancePlaceholder extends AbstractTensuraPlaceholder {
    public PlayerMagiculePoisonResistancePlaceholder() {
        super("player_magicule_poison_resistance");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        IExistence existence = TensuraStorages.getExistenceFrom(player);
        int alignmentBonus = (existence.getAlignment() != Alignment.DEFAULT) ? 1 : 0;
        int magicResistanceBonus = SkillUtils.isSkillToggled(player, ResistanceSkills.MAGIC_RESISTANCE.get()) ? 2 : 0;
        return String.valueOf(alignmentBonus + magicResistanceBonus);
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}