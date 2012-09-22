package timberman.RegionGuard.commands.land;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class help {
	public static void execute (CommandSender sender, String[] args) {
		// Show ingame help
		if (!(sender instanceof Player)) {
			sender.sendMessage("Console Help!");
		}
		
		else {
			sender.sendMessage("Ingame help!");
		}
		
	}
}
