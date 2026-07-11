package net.starliteheart.tensura_fancymenu.placeholders.health;

import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class PlayerMultilayerBarrierPlaceholder extends AbstractTensuraPlaceholder {
    public PlayerMultilayerBarrierPlaceholder() {
        super("player_multilayer_barrier");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return String.valueOf(player.getAttributeValue(TensuraAttributes.MULTILAYER_BARRIER));
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0.0);
    }
}