package me.iTreon.test.com;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import me.iTreon.test.main.Main;

public class Messager {

	private Main plugin;

	public Messager(Main p) {
		this.plugin = p;
	}
	
	public void sendMessage(CommandSender c, String message) {
		String prefix = plugin.getConfig().getString("general.prefix") + ChatColor.RESET;
		c.sendMessage(prefix + " " + ChatColor.GREEN + message);
	}
	
	public String getPrefix() {
		return plugin.getConfig().getString("general.prefix") + ChatColor.RESET;
	}

}
