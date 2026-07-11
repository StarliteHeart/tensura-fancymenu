package net.starliteheart.tensura_fancymenu.mixin;

import net.irisshaders.iris.gui.screen.ShaderPackScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ShaderPackScreen.class)
public abstract class ShaderPackScreenMixin extends Screen {
    protected ShaderPackScreenMixin(Component component) {
        super(component);
    }

    @Inject(method = "renderBlurredBackground", at = @At("HEAD"), cancellable = true)
    private void invokeVanillaBlurring(float partialTicks, CallbackInfo ci) {
        super.renderBlurredBackground(partialTicks);
        ci.cancel();
    }
}
