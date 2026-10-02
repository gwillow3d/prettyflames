package net.wkdr.prettyflames.tags;

import net.minecraft.tags.BlockItemTagId;
import net.wkdr.prettyflames.PrettyFlames;

public class PrettyFlamesBlockItemTags {

    public static void init() {}

    public static final BlockItemTagId COPPER_FIRE_BURN_INDEFINITELY = create("copper_fire_burn_indefinitely");
    public static final BlockItemTagId COPPER_FIRE_IGNITABLE = create("copper_fire_ignitable");

    public static BlockItemTagId create(final String blockName) {
        return BlockItemTagId.create(PrettyFlames.id(blockName), PrettyFlames.id(blockName));
    }


}
