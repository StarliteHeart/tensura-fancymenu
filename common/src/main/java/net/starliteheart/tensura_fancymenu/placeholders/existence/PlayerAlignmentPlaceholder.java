package net.starliteheart.tensura_fancymenu.placeholders.existence;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class PlayerAlignmentPlaceholder extends AbstractTensuraPlaceholder {
    public PlayerAlignmentPlaceholder() {
        super("player_alignment");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return TensuraStorages.getExistenceFrom(player).getAlignment().getName().getString();
    }
}