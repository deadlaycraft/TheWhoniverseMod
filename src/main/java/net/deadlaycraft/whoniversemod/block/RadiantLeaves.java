package net.deadlaycraft.whoniversemod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RadiantLeaves extends LeavesBlock {


    public RadiantLeaves(Properties p_54422_) {
        super(p_54422_);

    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        return 15;
    }

}
