package net.wkdr.prettyflames.mixin;

import net.fabricmc.fabric.api.attachment.v1.AttachmentTarget;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.phys.EntityHitResult;
import net.wkdr.prettyflames.FlameAttachments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractArrow.class)
public class AbstractArrowMixin implements AttachmentTarget {

    @Inject(method = "onHitEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;igniteForSeconds(F)V"))
    protected void prettyFlames$onHitEntity(EntityHitResult hitResult, CallbackInfo ci) {
        Entity entity = hitResult.getEntity();
        entity.setAttached(FlameAttachments.FLAME_TYPE_VALUE, getAttached(FlameAttachments.FLAME_TYPE_VALUE));
    }

}
