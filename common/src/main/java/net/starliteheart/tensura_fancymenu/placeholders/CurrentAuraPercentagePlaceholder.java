package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldPercentagePlaceholder;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class CurrentAuraPercentagePlaceholder extends AbstractWorldPercentagePlaceholder {
    public CurrentAuraPercentagePlaceholder() {
        super("current_aura_percent");
    }

    @Override
    protected float getCurrentFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (float) TensuraStorages.getExistenceFrom(player).getAura();
    }

    @Override
    protected float getMaxFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (float) EnergyHelper.getMaxAura(player);
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.current_aura_percent";
    }
}