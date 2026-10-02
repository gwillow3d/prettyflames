package net.wkdr.prettyflames.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.wkdr.prettyflames.tags.PrettyFlamesBlockTags;

public class SulfurFireBlock extends BaseFireBlock {
    public SulfurFireBlock(final Properties properties) {
        super(properties, 3.0f);
    }

    protected BlockState updateShape(final BlockState state, final LevelReader level, final ScheduledTickAccess ticks, final BlockPos pos, final Direction directionToNeighbour, final BlockPos neighbourPos, final BlockState neighbourState, final RandomSource random) {
        return this.canSurvive(state, level, pos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
    }

    protected boolean canSurvive(final BlockState state, final LevelReader level, final BlockPos pos) {
        return canSurviveOnBlock(level.getBlockState(pos.below()));
    }

    public static boolean canSurviveOnBlock(final BlockState state) {
        return state.is(PrettyFlamesBlockTags.SULFUR_IGNITABLE);
    }

    protected boolean canBurn(final BlockState state) {
        return true;
    }
}
