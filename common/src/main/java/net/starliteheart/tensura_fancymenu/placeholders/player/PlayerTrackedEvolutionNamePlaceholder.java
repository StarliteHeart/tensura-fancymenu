package net.starliteheart.tensura_fancymenu.placeholders.player;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class PlayerTrackedEvolutionNamePlaceholder extends AbstractTensuraPlaceholder {
    public PlayerTrackedEvolutionNamePlaceholder() {
        super("player_tracked_evolution_name");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return Optional.ofNullable(TensuraStorages.getPlayerDataFrom(player).getTrackedEvolution().getName())
                       .map(Component::getString)
                       .orElseGet(this::getReplacementFallback);
    }
}