package me.iTreon.test.com;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RulesCommand implements CommandExecutor {

	JavaPlugin plugin;
	private Messager m;
	
	public RulesCommand(JavaPlugin p, Messager m) {
		this.plugin = p;
		this.m = m;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				
				m.sendMessage(p, "sssssssss");
				m.sendMessage(p, "sssssssss");
				m.sendMessage(p, "sssssssss");
				m.sendMessage(p, "sssssssss");
				m.sendMessage(p, "sssssssss");
				return false;
			}
					
				}
				
				
			
		
		
		return false;
	}

}
