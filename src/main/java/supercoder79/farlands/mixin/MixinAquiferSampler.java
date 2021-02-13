package supercoder79.farlands.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.world.gen.AquiferSampler;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;

@Mixin(AquiferSampler.class)
public class MixinAquiferSampler {
	@Shadow private int waterLevel;

	@Shadow @Final private ChunkGeneratorSettings settings;

	/**
	 * Aquifer generation fails in the far lands. Doing this as a hack fix
	 * @author SuperCoder79
	 */
	@Overwrite
	public void apply(int x, int y, int z) {
		this.waterLevel = this.settings.getSeaLevel();
	}
}
