package net.starliteheart.tensura_fancymenu.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.starliteheart.tensura_fancymenu.TensuraFancyMenuCompat;

public class TensuraFancyMenuFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        TensuraFancyMenuCompat.init();
    }
}
