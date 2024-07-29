package net.deadlaycraft.whoniversemod.worldgen;

import net.deadlaycraft.whoniversemod.WhoniverseMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.lang.reflect.Constructor; // importing a reflector, because "ResourceLocation" is private.


public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SAFFRITE_ORE_KEY = registerKey("saffrite_ore");

    public static void bootstrip(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneRepaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepSlateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    }

    // REFLECTION IS USED TO BYPASS THE PRIVATE STATUS OF THE METHOD
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) { // method
        try { // trying the following code, and catching the error related to the method being private
           Class<?>  modResourceLocation = ResourceLocation.class;
            /* - <?> is a wildcard representing any class type
               - the "Class<?> modResourceLocation" instance acts as a window into the "ResourceLocation" class, allowing the program to see the code inside it */
           Constructor<?> resourceLocationConstructor = modResourceLocation.getDeclaredConstructor(String.class, String.class);
           // The same as the above line, but now it acts as a spyglass, zooming in on the constructor
            resourceLocationConstructor.setAccessible(true);
            // access to the private method is temporarily given for the duration of the reflection
            ResourceLocation resourceLocation = (ResourceLocation) resourceLocationConstructor.newInstance(WhoniverseMod.MOD_ID, name);
            /* - "resourceLocationConstructor.newInstance()" - using "resourceLocationInstructor" (established earlier) to create a new instance
               - "(ResourceLocation)" - this new instance is then cast to "ResourceLocation" data type */
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, resourceLocation);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
      context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
