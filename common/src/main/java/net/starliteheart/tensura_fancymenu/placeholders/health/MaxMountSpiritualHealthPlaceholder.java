package net.starliteheart.tensura_fancymenu.placeholders.health;

import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;

public class MaxMountSpiritualHealthPlaceholder extends AbstractTensuraPlaceholder {
    public MaxMountSpiritualHealthPlaceholder() {
        super("max_mount_spiritual_health");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (player.getControlledVehicle() instanceof LivingEntity mount)
                ? String.valueOf(mount.getAttributeValue(TensuraAttributes.MAX_SPIRITUAL_HEALTH))
                : this.getReplacementFallback();
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0.0);
    }
}