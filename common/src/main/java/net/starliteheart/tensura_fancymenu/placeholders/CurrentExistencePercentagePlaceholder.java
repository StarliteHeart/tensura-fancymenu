package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldPercentagePlaceholder;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ep.IExistence;
import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class CurrentExistencePercentagePlaceholder extends AbstractWorldPercentagePlaceholder {
    public CurrentExistencePercentagePlaceholder() {
        super("current_existence_percent");
    }

    @Override
    protected float getCurrentFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        IExistence existence = TensuraStorages.getExistenceFrom(player);
        return (float) (existence.getMagicule() + existence.getAura());
    }

    @Override
    protected float getMaxFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (float) (EnergyHelper.getMaxMagicule(player) + EnergyHelper.getMaxAura(player));
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.current_existence_percent";
    }
}