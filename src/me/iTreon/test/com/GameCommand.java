package me.iTreon.test.com;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GameCommand implements CommandExecutor {
	
	private JavaPlugin plugin;
	private Messager m;
	
	public GameCommand(JavaPlugin p, Messager m) {
		this.plugin = p;
		this.m = m;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p =(Player) sender;
			if(args.length == 0) {
			if(command.getName().equalsIgnoreCase("gm")) {
			if(p.hasPermission("test.gmc")) {
			if(p.getGameMode() == GameMode.CREATIVE) {
				p.setGameMode(GameMode.SURVIVAL);
				m.sendMessage(p, "�aDu bist in SURVIVAL Modus");
				return true;
		} 
		

		if(p.hasPermission("test.gmc")) {
		if(p.getGameMode() == GameMode.SURVIVAL);
			p.setGameMode(GameMode.CREATIVE);
			m.sendMessage(p, "�aDu bist in Creative Modus");
			System.err.println(p.getName() + " ist jetzt im Creative Modus");
		return true;
			}
			
			}else {
				m.sendMessage(p, "�4Du hast kein Rechte daf�r");
				return true;
		}
		
	
			}
		}
			
		
			}
		return false;
		
}
}

