package net.wkdr.prettyflames.mixin;

import net.fabricmc.fabric.api.attachment.v1.AttachmentTarget;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.wkdr.prettyflames.FlameAttachments;
import net.wkdr.prettyflames.FlameType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin implements AttachmentTarget {

    @Shadow
    public abstract boolean fireImmune();

    @Inject(method = "lavaIgnite", at = @At("HEAD"))
    public void prettyFlames$lavaIgnite(CallbackInfo ci) {
        if (!fireImmune()) {
            setAttached(FlameAttachments.FLAME_TYPE_VALUE, FlameType.Normal);
        }
    }

}
