package net.starliteheart.tensura_fancymenu.utils;


public class TensuraFancyMenuUtils {

    public static double calculatePercentage(double current, double max) {
        if (max == 0.0 || current == 0.0) {
            return 0.0;
        }
        return current / max * 100.0;
    }
}
