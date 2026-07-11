package net.starliteheart.tensura_fancymenu.placeholders.existence;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class PlayerSoulPointsPlaceholder extends AbstractTensuraPlaceholder {
    public PlayerSoulPointsPlaceholder() {
        super("player_soul_points");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return String.valueOf(TensuraStorages.getExistenceFrom(player).getSoulPoints());
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}