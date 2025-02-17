package net.deadlaycraft.whoniversemod.client;

import net.deadlaycraft.whoniversemod.block.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ClientModEvents {

    @SubscribeEvent
    public static void registerRenderTypes(EntityRenderersEvent.RegisterRenderers event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RADIANT_LEAVES.get(), RenderType.translucent());
    }

}
