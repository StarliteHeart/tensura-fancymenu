package net.starliteheart.tensura_fancymenu.placeholders.player;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class PlayerPresenceSensePlaceholder extends AbstractTensuraPlaceholder {
    public PlayerPresenceSensePlaceholder() {
        super("player_presence_sense");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return String.valueOf(TensuraStorages.getPlayerDataFrom(player).getPresenceSenseMode());
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}