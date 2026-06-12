package net.starliteheart.tensura_fancymenu.requirements;

import de.keksuccino.fancymenu.customization.requirement.Requirement;
import de.keksuccino.fancymenu.util.rendering.ui.screen.texteditor.TextEditorFormattingRule;
import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.starliteheart.tensura_fancymenu.TensuraFancyMenuCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public abstract class AbstractAbilitySlotRequirement extends Requirement {
    public AbstractAbilitySlotRequirement(@NotNull String identifier) {
        super(identifier);
    }

    @Override
    public boolean canRunAsync() {
        return false;
    }

    @Override
    public boolean hasValue() { return true; }

    protected abstract boolean isAbilityRequirementMet(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                                      @NotNull AbilitySlot ability, @NotNull ManasSkill skill,
                                                      @NotNull ManasSkillInstance instance);

    @Override
    public boolean isRequirementMet(@Nullable String value) {
        if (value != null) {
            String trimmed = value.trim();
            if (!trimmed.isEmpty()) {
                int slotNumber;
                try {
                    slotNumber = Integer.parseInt(trimmed);
                } catch (NumberFormatException var7) {
                    TensuraFancyMenuCompat.LOGGER.warn("[TxFM] Invalid ability slot '{}' provided to '{}' requirement!", trimmed,
                                this.getIdentifier());
                    return false;
                }

                if (slotNumber < 0 || slotNumber > 2) {
                    TensuraFancyMenuCompat.LOGGER.warn("[TxFM] Ability slot '{}' provided to '{}' requirement out of index!", trimmed,
                                                       this.getIdentifier());
                    return false;
                }

                try {
                    ClientLevel level = Minecraft.getInstance().level;
                    LocalPlayer player = Minecraft.getInstance().player;
                    if (level != null && player != null) {
                        AbilitySlot ability = TensuraStorages.getAbilityFrom(player).getAbilitySlot(slotNumber);
                        ManasSkill skill = ability.getSkill();
                        if (skill != null) {
                            Optional<ManasSkillInstance> optional = SkillAPI.getSkillsFrom(player).getSkill(skill);
                            if (optional.isPresent()) {
                                return isAbilityRequirementMet(player, level, ability, skill, optional.get());
                            }
                        }
                    }
                } catch (Exception ex) {
                    TensuraFancyMenuCompat.LOGGER.error("[TxFM] Failed to handle '{}' loading requirement!",
                                                        this.getIdentifier(), ex);
                }
            }
        }
        return false;
    }

    protected abstract @NotNull String getLocalizationBase();

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable(this.getLocalizationBase());
    }

    @Override
    public @Nullable Component getDescription() {
        return Component.translatable(this.getLocalizationBase() + ".desc");
    }

    @Override
    public @Nullable String getCategory() {
        return I18n.get("fancymenu.requirements.categories.world", new Object[0]);
    }

    @Override
    public @Nullable Component getValueDisplayName() {
        return Component.translatable("tensura_fancymenu.requirements.world.is_ability_slot_requirement.value_name");
    }

    @Override
    public @Nullable String getValuePreset() {
        return String.valueOf(0);
    }

    @Override
    public @Nullable List<TextEditorFormattingRule> getValueFormattingRules() {
        return null;
    }
}
