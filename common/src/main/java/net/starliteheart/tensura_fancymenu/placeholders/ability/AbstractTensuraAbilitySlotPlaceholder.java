package net.starliteheart.tensura_fancymenu.placeholders.ability;

import de.keksuccino.fancymenu.customization.placeholder.DeserializedPlaceholderString;
import de.keksuccino.fancymenu.util.SerializationHelper;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.TensuraFancyMenuCompat;
import net.starliteheart.tensura_fancymenu.placeholders.AbstractTensuraPlaceholder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class AbstractTensuraAbilitySlotPlaceholder extends AbstractTensuraPlaceholder {
    public AbstractTensuraAbilitySlotPlaceholder(@NotNull String identifier) {
        super(identifier);
    }

    protected abstract String getAbilitySlotString(
            @NotNull LocalPlayer player,
            @NotNull ClientLevel level,
            @NotNull AbilitySlot abilitySlot
    );

    @Override
    public String getReplacementString(@NotNull LocalPlayer player, @NotNull ClientLevel level,
                                       DeserializedPlaceholderString dps) {
        try {
            int slotNumber = SerializationHelper.INSTANCE.deserializeNumber(Integer.class, 0, dps.values.get("slot"));
            if (slotNumber < 0 || slotNumber > 2) {
                TensuraFancyMenuCompat.LOGGER.warn(
                        "[TxFM] Ability slot '{}' provided to '{}' placeholder out of index!", slotNumber,
                        this.getIdentifier());
                return this.getReplacementFallback();
            }
            AbilitySlot abilitySlot = TensuraStorages.getAbilityFrom(player).getAbilitySlot(slotNumber);
            return this.getAbilitySlotString(player, level, abilitySlot);
        } catch (Exception ex) {
            TensuraFancyMenuCompat.LOGGER.error("[TxFM] Failed to get replacement for '{}' placeholder.",
                                                this.getIdentifier(), ex);
        }

        return this.getReplacementFallback();
    }

    @Override
    public @Nullable List<String> getValueNames() {
        return List.of("slot");
    }

    @Override
    public @NotNull DeserializedPlaceholderString getDefaultPlaceholderString() {
        HashMap<String, String> values = new LinkedHashMap<>();
        values.put("slot", "0");
        return new DeserializedPlaceholderString(this.getIdentifier(), values, "");
    }
}