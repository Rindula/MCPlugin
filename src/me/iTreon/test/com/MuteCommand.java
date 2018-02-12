package me.iTreon.test.com;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.iTreon.test.main.Messager;

public class MuteCommand implements CommandExecutor, Listener {

	private ArrayList<Player> mutedPlayers = new ArrayList<>();
	private Messager m;

	public MuteCommand(JavaPlugin p, Messager m) {
		this.m = m;
	}

	@EventHandler
	public void handelPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (mutedPlayers.contains(p)) {
			m.sendMessage(p, "Du bist Gemuted");
			e.setCancelled(true);
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String large, String[] agrs) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("test.mute")) {
				if (agrs.length == 1) {

					Player target = Bukkit.getPlayer(agrs[0]);
					if (target != null) {
						if (mutedPlayers.contains(target)) {
							mutedPlayers.add(target);
							m.sendMessage(p, ChatColor.RED + "Du hast den Spieler " + ChatColor.GOLD + target.getName()
									+ ChatColor.RED + " gemuted!");
							target.sendMessage(m.getPrefix() + ChatColor.RED + " Du wurdest gemuted");

						} else
							m.sendMessage(p, ChatColor.RED + "Du hast den Spieler " + ChatColor.GOLD + target.getName()
									+ ChatColor.RED + " gemuted!");
						target.sendMessage(m.getPrefix() + ChatColor.RED + " Du wurdest gemuted");

					} else
						m.sendError(p, "Dieser Spieler ist nicht online");

				}
			} else {
				m.sendError(p, "Dazu hast du keine Rechte!");
				return true;
			}
		}
		return false;

	}
}