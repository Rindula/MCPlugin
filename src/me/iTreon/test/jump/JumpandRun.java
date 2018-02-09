package me.iTreon.test.jump;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class JumpandRun implements Listener {
	
	public JumpandRun(JavaPlugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void on(PlayerMoveEvent e) {
		Player p = e.getPlayer();

		if(p.getLocation().getBlock().getType() == Material.GOLD_PLATE) {
			Block b = p.getLocation().getBlock();
			if( b.getLocation().add(new Vector(0, -1, 0).toLocation(p.getWorld())).getBlock().getType() == Material.REDSTONE_BLOCK) {
			
				Vector v = new Vector(0, 2, 0);
				p.setVelocity(v);
				
				p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_LAUNCH, 100F, 100F);
				
				p.setFallDistance(-999F);
			}
		}
		
	}

}
