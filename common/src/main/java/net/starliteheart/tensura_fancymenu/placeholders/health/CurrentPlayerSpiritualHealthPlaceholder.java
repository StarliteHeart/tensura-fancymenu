package net.starliteheart.tensura_fancymenu.placeholders.health;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class CurrentPlayerSpiritualHealthPlaceholder extends AbstractTensuraPlaceholder {
    public CurrentPlayerSpiritualHealthPlaceholder() {
        super("current_player_spiritual_health");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return String.valueOf(TensuraStorages.getExistenceFrom(player).getSpiritualHealth());
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0.0);
    }
}