package net.starliteheart.tensura_fancymenu.placeholders.misc;

import io.github.manasmods.tensura.storage.AreaMagiculeHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class AreaMagiculePlaceholder extends AbstractTensuraPlaceholder {
    public AreaMagiculePlaceholder() {
        super("area_magicule");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return String.valueOf(AreaMagiculeHelper.getMagicule(player, true));
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0.0);
    }
}