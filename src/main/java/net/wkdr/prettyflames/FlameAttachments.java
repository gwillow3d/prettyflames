package net.wkdr.prettyflames;

import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.fabricmc.fabric.api.client.rendering.v1.RenderStateDataKey;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.level.block.SoulFireBlock;

public class FlameAttachments {

    public static void init() {}

    public static final RenderStateDataKey<FlameType> BURNING_STATE =
            RenderStateDataKey.create(() -> PrettyFlames.MOD_ID + ":burning_state");

    public static final AttachmentType<FlameType> FLAME_TYPE_VALUE = AttachmentRegistry.create(
            PrettyFlames.id("flame_type"),
            burningTypeBuilder -> burningTypeBuilder
                    .initializer(() -> FlameType.Normal)
                    .persistent(FlameType.CODEC)
                    .syncWith(
                            ByteBufCodecs.idMapper(i -> FlameType.values()[i], FlameType::ordinal),
                            AttachmentSyncPredicate.all()
                    )
    );

}
