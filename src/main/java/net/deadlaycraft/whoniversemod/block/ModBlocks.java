package net.deadlaycraft.whoniversemod.block;

import net.deadlaycraft.whoniversemod.WhoniverseMod;
import net.deadlaycraft.whoniversemod.item.ModItems;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.BlockItem;

import java.util.Iterator;
import java.util.function.Supplier;

public class ModBlocks extends Blocks{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WhoniverseMod.MOD_ID);
    private BlockState defaultBlockState;


    //wood logs
    public static Block log(MapColor pTopMapColor, MapColor pSideMapColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? pTopMapColor : pSideMapColor;
        }).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
    }

    public static final RegistryObject<Block> REDRITE_WIRE = registerBlock("redrite_wire",
            () -> new RedStoneWireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WIRE))); // a field which assigns itself a value which is the result of a method
    public static final RegistryObject<Block> REDRITE_BLOCK = registerBlock("redrite_block",
            () -> new PoweredBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final RegistryObject<Block> SAFFRITE_BLOCK = registerBlock("saffrite_block",
            () -> new PoweredBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
    public static final RegistryObject<Block> SOLITITE = registerBlock("solitite",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final RegistryObject<Block> GALLIFREYAN_SOIL = registerBlock("gallifreyan_soil",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final RegistryObject<Block> GALLIFREYAN_GRASS_BLOCK = registerBlock("gallifreyan_grass_block",
            () -> new GallifreyanGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<Block> RADIANT_OAK_LOG = registerBlock("radiant_oak_log",
                () -> log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> RADIANT_LEAVES = registerBlock("radiant_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES)));
    public static final RegistryObject<Block> RADIANT_OAK_SAPLING = registerBlock("radiant_oak_sapling",
            () -> new SaplingBlock(TreeGrower.CHERRY,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SAFFRITE_ORE = registerBlock("saffrite_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final RegistryObject<Block> RADIANT_OAK_PLANKS = registerBlock("radiant_oak_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block); // registering the
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        // "T" allows the method to be used with any block type
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
