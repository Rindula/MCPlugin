package me.iTreon.test.com;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.iTreon.test.main.Messager;

public class HealCommand implements CommandExecutor {

	JavaPlugin plugin;
	private Messager m;

	public HealCommand(JavaPlugin p, Messager m) {
		this.plugin = p;
		this.m = m;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				if (p.hasPermission("test.heal.self")) {
					p.setHealth(20);
					p.setFoodLevel(20);
					m.sendMessage(p, "§aDu wurdest geheilt!");
				} else
					m.sendMessage(p, "§4Dazu hast du keine Rechte!");

			} else if (args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if (target != null) {
					if (target.hasPermission("test.heal.other"))
						;
					target.setHealth(20);
					target.setFoodLevel(20);
					target.sendMessage(m.getPrefix() + "§aDu wurdest von §6" + target.getName() + " §7geheilt");
					m.sendMessage(p, "Du hast §6" + target.getName() + " geheilt");

				} else {
					m.sendMessage(p, "§cDieser §7Spieler §cist nicht online!");
				}

			} else {
				m.sendMessage(p, "§cDieser Command funktioniert nicht!");
			}

		}

		return false;
	}

}
