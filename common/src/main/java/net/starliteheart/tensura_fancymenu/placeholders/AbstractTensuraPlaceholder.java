package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.DeserializedPlaceholderString;
import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldPlaceholder;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.language.I18n;
import net.starliteheart.tensura_fancymenu.TensuraFancyMenuCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractTensuraPlaceholder extends AbstractWorldPlaceholder {
    public AbstractTensuraPlaceholder(@NotNull String identifier) {super(identifier);}

    protected String getReplacementString(
            @NotNull LocalPlayer player,
            @NotNull ClientLevel level
    ) {
        return this.getReplacementFallback();
    }

    protected String getReplacementString(
            @NotNull LocalPlayer player,
            @NotNull ClientLevel level,
            DeserializedPlaceholderString dps
    ) {
        return getReplacementString(player, level);
    }

    @Override
    public String getReplacementFor(DeserializedPlaceholderString dps) {
        try {
            ClientLevel level = this.getLevel();
            LocalPlayer player = this.getPlayer();
            if (level != null && player != null) {
                return getReplacementString(player, level, dps);
            }
        } catch (Exception ex) {
            TensuraFancyMenuCompat.LOGGER.error("[TxFM] Failed to get replacement for '{}' placeholder.",
                                                this.getIdentifier(), ex);
        }
        return this.getReplacementFallback();
    }

    public @NotNull String getReplacementFallback() {
        return "";
    }

    public String getDisplayNameLocalization() {
        return getLocalizationBase();
    }

    public String getDescriptionLocalization() {
        return getLocalizationBase() + ".desc";
    }

    @Override
    protected @NotNull String getLocalizationBase() {
        return String.format("tensura_fancymenu.placeholders.world.tensura.%s", this.getIdentifier());
    }

    @Override
    public String getCategory() {
        return I18n.get("tensura_fancymenu.placeholders.categories.world.tensura");
    }

    public @Nullable List<String> getValueNames() {
        return null;
    }

    public @NotNull DeserializedPlaceholderString getDefaultPlaceholderString() {
        return new DeserializedPlaceholderString(this.getIdentifier(), null, "");
    }
}