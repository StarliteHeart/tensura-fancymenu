package net.starliteheart.tensura_fancymenu.requirements.existence;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.requirements.AbstractTensuraRequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IsPlayerInSpiritualFormRequirement extends AbstractTensuraRequirement {
    public IsPlayerInSpiritualFormRequirement() {
        super("is_player_in_spiritual_form");
    }

    @Override
    protected boolean isTensuraRequirementMet(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                              @Nullable String value) {
        return TensuraStorages.getExistenceFrom(player).isSpiritualForm();
    }
}
