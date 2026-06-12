package net.starliteheart.tensura_fancymenu.utils;

import net.minecraft.client.Minecraft;

public class TensuraFancyMenuUtils {
    public static int getTensuraMenuBackgroundBlurriness() {
        return Minecraft.getInstance().options.getMenuBackgroundBlurriness();
//        return ConfigRegistry.getConfig(MenuConfig.class).blurStrength;
    }
}
