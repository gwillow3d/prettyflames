package net.wkdr.prettyflames;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.LavaFluid;
import net.wkdr.prettyflames.block.PrettyFlamesBlockIds;
import net.wkdr.prettyflames.block.PrettyFlamesBlocks;
import net.wkdr.prettyflames.tags.PrettyFlamesBlockItemTags;
import net.wkdr.prettyflames.tags.PrettyFlamesBlockTags;

public class PrettyFlames implements ModInitializer {

    public static final String MOD_ID = "prettyflames";

    @Override
    public void onInitialize() {
        FlameAttachments.init();
        PrettyFlamesBlockIds.init();
        PrettyFlamesBlocks.init();
        PrettyFlamesBlockTags.init();
        PrettyFlamesBlockItemTags.init();
    }

    public static Identifier id(String path) {
        return Identifier.tryBuild(MOD_ID, path);
    }

}
