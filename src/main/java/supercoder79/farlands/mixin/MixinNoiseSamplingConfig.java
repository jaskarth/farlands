package supercoder79.farlands.mixin;

import com.mojang.serialization.Codec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.world.gen.chunk.NoiseSamplingConfig;

@Mixin(NoiseSamplingConfig.class)
public class MixinNoiseSamplingConfig {
	@Redirect(method = "<clinit>", at = @At(target = "Lcom/mojang/serialization/Codec;doubleRange(DD)Lcom/mojang/serialization/Codec;", value = "INVOKE"))
	private static Codec<Double> fixRange(double min, double max) {
		return Codec.doubleRange(min, 10000000); // changes it to be 0.001 to 10 million instead of 1 thousand
	}
}
