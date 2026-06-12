package net.starliteheart.tensura_fancymenu.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.starliteheart.tensura_fancymenu.TensuraFancyMenuCompat;
import net.neoforged.fml.common.Mod;

@Mod(value = TensuraFancyMenuCompat.MOD_ID, dist = Dist.CLIENT)
public final class TensuraFancyMenuNeoForge {
    public TensuraFancyMenuNeoForge() {
        // Run our common setup.
        TensuraFancyMenuCompat.init();
    }
}
