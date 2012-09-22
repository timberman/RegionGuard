package timberman.RegionGuard;

import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class RegionGuard extends JavaPlugin	{

	public WorldEditPlugin WorldEdit = null;
	public WorldGuardPlugin WorldGuard = null;
	public static Economy Economy = null;
	public static Permission Permissions = null;
	
	@Override
	public void onEnable() {
	
		setupEconomy();
		setupPermissions();
		setupWorldGuard();
		setupWorldEdit();
		logConsole ("enabled!");
	}
	
	@Override
	public void onDisable() {
		
		logConsole ("disabled!");
	}
	
	
	private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            Permissions = permissionProvider.getProvider();
            logConsole("hooked into Vault Permissions.");
        }
        return (Permissions != null);
    }
    private Boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            Economy = economyProvider.getProvider();
            logConsole("hooked into Vault Economy.");
        }
        return (Economy != null);
    }
	private boolean setupWorldGuard() {
        Plugin plugin = this.getServer().getPluginManager().getPlugin("WorldGuard");
        if (this.WorldGuard == null && plugin != null) {
                this.WorldGuard = (WorldGuardPlugin)plugin;
                logConsole("hooked into WorldGuard.");
        }
        return (this.WorldGuard != null);
	}
	
	private boolean setupWorldEdit() {
        Plugin plugin = this.getServer().getPluginManager().getPlugin("WorldEdit");
        if (this.WorldEdit == null && plugin != null) {
        	this.WorldEdit = (WorldEditPlugin)plugin;
        	logConsole("hooked into WorldEdit.");
        }
        return (this.WorldEdit != null);
	}
	
	public void logConsole (String msg) {
		Logger.getLogger("Minecraft").info("[" + this.getDescription().getName() + "] " + msg);
	}
	
}
