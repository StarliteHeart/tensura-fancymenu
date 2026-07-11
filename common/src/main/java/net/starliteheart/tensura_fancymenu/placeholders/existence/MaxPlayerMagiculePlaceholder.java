package net.starliteheart.tensura_fancymenu.placeholders.existence;

import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class MaxPlayerMagiculePlaceholder extends AbstractTensuraPlaceholder {
    public MaxPlayerMagiculePlaceholder() {
        super("max_player_magicule");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return String.valueOf(EnergyHelper.getMaxMagicule(player));
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0.0);
    }
}