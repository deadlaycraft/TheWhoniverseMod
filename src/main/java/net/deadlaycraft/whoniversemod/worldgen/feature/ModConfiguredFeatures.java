package net.deadlaycraft.whoniversemod.worldgen.feature;

import net.deadlaycraft.whoniversemod.WhoniverseMod;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModConfiguredFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES
            = DeferredRegister.create(ForgeRegistries.FEATURES, WhoniverseMod.MOD_ID);

    public static final RegistryObject<Feature> TREE = FEATURES.register("radiant_tree",
            () -> new TreeFeature(TreeConfiguration.CODEC));

    public static void register(IEventBus modEventBus) {
        FEATURES.register(modEventBus);


    }
}
