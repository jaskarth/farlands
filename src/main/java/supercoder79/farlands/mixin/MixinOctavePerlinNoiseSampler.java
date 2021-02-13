package supercoder79.farlands.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.util.math.noise.OctavePerlinNoiseSampler;

@Mixin(OctavePerlinNoiseSampler.class)
public class MixinOctavePerlinNoiseSampler {

	/**
	 * @author SuperCoder79
	 */
	@Overwrite
	public static double maintainPrecision(double value) {
		return value;
	}
}
