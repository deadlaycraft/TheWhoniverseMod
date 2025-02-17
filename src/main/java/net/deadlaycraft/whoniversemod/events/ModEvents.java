package net.deadlaycraft.whoniversemod.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {


    @SubscribeEvent
    public static void BreakBlock(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        Level level = player.level();
        String blockName = event.getState().getBlock().getName().getString();
        if(blockName.equals("Glass")) {
        //player.playNotifySound(SoundEvents.EVOKER_PREPARE_WOLOLO,SoundSource.PLAYERS, 1.0F, 1.0F);
        level.playSound(null, player, SoundEvents.EVOKER_PREPARE_WOLOLO, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
    }
}