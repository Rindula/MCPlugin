package me.iTreon.test.Events;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Event implements Listener {

	public Event(JavaPlugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		String[] messages = new String[]{
				e.getPlayer().getName() + " ist dem Spiel beigetreten",
				"Wir haben zuwachs! " + e.getPlayer().getName() + " ist dazugekommen",
				e.getPlayer().getName() + " tritt der Party bei",
				e.getPlayer().getName() + " erscheint",
				"Rosen sind Rot, Feilchen sind Blau, und " + e.getPlayer().getName() + " bleibt auch diesem Server treu"
		};
		e.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + getRandom(messages));
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		String[] messages = new String[]{
				e.getPlayer().getName() + " hat das Spiel verlassen",
				"Wir haben " + e.getPlayer().getName() + " verloren!",
				e.getPlayer().getName() + " geht zum Ende der Welt"
		};
		e.setQuitMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "-" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + getRandom(messages));
	}

	public String getRandom(String[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}

}
