package net.wkdr.prettyflames.client.mixin;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.feature.FeatureFrameContext;
import net.minecraft.client.renderer.feature.FlameFeatureRenderer;
import net.minecraft.client.renderer.feature.RenderTypeFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelBakery;
import net.wkdr.prettyflames.FlameType;
import net.wkdr.prettyflames.FlameAttachments;
import net.wkdr.prettyflames.client.PrettyFlamesClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(FlameFeatureRenderer.class)
public abstract class FlameFeatureRendererMixin extends RenderTypeFeatureRenderer<FlameFeatureRenderer.Submit>  {

    @Shadow
    private void prepare(final FlameFeatureRenderer.Submit submit, final VertexConsumer buffer, final TextureAtlasSprite fire1, final TextureAtlasSprite fire2) {}

    @Inject(method = "buildGroup", at = @At("HEAD"), cancellable = true)
    protected void prettyFlames$buildGroup(FeatureFrameContext context, List<FlameFeatureRenderer.Submit> submits, CallbackInfo ci) {
        ci.cancel();

        VertexConsumer builder = getVertexBuilder(RenderTypes.entityCutoutCull(TextureAtlas.LOCATION_BLOCKS));
        TextureAtlasSprite fire1 = context.atlasManager().get(ModelBakery.FIRE_0);
        TextureAtlasSprite fire2 = context.atlasManager().get(ModelBakery.FIRE_1);
        TextureAtlasSprite soulFire1 = context.atlasManager().get(PrettyFlamesClient.SOUL_FIRE_0);
        TextureAtlasSprite soulFire2 = context.atlasManager().get(PrettyFlamesClient.SOUL_FIRE_1);
        TextureAtlasSprite copperFire1 = context.atlasManager().get(PrettyFlamesClient.COPPER_FIRE_0);
        TextureAtlasSprite copperFire2 = context.atlasManager().get(PrettyFlamesClient.COPPER_FIRE_1);

        for (FlameFeatureRenderer.Submit submit : submits) {
            FlameType state = submit.entityRenderState().getData(FlameAttachments.BURNING_STATE);
            if(state == FlameType.Soul) {
                this.prepare(submit, builder, soulFire1, soulFire2);
            } else if(state == FlameType.Copper) {
                this.prepare(submit, builder, copperFire1, copperFire2);
            }
            else {
                this.prepare(submit, builder, fire1, fire2);
            }
        }
    }
}
