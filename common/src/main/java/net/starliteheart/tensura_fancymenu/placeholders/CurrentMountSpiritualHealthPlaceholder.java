package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldFloatPlaceholder;
import io.github.manasmods.tensura.storage.TensuraStorages;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class CurrentMountSpiritualHealthPlaceholder extends AbstractWorldFloatPlaceholder {
    public CurrentMountSpiritualHealthPlaceholder() {
        super("current_mount_spiritual_health");
    }

    @Override
    protected float getFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        Entity vehicle = player.getControlledVehicle();
        return (vehicle instanceof LivingEntity mount)
                ? (float) TensuraStorages.getExistenceFrom(mount).getSpiritualHealth()
                : 0.0F;
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.current_mount_spiritual_health";
    }
}