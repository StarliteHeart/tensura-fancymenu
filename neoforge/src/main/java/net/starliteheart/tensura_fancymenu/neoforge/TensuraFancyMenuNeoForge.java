package net.starliteheart.tensura_fancymenu.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.starliteheart.tensura_fancymenu.TensuraFancyMenuCompat;

@Mod(value = TensuraFancyMenuCompat.MOD_ID, dist = Dist.CLIENT)
public final class TensuraFancyMenuNeoForge {
    public TensuraFancyMenuNeoForge() {
        // Run our common setup.
        TensuraFancyMenuCompat.init();
    }
}
