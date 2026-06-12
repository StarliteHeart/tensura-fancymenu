package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldPercentagePlaceholder;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class CurrentMountSpiritualHealthPercentagePlaceholder extends AbstractWorldPercentagePlaceholder {
    public CurrentMountSpiritualHealthPercentagePlaceholder() {
        super("current_mount_spiritual_health_percent");
    }

    @Override
    protected float getCurrentFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        Entity vehicle = player.getControlledVehicle();
        return (vehicle instanceof LivingEntity mount)
                ? (float) TensuraStorages.getExistenceFrom(mount).getSpiritualHealth()
                : 0.0F;
    }

    @Override
    protected float getMaxFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        Entity vehicle = player.getControlledVehicle();
        return (vehicle instanceof LivingEntity mount)
                ? (float) mount.getAttributeValue(TensuraAttributes.MAX_SPIRITUAL_HEALTH)
                : 0.0F;
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.current_mount_spiritual_health_percent";
    }
}