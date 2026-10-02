package net.wkdr.prettyflames.tags;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class PrettyFlamesBlockTags {

    public static void init() {}

    public static final TagKey<Block> COPPER_IGNITABLE;
    public static final TagKey<Block> SULFUR_IGNITABLE;

    static {
        COPPER_IGNITABLE = PrettyFlamesBlockItemTags.COPPER_IGNITABLE.block();
        SULFUR_IGNITABLE = PrettyFlamesBlockItemTags.SULFUR_IGNITABLE.block();
    }

}
