package net.starliteheart.tensura_fancymenu.mixin;

import io.github.manasmods.tensura.client.screen.templates.SimpleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SimpleScreen.class)
public interface SimpleScreenAccessor {
    @Accessor("blurStrength")
    static void setBlurStrength(int value) { throw new AssertionError(); }
}
