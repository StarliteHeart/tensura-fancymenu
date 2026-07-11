package net.starliteheart.tensura_fancymenu.placeholders.health;

import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class MaxPlayerSpiritualHealthPlaceholder extends AbstractTensuraPlaceholder {
    public MaxPlayerSpiritualHealthPlaceholder() {
        super("max_player_spiritual_health");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return String.valueOf(player.getAttributeValue(TensuraAttributes.MAX_SPIRITUAL_HEALTH));
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0.0);
    }
}