package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldPercentagePlaceholder;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class CurrentMagiculePercentagePlaceholder extends AbstractWorldPercentagePlaceholder {
    public CurrentMagiculePercentagePlaceholder() {
        super("current_magicule_percent");
    }

    @Override
    protected float getCurrentFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (float) TensuraStorages.getExistenceFrom(player).getMagicule();
    }

    @Override
    protected float getMaxFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (float) EnergyHelper.getMaxMagicule(player);
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.current_magicule_percent";
    }
}