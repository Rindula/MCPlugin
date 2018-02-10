package me.iTreon.test.com;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RulesCommand2 implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				
				p.sendMessage("§4sssssssss");
				p.sendMessage("§4sssssssss");
				p.sendMessage("§4sssssssss");
				p.sendMessage("§4sssssssss");
				p.sendMessage("§4sssssssss");
				return false;
			}
					
				}
				
				
			
		
		
		return false;
	}

}
