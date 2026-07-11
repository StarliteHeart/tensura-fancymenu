package net.starliteheart.tensura_fancymenu.neoforge.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.starliteheart.tensura_fancymenu.TensuraFancyMenuCompat;
import net.starliteheart.tensura_fancymenu.neoforge.datagen.lang.EnUsLanguageProvider;

@EventBusSubscriber(modid = TensuraFancyMenuCompat.MOD_ID)
public class DataGenerators {
    @SubscribeEvent // on the mod event bus
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(event.includeClient(), new EnUsLanguageProvider(packOutput));
    }
}
