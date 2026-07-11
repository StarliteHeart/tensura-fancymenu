package net.starliteheart.tensura_fancymenu.placeholders.existence;

import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class MaxPlayerAuraPlaceholder extends AbstractTensuraPlaceholder {
    public MaxPlayerAuraPlaceholder() {
        super("max_player_aura");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return String.valueOf(EnergyHelper.getMaxAura(player));
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0.0);
    }
}