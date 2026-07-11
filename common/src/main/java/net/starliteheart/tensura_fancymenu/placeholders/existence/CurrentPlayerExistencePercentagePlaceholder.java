package net.starliteheart.tensura_fancymenu.placeholders.existence;

import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ep.IExistence;
import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import net.starliteheart.tensura_fancymenu.utils.TensuraFancyMenuUtils;
import org.jetbrains.annotations.NotNull;

public class CurrentPlayerExistencePercentagePlaceholder extends AbstractTensuraPlaceholder {
    public CurrentPlayerExistencePercentagePlaceholder() {
        super("current_player_existence_percent");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        IExistence existence = TensuraStorages.getExistenceFrom(player);
        double current = existence.getMagicule() + existence.getAura();
        double max = EnergyHelper.getMaxMagicule(player) + EnergyHelper.getMaxAura(player);
        return String.valueOf((int) TensuraFancyMenuUtils.calculatePercentage(current, max));
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}