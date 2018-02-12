package me.iTreon.test.com;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.iTreon.test.main.Messager;

public class TeleportCommand implements CommandExecutor {

	Messager m;
	final JavaPlugin plugin;

	public TeleportCommand(JavaPlugin p, Messager m) {
		this.m = m;
		this.plugin = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			int time = plugin.getConfig().getInt("teleport.time");
			PotionEffect effect = new PotionEffect(PotionEffectType.LEVITATION, time + 10, 2);
			
			switch (args.length) {
			case 1:
				p.addPotionEffect(effect, true);
				final Player t = plugin.getServer().getPlayerExact(args[0]);
				
				new BukkitRunnable() {
					public void run() {
						p.playSound(p.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 100, 1);
						p.teleport(t);
						p.removePotionEffect(PotionEffectType.LEVITATION);;
					}
				}.runTaskLater(plugin, (long) time);
				return true;
			case 2:
				final Player t1 = plugin.getServer().getPlayerExact(args[0]);
				final Player t2 = plugin.getServer().getPlayerExact(args[1]);
				
				t1.addPotionEffect(effect, true);
				
				new BukkitRunnable() {
					public void run() {
						t1.playSound(t1.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 100, 1);
						t1.teleport(t2);
						t1.removePotionEffect(PotionEffectType.LEVITATION);
					}
				}.runTaskLater(plugin, (long) time);
				return true;
			case 3:
				final double p1;
				final double p2;
				final double p3;
				try {
					p1 = Double.valueOf(args[0]);
					p2 = Double.valueOf(args[1]);;
					p3 = Double.valueOf(args[2]);;
				} catch (Exception e) {
					m.sendError(p, "Benutzung");
					return false;
				}
				
				p.addPotionEffect(effect, true);
				
				new BukkitRunnable() {
					public void run() {
						p.playSound(p.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 100, 1);
						p.teleport(new Location(p.getWorld(), p1, p2, p3));
						p.removePotionEffect(PotionEffectType.LEVITATION);
					}
				}.runTaskLater(plugin, (long) time);
				return true;
			case 4:
				final Player tg1 = plugin.getServer().getPlayerExact(args[0]);
				final double pos1;
				final double pos2;
				final double pos3;
				try {
					pos1 = Double.valueOf(args[1]);
					pos2 = Double.valueOf(args[2]);;
					pos3 = Double.valueOf(args[3]);;
				} catch (Exception e) {
					m.sendError(p, "Benutzung:");
					return false;
				}
				
				tg1.addPotionEffect(effect, true);
				
				new BukkitRunnable() {
					public void run() {
						tg1.playSound(tg1.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 100, 1);
						tg1.teleport(new Location(tg1.getWorld(), pos1, pos2, pos3));
						tg1.removePotionEffect(PotionEffectType.LEVITATION);
					}
				}.runTaskLater(plugin, (long) time);
				return true;
			default:
				return false;
			}

		}
		return false;
	}

}
