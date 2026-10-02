package net.wkdr.prettyflames.tags;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class PrettyFlamesBlockTags {

    public static void init() {}

    public static final TagKey<Block> COPPER_FIRE_BURN_INDEFINITELY;
    public static final TagKey<Block> COPPER_FIRE_IGNITABLE;

    static {
        COPPER_FIRE_BURN_INDEFINITELY = PrettyFlamesBlockItemTags.COPPER_FIRE_BURN_INDEFINITELY.block();
        COPPER_FIRE_IGNITABLE = PrettyFlamesBlockItemTags.COPPER_FIRE_IGNITABLE.block();
    }

}
