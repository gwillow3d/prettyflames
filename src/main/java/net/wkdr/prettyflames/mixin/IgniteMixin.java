package net.wkdr.prettyflames.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.Ignite;
import net.minecraft.world.phys.Vec3;
import net.wkdr.prettyflames.FlameType;
import net.wkdr.prettyflames.FlameAttachments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Ignite.class)
public class IgniteMixin {

    @Inject(method = "apply", at = @At("TAIL"))
    public void prettyFlames$apply(ServerLevel serverLevel, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 position, CallbackInfo ci) {
        FlameType type = FlameType.Normal;
        if(enchantmentLevel > 1) type = enchantmentLevel == 2 ? FlameType.Soul : FlameType.Copper;
        entity.setAttached(FlameAttachments.FLAME_TYPE_VALUE, type);
    }

}
