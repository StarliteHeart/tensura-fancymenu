package net.starliteheart.tensura_fancymenu.placeholders.health;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class CurrentPlayerSeverancePlaceholder extends AbstractTensuraPlaceholder {
    public CurrentPlayerSeverancePlaceholder() {
        super("current_player_severance");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return String.valueOf(TensuraStorages.getEffectFrom(player).getSeveranceAmount());
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0.0);
    }
}