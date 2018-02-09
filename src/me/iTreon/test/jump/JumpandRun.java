package me.iTreon.test.jump;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class JumpandRun implements Listener {
	
	@EventHandler
	public void on(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getLocation().getBlock().getType() == Material.GOLD_PLATE) {
			if(p.getLocation().subtract(80, 10, 80).getBlock().getType() == Material.REDSTONE_BLOCK) {
			
				Vector v = p.getLocation().getDirection().multiply(1.50).setY(10);
				p.setVelocity(v);
				
				p.playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_DEATH, 1F, 1F);
				
				p.setFallDistance(-999F);
			}
		}
		
	}

}
