package net.starliteheart.tensura_fancymenu.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import io.github.manasmods.tensura.client.screen.templates.SimpleScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.starliteheart.tensura_fancymenu.utils.TensuraFancyMenuUtils;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SimpleScreen.class)
public abstract class SimpleScreenMixin extends Screen {
    protected SimpleScreenMixin(Component component) {
        super(component);
    }

    @Redirect(
            method = "<init>", at = @At(
            value = "FIELD",
            target = "Lio/github/manasmods/tensura/client/screen/templates/SimpleScreen;blurStrength:I",
            opcode = Opcodes.PUTSTATIC
    )
    )
    private void useCfgBlurStrengthInConstructor(int original) {
        SimpleScreenAccessor.setBlurStrength(TensuraFancyMenuUtils.getTensuraMenuBackgroundBlurriness());
    }

    @Redirect(
            method = "render", at = @At(
            value = "INVOKE", target = "Lio/github/manasmods/tensura/util/client/RenderHelper;renderCustomBlur(I)V"
    )
    )
    private void invokeVanillaBlurring(int blurStrength, @Local(argsOnly = true) float partialTick) {
        super.renderBlurredBackground(partialTick);
    }
}
