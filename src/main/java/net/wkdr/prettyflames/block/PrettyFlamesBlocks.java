package net.wkdr.prettyflames.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class PrettyFlamesBlocks {

    public static void init() {}

    public static final Block COPPER_FIRE;
    public static final Block SULFUR_FIRE;

    static {
        COPPER_FIRE = register(PrettyFlamesBlockIds.COPPER_FIRE_BLOCK, CopperFireBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).replaceable().noCollision().instabreak().lightLevel((_) -> 7).sound(SoundType.WOOL).pushReaction(PushReaction.POPPED));
        SULFUR_FIRE = register(PrettyFlamesBlockIds.SULFUR_FIRE_BLOCK, SulfurFireBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).replaceable().noCollision().instabreak().lightLevel((_) -> 14).sound(SoundType.WOOL).pushReaction(PushReaction.POPPED));
    }

    private static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        Block block = blockFactory.apply(properties.setId(id));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

}
