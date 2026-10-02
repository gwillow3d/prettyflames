package net.wkdr.prettyflames.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.wkdr.prettyflames.FlameAttachments;
import net.wkdr.prettyflames.FlameType;
import net.wkdr.prettyflames.block.CopperFireBlock;
import net.wkdr.prettyflames.block.PrettyFlamesBlocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Type;

@Mixin(BaseFireBlock.class)
public class BaseFireBlockMixin {

    @Shadow
    @Final
    private float fireDamage;

    @Inject(method = "getState", at = @At("HEAD"), cancellable = true)
    private static void prettyflames$getState(BlockGetter level, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
        BlockPos below = pos.below();
        BlockState belowState = level.getBlockState(below);

        if (CopperFireBlock.canSurviveOnBlock(belowState)) {
            cir.setReturnValue(PrettyFlamesBlocks.COPPER_FIRE.defaultBlockState());
            cir.cancel();
        }
    }

    @Inject(method = "entityInside", at = @At("HEAD"))
    private void prettyFlames$entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise, CallbackInfo ci) {
        FlameType type = FlameType.Normal;
        if(fireDamage > 1.0f) {
            type = fireDamage == 2.0f ? FlameType.Soul : FlameType.Copper;
        }

        entity.setAttached(FlameAttachments.FLAME_TYPE_VALUE, type);
    }
}
