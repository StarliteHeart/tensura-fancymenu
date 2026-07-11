package net.starliteheart.tensura_fancymenu.placeholders.health;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import net.starliteheart.tensura_fancymenu.utils.TensuraFancyMenuUtils;
import org.jetbrains.annotations.NotNull;

public class CurrentPlayerSeverancePercentagePlaceholder extends AbstractTensuraPlaceholder {
    public CurrentPlayerSeverancePercentagePlaceholder() {
        super("current_player_severance_percent");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        double current = TensuraStorages.getEffectFrom(player).getSeveranceAmount();
        double max = player.getMaxHealth();
        return String.valueOf((int) TensuraFancyMenuUtils.calculatePercentage(current, max));
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}