package net.starliteheart.tensura_fancymenu.placeholders.player;

import io.github.manasmods.manascore.race.api.ManasRace;
import io.github.manasmods.manascore.race.api.ManasRaceInstance;
import io.github.manasmods.manascore.race.api.RaceAPI;
import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class CurrentPlayerEvolutionProgressPercentPlaceholder extends AbstractTensuraPlaceholder {
    public CurrentPlayerEvolutionProgressPercentPlaceholder() {
        super("current_player_evolution_progress_percent");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        Optional<ManasRaceInstance> optional = RaceAPI.getRaceFrom(player).getRace();
        return optional.map(race -> {
                           ManasRace trackedEvolution = TensuraStorages.getPlayerDataFrom(player).getTrackedEvolution();
                           return String.valueOf((int) (race.getEvolutionProgress(player, trackedEvolution) * 100.0F));
                       })
                       .orElseGet(this::getReplacementFallback);
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}