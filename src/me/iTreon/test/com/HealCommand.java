package me.iTreon.test.com;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				if(p.hasPermission("test.heal.self")) {
				p.setHealth(20);
				p.setFoodLevel(20);
				p.sendMessage("§aDu wurdest geheilt!");
			} else 
				p.sendMessage("§4Dazu hast du keine Rechte!");
				
			} else if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target.hasPermission("test.heal.other"));
					target.setHealth(20);
					target.setFoodLevel(20);
					target.sendMessage("§aDu wurdest von §6" + target.getName() +" §7geheilt");
					p.sendMessage("ssssdu hast §6" + target.getName() +"ss");
					
				} else {
					p.sendMessage("§cDieser §7Spieler §cist nicht online!");
				}
				
			} else {
				p.sendMessage("§cDieser Command funktioniert nicht!");
			}

		}

		return false;
	}

}
