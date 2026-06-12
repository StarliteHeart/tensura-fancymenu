package net.starliteheart.tensura_fancymenu.placeholders;

import de.keksuccino.fancymenu.customization.placeholder.DeserializedPlaceholderString;
import de.keksuccino.fancymenu.customization.placeholder.placeholders.world.AbstractWorldPlaceholder;
import de.keksuccino.fancymenu.util.SerializationHelper;
import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ability.AbilitySlot;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.starliteheart.tensura_fancymenu.TensuraFancyMenuCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public abstract class AbstractAbilitySlotPlaceholder extends AbstractWorldPlaceholder {
    public AbstractAbilitySlotPlaceholder(@NotNull String identifier) {
        super(identifier);
    }

    protected abstract String getAbilityValue(
            @NotNull LocalPlayer player,
            @NotNull ClientLevel level,
            @NotNull AbilitySlot ability,
            @NotNull ManasSkill skill,
            @NotNull ManasSkillInstance instance
    );

    @Override
    public String getReplacementFor(DeserializedPlaceholderString dps) {
        try {
            int slotNumber = SerializationHelper.INSTANCE.deserializeNumber(Integer.class, 0, dps.values.get("slot"));
            if (slotNumber < 0 || slotNumber > 2) {
                TensuraFancyMenuCompat.LOGGER.warn("[TxFM] Ability slot '{}' provided to '{}' placeholder out of index!", slotNumber,
                                                   this.getIdentifier());
                return "";
            }
            ClientLevel level = this.getLevel();
            LocalPlayer player = this.getPlayer();
            if (level != null && player != null) {
                AbilitySlot ability = TensuraStorages.getAbilityFrom(player).getAbilitySlot(slotNumber);
                ManasSkill skill = ability.getSkill();
                if (skill != null) {
                    Optional<ManasSkillInstance> optional = SkillAPI.getSkillsFrom(player).getSkill(skill);
                    if (optional.isPresent()) {
                        return this.getAbilityValue(player, level, ability, skill, optional.get());
                    }
                }
            }
        } catch (Exception ex) {
            TensuraFancyMenuCompat.LOGGER.error("[TxFM] Failed to get replacement for '{}' placeholder.",
                                                this.getIdentifier(), ex);
        }

        return "";
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