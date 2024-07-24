package net.deadlaycraft.whoniversemod.item;

import net.deadlaycraft.whoniversemod.WhoniverseMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.deadlaycraft.whoniversemod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WhoniverseMod.MOD_ID); //field for creative mode tabs

    public static final RegistryObject<CreativeModeTab> WHONIVERSE_TAB = CREATIVE_MODE_TABS.register("whoniverse_tab", // creating a new creative mode tab field
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.REDRITE_WIRE.get())) // a supplier creating a new icon from a new item stack, retrieving a mod item to do so
                    .title(Component.translatable("creativetab.whoniverse_tab")) //
                    .displayItems((itemDisplayParameters, pOutput) -> {
                        pOutput.accept(ModItems.SAFFRITE.get());

                        pOutput.accept(ModBlocks.REDRITE_WIRE.get());
                        pOutput.accept(ModBlocks.REDRITE_BLOCK.get());
                        pOutput.accept(ModBlocks.SAFFRITE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus); // passing through the eventbus
    }
}
