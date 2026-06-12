package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldFloatPlaceholder;
import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldPercentagePlaceholder;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class CurrentSpiritualHealthPercentagePlaceholder extends AbstractWorldPercentagePlaceholder {
    public CurrentSpiritualHealthPercentagePlaceholder() {
        super("current_spiritual_health_percent");
    }

    @Override
    protected float getCurrentFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (float) TensuraStorages.getExistenceFrom(player).getSpiritualHealth();
    }

    @Override
    protected float getMaxFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (float) player.getAttributeValue(TensuraAttributes.MAX_SPIRITUAL_HEALTH);
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.current_spiritual_health_percent";
    }
}