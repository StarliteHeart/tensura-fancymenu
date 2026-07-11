package net.starliteheart.tensura_fancymenu.placeholders.ability;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class AbilityActivePresetPlaceholder extends AbstractTensuraPlaceholder {
    public AbilityActivePresetPlaceholder() {
        super("ability_active_preset");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return String.valueOf(TensuraStorages.getAbilityFrom(player).getActivePreset());
    }
}