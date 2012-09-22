package listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

import timberman.RegionGuard.RegionGuard;

public class serverListener implements Listener {
	private RegionGuard plugin;

    public serverListener(RegionGuard plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void onChunkLoadEvent (ChunkLoadEvent event) {
    	plugin.getChunkManager().loadChunk(event.getChunk());
    }

    @EventHandler
    public void onChunkUnloadEvent (ChunkUnloadEvent event) {
    	plugin.getChunkManager().unloadChunk(event.getChunk());
    }
}
