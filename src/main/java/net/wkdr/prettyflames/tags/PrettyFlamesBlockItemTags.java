package net.wkdr.prettyflames.tags;

import net.minecraft.tags.BlockItemTagId;
import net.wkdr.prettyflames.PrettyFlames;

public class PrettyFlamesBlockItemTags {

    public static void init() {}

    public static final BlockItemTagId COPPER_IGNITABLE = create("copper_ignitable");
    public static final BlockItemTagId SULFUR_IGNITABLE = create("sulfur_ignitable");

    public static BlockItemTagId create(final String blockName) {
        return BlockItemTagId.create(PrettyFlames.id(blockName), PrettyFlames.id(blockName));
    }


}
