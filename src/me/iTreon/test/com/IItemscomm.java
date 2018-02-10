package me.iTreon.test.com;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class IItemscomm implements CommandExecutor{

	JavaPlugin plugin;
	private Messager m;
	
	public IItemscomm(JavaPlugin p, Messager m) {
		this.plugin = p;
		this.m = m;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("test.items")) {
				if(args.length == 0) {
					
					Inventory inv = Bukkit.createInventory(p, 9 * 4,"Rucksack" );
					p.openInventory(inv);
					m.sendMessage(p, "Du hast das Inventory geöffnet");
					
					
				} else 
					m.sendMessage(p, "Dieser Command Funktoniert nicht!");
		
		}else 
			m.sendMessage(p, "Dazu hast du keine rechte");
		}
		
		return false;
	}

}
