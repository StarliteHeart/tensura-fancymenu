package net.starliteheart.tensura_fancymenu.requirements;

import de.keksuccino.fancymenu.customization.requirement.Requirement;
import de.keksuccino.fancymenu.util.rendering.ui.screen.texteditor.TextEditorFormattingRule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.starliteheart.tensura_fancymenu.TensuraFancyMenuCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractTensuraRequirement extends Requirement {
    public AbstractTensuraRequirement(@NotNull String identifier) {
        super(identifier);
    }

    @Override
    public boolean canRunAsync() {
        return false;
    }

    @Override
    public boolean hasValue() {return false;}

    protected abstract boolean isTensuraRequirementMet(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                                       @Nullable String value);

    @Override
    public boolean isRequirementMet(@Nullable String value) {
        try {
            ClientLevel level = Minecraft.getInstance().level;
            LocalPlayer player = Minecraft.getInstance().player;
            if (level != null && player != null) {
                return isTensuraRequirementMet(player, level, value);
            }
        } catch (Exception ex) {
            TensuraFancyMenuCompat.LOGGER.error("[TxFM] Failed to handle '{}' loading requirement!",
                                                this.getIdentifier(), ex);
        }
        return false;
    }

    public String getDisplayNameLocalization() {
        return getLocalizationBase();
    }

    public String getDescriptionLocalization() {
        return getLocalizationBase() + ".desc";
    }

    protected @NotNull String getLocalizationBase() {
        return String.format("tensura_fancymenu.requirements.world.tensura.%s", this.getIdentifier());
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable(this.getDisplayNameLocalization());
    }

    @Override
    public @Nullable Component getDescription() {
        return Component.translatable(this.getDescriptionLocalization());
    }

    @Override
    public @Nullable String getCategory() {
        return I18n.get("tensura_fancymenu.requirements.categories.world.tensura");
    }

    @Override
    public Component getValueDisplayName() {
        return null;
    }

    @Override
    public String getValuePreset() {
        return null;
    }

    @Override
    public @Nullable List<TextEditorFormattingRule> getValueFormattingRules() {
        return null;
    }
}
