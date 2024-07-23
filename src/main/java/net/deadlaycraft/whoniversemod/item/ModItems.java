package net.deadlaycraft.whoniversemod.item;

import net.deadlaycraft.whoniversemod.WhoniverseMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WhoniverseMod.MOD_ID); // Creating a new DeferredRegister Field

    public static final RegistryObject<Item> SAFFRITE = ITEMS.register("saffrite", // implementing the deferred creation of a new item as a FIELD
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAFFRITE_INFUSED_REDSTONE = ITEMS.register("saffrite_infused_redstone",
            () -> new Item(new Item.Properties()));

    // "RegistryObject" is a wrapper class

    public static void register(IEventBus eventBus) { // method, triggering the game to register the item on load
        ITEMS.register(eventBus);
    }
}

/*
    * "DeferredRegister<Item> is a forge utility class
    * This is a helper class provided by Forge, providing ready-made methods and structures to handle complex processes
    * This specific one is for item and block registration
    * "<Item>" is a generic, and "Item" is a specific class in the Minecraft codebase.

    LIST OF FORGE UTILITY CLASSES:
    * DeferredRegister" - For item and block registration
    * "ForgeRegistries" - For accessing game registries
    * "EventBus" - for managing events (For example, a player logging in, or in this case, registering an item)
 */
