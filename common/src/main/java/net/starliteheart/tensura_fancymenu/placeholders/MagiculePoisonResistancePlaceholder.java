package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldFloatPlaceholder;
import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.registry.skill.ResistanceSkills;
import io.github.manasmods.tensura.storage.Alignment;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ep.IExistence;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class MagiculePoisonResistancePlaceholder extends AbstractWorldFloatPlaceholder {
    public MagiculePoisonResistancePlaceholder() {
        super("magicule_poison_resistance");
    }

    @Override
    protected float getFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        IExistence existence = TensuraStorages.getExistenceFrom(player);
        return ((existence.getAlignment() != Alignment.DEFAULT) ? 1 : 0) +
                (SkillUtils.isSkillToggled(player, ResistanceSkills.MAGIC_RESISTANCE.get()) ? 2 : 0);
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.magicule_poison_resistance";
    }
}