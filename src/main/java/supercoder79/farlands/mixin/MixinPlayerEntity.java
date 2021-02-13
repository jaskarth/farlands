package supercoder79.farlands.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;

@Mixin(PlayerEntity.class)
public class MixinPlayerEntity {
	@Redirect(method = "tick", at = @At(target = "Lnet/minecraft/util/math/MathHelper;clamp(DDD)D", value = "INVOKE"))
	private double redirectClamp(double value, double min, double max) {
		return MathHelper.clamp(value, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}
