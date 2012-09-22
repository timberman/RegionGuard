package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import commands.land.*;

import timberman.RegionGuard.RegionGuard;

public class landcommands implements CommandExecutor {
	RegionGuard plugin;
	public landcommands(RegionGuard plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		
		if (command.getName().equalsIgnoreCase("land") && args.length == 0) {
			help.execute(sender, args);
			return true;
		}
		
		// BUY Command
		else if (command.getName().equalsIgnoreCase("land") && args.length > 0) {
			if (args[0].equalsIgnoreCase("buy") || args[0].equalsIgnoreCase("kaufen")) {
				buy.execute(sender, args);
				return true;
			}
		}
		help.execute(sender, args);
		return true;
	}

}
