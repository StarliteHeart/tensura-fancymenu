package net.starliteheart.tensura_fancymenu.utils;

import net.minecraft.client.Minecraft;

public class TensuraFancyMenuUtils {
    public static int getTensuraMenuBackgroundBlurriness() {
        return Minecraft.getInstance().options.getMenuBackgroundBlurriness();
//        return ConfigRegistry.getConfig(MenuConfig.class).blurStrength;
    }

    public static double calculatePercentage(double current, double max) {
        if (max == 0.0 || current == 0.0) {
            return 0.0;
        }
        return current / max * 100.0;
    }
}
