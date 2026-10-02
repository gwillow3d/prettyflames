package net.wkdr.prettyflames.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.wkdr.prettyflames.PrettyFlames;

public class PrettyFlamesBlockIds {

    public static void init() {}

    public static final ResourceKey<Block> COPPER_FIRE_BLOCK = create("copper_fire");
    public static final ResourceKey<Block> SULFUR_FIRE_BLOCK = create("sulfur_fire");

    private static ResourceKey<Block> create(String name) {
        Identifier id = PrettyFlames.id(name);
        return ResourceKey.create(Registries.BLOCK, id);
    }

}
