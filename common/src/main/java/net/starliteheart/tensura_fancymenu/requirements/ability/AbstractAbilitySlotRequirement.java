package net.starliteheart.tensura_fancymenu.requirements.ability;

import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.starliteheart.tensura_fancymenu.TensuraFancyMenuCompat;
import net.starliteheart.tensura_fancymenu.requirements.AbstractTensuraRequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractAbilitySlotRequirement extends AbstractTensuraRequirement {
    public AbstractAbilitySlotRequirement(@NotNull String identifier) {
        super(identifier);
    }

    @Override
    public boolean hasValue() {return true;}

    protected abstract boolean isAbilityRequirementMet(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                                       @NotNull AbilitySlot abilitySlot);

    @Override
    public boolean isTensuraRequirementMet(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                           @Nullable String value) {
        if (value != null) {
            String trimmed = value.trim();
            if (!trimmed.isEmpty()) {
                try {
                    int slotNumber = Integer.parseInt(trimmed);
                    if (slotNumber < 0 || slotNumber > 2) {
                        TensuraFancyMenuCompat.LOGGER.warn(
                                "[TxFM] Ability slot '{}' provided to '{}' requirement out of index!", trimmed,
                                this.getIdentifier());
                        return false;
                    }

                    AbilitySlot abilitySlot = TensuraStorages.getAbilityFrom(player).getAbilitySlot(slotNumber);
                    return this.isAbilityRequirementMet(player, level, abilitySlot);
                } catch (NumberFormatException var7) {
                    TensuraFancyMenuCompat.LOGGER.warn(
                            "[TxFM] Invalid ability slot '{}' provided to '{}' requirement!", trimmed,
                            this.getIdentifier());
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public @Nullable Component getValueDisplayName() {
        return Component.translatable("tensura_fancymenu.requirements.world.tensura.ability_slot.value_name");
    }

    @Override
    public @Nullable String getValuePreset() {
        return String.valueOf(0);
    }
}
