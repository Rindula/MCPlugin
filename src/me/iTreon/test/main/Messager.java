package me.iTreon.test.main;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Messager {

	private Main plugin;

	public Messager(Main p) {
		this.plugin = p;
	}
	
	public void sendMessage(CommandSender c, String message) {
		String prefix = plugin.getConfig().getString("general.prefix") + ChatColor.RESET;
		c.sendMessage(prefix + " " + ChatColor.GREEN + message);
	}
	
	public void sendError(CommandSender c, String message) {
		String prefix = plugin.getConfig().getString("general.prefix") + ChatColor.RESET;
		c.sendMessage(prefix + " " + ChatColor.RED + "[FEHLER] " + ChatColor.YELLOW + message);
	}
	
	public String getPrefix() {
		return plugin.getConfig().getString("general.prefix") + ChatColor.RESET;
	}

}
