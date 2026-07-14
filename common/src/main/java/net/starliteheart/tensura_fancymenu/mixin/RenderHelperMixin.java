package net.starliteheart.tensura_fancymenu.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.manasmods.tensura.util.client.RenderHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderHelper.class)
public abstract class RenderHelperMixin {
    @Inject(method = "renderCustomBlur", at = @At("HEAD"))
    private static void disableDepthTestInCustomBlur(int blurStrength, CallbackInfo ci) {
        RenderSystem.disableDepthTest();
    }
}
