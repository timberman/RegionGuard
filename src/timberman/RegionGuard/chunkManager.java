package timberman.RegionGuard;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Chunk;

public class chunkManager {
	RegionGuard plugin;
	
	//private final ConcurrentMap<String, protectedWorld> worlds = new ConcurrentHashMap<String, protectedWorld>();
	private Map<String, protectedWorld> worlds = Collections.synchronizedMap(new HashMap<String, protectedWorld>());
	
	public chunkManager(RegionGuard plugin) {
		this.plugin = plugin;
	}
	
	public void loadChunk (Chunk chunk) {
		if (!this.worlds.containsKey(chunk.getWorld().getName().toLowerCase())) {
			worlds.put(chunk.getWorld().getName().toLowerCase(), new protectedWorld(chunk.getWorld().getName().toLowerCase()));
			worlds.get(chunk.getWorld().getName().toLowerCase()).getChunk(chunk);
		}
	}
	
	public void unloadChunk (Chunk chunk) {
		
	}
}
