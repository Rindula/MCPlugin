package me.iTreon.test.main;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Messager {

	private JavaPlugin plugin;

	public Messager(JavaPlugin p) {
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

	public void sendDebug(CommandSender c, String message) {
		String prefix = plugin.getConfig().getString("general.prefix") + ChatColor.RESET;
		c.sendMessage(prefix + " " + ChatColor.AQUA + "[DEBUG] " + ChatColor.GOLD + message);
	}

}
