package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldFloatPlaceholder;
import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class CurrentSpiritualHealthPlaceholder extends AbstractWorldFloatPlaceholder {
    public CurrentSpiritualHealthPlaceholder() {
        super("current_spiritual_health");
    }

    @Override
    protected float getFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (float) TensuraStorages.getExistenceFrom(player).getSpiritualHealth();
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.current_spiritual_health";
    }
}