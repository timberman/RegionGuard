package timberman.RegionGuard;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Chunk;

public class protectedWorld {
	public String WorldName;
	public boolean PVP;
	public boolean EndermanBlockDamage;
	
	//private final ConcurrentMap<protectedChunk, protectedChunk> chunks = new ConcurrentHashMap<protectedChunk, protectedChunk>();
	private Map<String, protectedChunk> chunks = Collections.synchronizedMap(new HashMap<String, protectedChunk>());
	
	public protectedWorld(String name) {
		this.WorldName = name;
	}
	
	public protectedChunk getChunks (Chunk chunk) {
		return (protectedChunk) this.chunks;
	}
	
	public protectedChunk getChunk (Chunk chunk) {
		if (!this.chunks.containsKey(chunkName(chunk))) {
			chunks.put(chunkName(chunk), new protectedChunk(chunk));
		}
		return null;
	}
		
	private String chunkName (Chunk chunk) {
		return chunk.getX() + "_" + chunk.getZ();
	}
	
}
