package me.iTreon.test.com;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.iTreon.test.main.Messager;

public class GameCommand implements CommandExecutor {

	private Messager m;

	public GameCommand(JavaPlugin p, Messager m) {
		this.m = m;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				if (command.getName().equalsIgnoreCase("gm")) {
					if (p.hasPermission("test.gm")) {
						if (p.getGameMode() == GameMode.CREATIVE) {
							p.setGameMode(GameMode.SURVIVAL);
							m.sendMessage(p, "Du bist in SURVIVAL Modus");
							return true;
						}

						if (p.hasPermission("test.gm")) {
							if (p.getGameMode() == GameMode.SURVIVAL)
								;
							p.setGameMode(GameMode.CREATIVE);
							m.sendMessage(p, "Du bist in Creative Modus");
							System.err.println(p.getName() + " ist jetzt im Creative Modus");
							return true;
						}

					} else {
						m.sendError(p, "Du hast kein Rechte dafür");
						return true;
					}

				}
			}

		}
		return false;

	}
}
