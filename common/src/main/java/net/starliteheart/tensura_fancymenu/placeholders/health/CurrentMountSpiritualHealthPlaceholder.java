package net.starliteheart.tensura_fancymenu.placeholders.health;

import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class CurrentMountSpiritualHealthPlaceholder extends AbstractTensuraPlaceholder {
    public CurrentMountSpiritualHealthPlaceholder() {
        super("current_mount_spiritual_health");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (player.getControlledVehicle() instanceof LivingEntity mount)
                ? String.valueOf(TensuraStorages.getExistenceFrom(mount).getSpiritualHealth())
                : getReplacementFallback();
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0.0);
    }
}