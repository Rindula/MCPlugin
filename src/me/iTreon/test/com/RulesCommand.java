package me.iTreon.test.com;

import java.io.File;
import java.io.IOException;

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
				File f = new File("plugins/" + plugin.getName() + "/rules.txt");
				if (!f.exists() && f.canWrite()) {
					try {
						f.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						m.sendError(p, "Regeldatei existiert nicht, und kann nicht angelegt werden!");
					}
				}
				return false;
			}
					
				}
				
				
			
		
		
		return false;
	}

}
