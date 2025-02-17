package net.deadlaycraft.whoniversemod;

import com.mojang.logging.LogUtils;
import net.deadlaycraft.whoniversemod.block.ModBlocks;
import net.deadlaycraft.whoniversemod.events.ModEvents;
import net.deadlaycraft.whoniversemod.item.ModCreativeModTabs;
import net.deadlaycraft.whoniversemod.item.ModItems;
import net.deadlaycraft.whoniversemod.worldgen.feature.ModConfiguredFeatures;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// THIS FILE RUNS ON STARTUP TO LOAD UP THE MOD //

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WhoniverseMod.MOD_ID)
public class WhoniverseMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "whoniversemod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public WhoniverseMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus); // passing through the EventBus so the game recognises new items on startup
        ModBlocks.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        // Register listener
        MinecraftForge.EVENT_BUS.addListener(ModEvents::BreakBlock);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register Features

        ModConfiguredFeatures.register(modEventBus);

    }


    private void commonSetup(final FMLCommonSetupEvent event) {
    }
    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
