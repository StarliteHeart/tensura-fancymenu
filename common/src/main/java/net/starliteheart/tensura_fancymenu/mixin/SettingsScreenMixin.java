package net.starliteheart.tensura_fancymenu.mixin;

import io.github.manasmods.tensura.client.screen.SettingsScreen;
import net.starliteheart.tensura_fancymenu.utils.TensuraFancyMenuUtils;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SettingsScreen.class)
public abstract class SettingsScreenMixin {

    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lio/github/manasmods/tensura/client/screen/SettingsScreen;blurStrength:I", opcode = Opcodes.PUTSTATIC))
    private void useCfgBlurStrengthInConstructor(int value) {
        SimpleScreenAccessor.setBlurStrength(TensuraFancyMenuUtils.getTensuraMenuBackgroundBlurriness());
    }

    @Redirect(method = "mouseClicked", at = @At(value = "FIELD", target = "Lio/github/manasmods/tensura/client/screen/SettingsScreen;blurStrength:I", opcode = Opcodes.PUTSTATIC))
    private void useCfgBlurStrengthInMouseClicked(int value) {
        SimpleScreenAccessor.setBlurStrength(TensuraFancyMenuUtils.getTensuraMenuBackgroundBlurriness());
    }

    @Redirect(method = "onClose", at = @At(value = "FIELD", target = "Lio/github/manasmods/tensura/client/screen/SettingsScreen;blurStrength:I", opcode = Opcodes.PUTSTATIC))
    private void useCfgBlurStrengthInOnClose(int value) {
        SimpleScreenAccessor.setBlurStrength(TensuraFancyMenuUtils.getTensuraMenuBackgroundBlurriness());
    }
}
