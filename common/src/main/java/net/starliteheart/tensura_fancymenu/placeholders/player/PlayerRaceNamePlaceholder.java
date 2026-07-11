package net.starliteheart.tensura_fancymenu.placeholders.player;

import io.github.manasmods.manascore.race.api.ManasRaceInstance;
import io.github.manasmods.manascore.race.api.RaceAPI;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class PlayerRaceNamePlaceholder extends AbstractTensuraPlaceholder {
    public PlayerRaceNamePlaceholder() {
        super("player_race_name");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        Optional<ManasRaceInstance> optional = RaceAPI.getRaceFrom(player).getRace();
        return optional.map(race -> race.getDisplayName().getString())
                       .orElseGet(this::getReplacementFallback);
    }
}