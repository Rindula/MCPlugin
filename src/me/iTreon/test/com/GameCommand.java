package me.iTreon.test.com;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		if(sender instanceof Player) {
			Player p =(Player) sender;
			if(args.length == 0) {
			if(command.getName().equalsIgnoreCase("gm")) {
			if(p.hasPermission("test.gmc")) {
			if(p.getGameMode() == GameMode.CREATIVE) {
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage("§aDu bist in SURVIVAL Modus");
				return true;
		} 
		

		if(p.hasPermission("test.gmc")) {
		if(p.getGameMode() == GameMode.SURVIVAL);
			p.setGameMode(GameMode.CREATIVE);
			p.sendMessage("§aDu bist in Creative Modus");
		return true;
			}
			
			}else {
				p.sendMessage("§4Du hast kein Rechte dafür");
				return true;
		}
		
	
			}
		}
			
		
			}
		return false;
		
}
}

