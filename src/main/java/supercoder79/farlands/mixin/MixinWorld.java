package supercoder79.farlands.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(World.class)
public class MixinWorld {

	/**
	 * @author SuperCoder79
	 */
	@Overwrite
	private static boolean isValidHorizontally(BlockPos pos) {
		return pos.getX() >= Integer.MIN_VALUE && pos.getZ() >= Integer.MIN_VALUE && pos.getX() < Integer.MAX_VALUE && pos.getZ() < Integer.MAX_VALUE;
	}

	/**
	 * @author SuperCoder79
	 */
	@Overwrite
	private static boolean isInvalidVertically(int y) {
		return y < Integer.MIN_VALUE || y >= Integer.MAX_VALUE;
	}
}
