package timberman.RegionGuard;

import org.bukkit.Chunk;

public class protectedChunk {
	public Chunk chunk;
	public int x;
	public int z;
	public boolean PVP;
	public boolean EndermanBlockDamage;

	public protectedChunk(Chunk chunk) {
		this.chunk = chunk;
	}
	
	
	
	private String chunkName (Chunk chunk) {
		return chunk.getX() + "_" + chunk.getZ();
	}
}
