package net.starliteheart.tensura_fancymenu;

import net.starliteheart.tensura_fancymenu.placeholders.Placeholders;
import net.starliteheart.tensura_fancymenu.requirements.Requirements;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TensuraFancyMenuCompat {
    public static final String MOD_ID = "tensura_fancymenu";
    public static Logger LOGGER = LogManager.getLogger();

    public static void init() {
        // Write common init code here.
        LOGGER.info("[TxFM] Registering TxFM additions to FancyMenu...");
        Placeholders.registerAll();
        Requirements.registerAll();
    }
}