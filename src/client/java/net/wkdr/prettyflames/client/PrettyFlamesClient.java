package net.wkdr.prettyflames.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.Hud;
import net.minecraft.client.player.FirstPersonHandsAndItems;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.PumpkinBlock;
import net.wkdr.prettyflames.PrettyFlames;

public class PrettyFlamesClient implements ClientModInitializer {

    public static final SpriteId SOUL_FIRE_0;
    public static final SpriteId SOUL_FIRE_1;

    public static final SpriteId COPPER_FIRE_0;
    public static final SpriteId COPPER_FIRE_1;

    static {
        SOUL_FIRE_0 = Sheets.BLOCKS_MAPPER.defaultNamespaceApply("soul_fire_0");
        SOUL_FIRE_1 = Sheets.BLOCKS_MAPPER.defaultNamespaceApply("soul_fire_1");
        COPPER_FIRE_0 = Sheets.BLOCKS_MAPPER.apply(PrettyFlames.id("copper_fire_0"));
        COPPER_FIRE_1 = Sheets.BLOCKS_MAPPER.apply(PrettyFlames.id("copper_fire_1"));
    }

    @Override
    public void onInitializeClient() {
    }
}
