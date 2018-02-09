package me.iTreon.test.com;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class MuteCommand implements CommandExecutor, Listener {

	private ArrayList<Player> mutedPlayers = new ArrayList<>();
	
	@EventHandler
	public void handelPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(mutedPlayers.contains(p)) {
			p.sendMessage("§f[§cDeliCraft§f]§cDu bist Gemuted");
			e.setCancelled(true);
		}
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String large, String[] agrs) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("test.mute")) {
				if(agrs.length == 1) {
		
			Player target = Bukkit.getPlayer(agrs[0]);
				if(target != null) {
					if(mutedPlayers.contains(target)) {
						mutedPlayers.add(target);
						p.sendMessage("§f[§cDeliCraft§f]§cDu hast den Spieler §6" + target.getName() + "§cgemuted!");
						target.sendMessage("§f[§cDeliCraft§f]§cDu wurdest gemuted");
					
					} else
						p.sendMessage("§f[§cDeliCraft§f]§cDu hast den Spieler §6" + target.getName() + "§centmuted!");
						target.sendMessage("§f[§cDeliCraft§f]§cDu wurdest entmuted");
					
				} else 
					p.sendMessage("§cDieser Spiler ist nicht online");
				
				} else 
					p.sendMessage("§cBitte benutze /mute <Player>");
		
		} else {
			p.sendMessage("§4Dazu hast du keine Rechte!");
		}
	}
		return false;

}
}