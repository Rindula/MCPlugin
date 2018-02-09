package me.iTreon.test.com;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class IItemscomm implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("test.items")) {
				if(args.length == 0) {
					
					Inventory inv = Bukkit.createInventory(null, 9 * 3,"§lssss" );
					p.openInventory(inv);
					p.sendMessage("§bDu hast das Inventory geöffnet");
					
					
				} else 
					p.sendMessage("§cDieser Command Funktoniert nicht!");
		
		}else 
			p.sendMessage("§cDazu hast du keine rechte");
		}
		
		return false;
	}

}
