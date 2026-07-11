package net.starliteheart.tensura_fancymenu.placeholders.existence;

import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import net.starliteheart.tensura_fancymenu.utils.TensuraFancyMenuUtils;
import org.jetbrains.annotations.NotNull;

public class CurrentPlayerAuraPercentagePlaceholder extends AbstractTensuraPlaceholder {
    public CurrentPlayerAuraPercentagePlaceholder() {
        super("current_player_aura_percent");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        double current = TensuraStorages.getExistenceFrom(player).getAura();
        double max = EnergyHelper.getMaxAura(player);
        return String.valueOf((int) TensuraFancyMenuUtils.calculatePercentage(current, max));
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}