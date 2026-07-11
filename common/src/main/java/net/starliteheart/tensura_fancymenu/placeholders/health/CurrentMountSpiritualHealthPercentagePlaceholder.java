package net.starliteheart.tensura_fancymenu.placeholders.health;

import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import net.starliteheart.tensura_fancymenu.utils.TensuraFancyMenuUtils;
import org.jetbrains.annotations.NotNull;

public class CurrentMountSpiritualHealthPercentagePlaceholder extends AbstractTensuraPlaceholder {
    public CurrentMountSpiritualHealthPercentagePlaceholder() {
        super("current_mount_spiritual_health_percent");
    }

    @Override
    protected String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        if (player.getControlledVehicle() instanceof LivingEntity mount) {
            double current = TensuraStorages.getExistenceFrom(mount).getSpiritualHealth();
            double max = mount.getAttributeValue(TensuraAttributes.MAX_SPIRITUAL_HEALTH);
            return String.valueOf((int) TensuraFancyMenuUtils.calculatePercentage(current, max));
        }
        return getReplacementFallback();
    }

    @Override
    public @NotNull String getReplacementFallback() {
        return String.valueOf(0);
    }
}