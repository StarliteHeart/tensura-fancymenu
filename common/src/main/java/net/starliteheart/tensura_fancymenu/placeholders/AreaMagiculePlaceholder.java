package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldFloatPlaceholder;
import io.github.manasmods.tensura.storage.AreaMagiculeHelper;
import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class AreaMagiculePlaceholder extends AbstractWorldFloatPlaceholder {
    public AreaMagiculePlaceholder() {
        super("area_magicule");
    }

    @Override
    protected float getFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (float) AreaMagiculeHelper.getMagicule(player, true);
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.area_magicule";
    }
}