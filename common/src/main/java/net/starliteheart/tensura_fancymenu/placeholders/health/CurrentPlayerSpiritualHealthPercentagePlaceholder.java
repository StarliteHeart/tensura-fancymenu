package net.starliteheart.tensura_fancymenu.placeholders.health;

import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import net.starliteheart.tensura_fancymenu.utils.TensuraFancyMenuUtils;
import org.jetbrains.annotations.NotNull;

public class CurrentPlayerSpiritualHealthPercentagePlaceholder extends AbstractTensuraPlaceholder {
    public CurrentPlayerSpiritualHealthPercentagePlaceholder() {
        super("current_player_spiritual_health_percent");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        double current = TensuraStorages.getExistenceFrom(player).getSpiritualHealth();
        double max = player.getAttributeValue(TensuraAttributes.MAX_SPIRITUAL_HEALTH);
        return String.valueOf((int) TensuraFancyMenuUtils.calculatePercentage(current, max));
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}