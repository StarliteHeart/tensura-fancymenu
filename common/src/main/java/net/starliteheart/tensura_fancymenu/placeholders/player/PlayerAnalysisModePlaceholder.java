package net.starliteheart.tensura_fancymenu.placeholders.player;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class PlayerAnalysisModePlaceholder extends AbstractTensuraPlaceholder {
    public PlayerAnalysisModePlaceholder() {
        super("player_analysis_mode");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return String.valueOf(TensuraStorages.getPlayerDataFrom(player).getAnalysisMode());
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}