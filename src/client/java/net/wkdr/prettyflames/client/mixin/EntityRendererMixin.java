package net.wkdr.prettyflames.client.mixin;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;
import net.wkdr.prettyflames.FlameAttachments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin<T extends Entity, S extends EntityRenderState> {

    @Inject(method = "extractRenderState", at = @At("TAIL"))
    public void prettyFlames$extractRenderState(T entity, S state, float partialTicks, CallbackInfo ci) {
        state.setData(FlameAttachments.BURNING_STATE, entity.getAttached(FlameAttachments.FLAME_TYPE_VALUE));
    }

}
