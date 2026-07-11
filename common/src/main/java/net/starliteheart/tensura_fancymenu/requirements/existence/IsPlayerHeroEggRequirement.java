package net.starliteheart.tensura_fancymenu.requirements.existence;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.requirements.AbstractTensuraRequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IsPlayerHeroEggRequirement extends AbstractTensuraRequirement {
    public IsPlayerHeroEggRequirement() {
        super("is_player_hero_egg");
    }

    @Override
    protected boolean isTensuraRequirementMet(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                              @Nullable String value) {
        return TensuraStorages.getExistenceFrom(player).isHeroEgg();
    }
}
