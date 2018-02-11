package me.iTreon.test.Events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.iTreon.test.main.Messager;

public class TeleportHandler implements Listener {

	Messager m;
	final JavaPlugin plugin;

	public TeleportHandler(JavaPlugin plugin, Messager m) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
		this.m = m;
	}

	@EventHandler
	public void onPlayerTeleport(VehicleExitEvent e) {
		final Player p = (Player) e.getExited();
		final Entity v = e.getVehicle();
		
		Tameable t = (Tameable) v;
		
		if (p == null || v == null || p.isSneaking() || !t.isTamed())
			return;

		if (v.getType() == EntityType.HORSE || v.getType() == EntityType.LLAMA) {

			new BukkitRunnable() {
				public void run() {
					v.teleport(p);
					new BukkitRunnable() {
						public void run() {
							for (Entity pass : v.getPassengers()) {
								v.removePassenger(pass);
							}
							v.addPassenger(p);
						}
					}.runTaskLater(plugin, 20L);
				}
			}.runTaskLater(plugin, 1L);

			if (v.getType() == EntityType.HORSE) {
				m.sendMessage(p, "Du hast dein Pferd mitgenommen");
			} else {
				m.sendMessage(p, "Du hast dein Lama mitgenommen");
			}
		}
	}

}
