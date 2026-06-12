package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldFloatPlaceholder;
import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class MaxExistencePlaceholder extends AbstractWorldFloatPlaceholder {
    public MaxExistencePlaceholder() {
        super("max_existence");
    }

    @Override
    protected float getFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (float) (EnergyHelper.getMaxMagicule(player) + EnergyHelper.getMaxAura(player));
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.max_existence";
    }
}