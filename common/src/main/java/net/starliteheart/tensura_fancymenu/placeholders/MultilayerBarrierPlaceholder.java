package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldFloatPlaceholder;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.NotNull;

public class MultilayerBarrierPlaceholder extends AbstractWorldFloatPlaceholder {
    public MultilayerBarrierPlaceholder() {
        super("multilayer_barrier");
    }

    @Override
    protected float getFloatValue(@NotNull LocalPlayer player, @NotNull ClientLevel level) {
        return (float) player.getAttributeValue(TensuraAttributes.MULTILAYER_BARRIER);
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return "tensura_fancymenu.placeholders.world.multilayer_barrier";
    }
}