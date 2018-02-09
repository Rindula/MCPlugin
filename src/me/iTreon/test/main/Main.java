package me.iTreon.test.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.iTreon.test.com.GameCommand;
import me.iTreon.test.com.HealCommand;
import me.iTreon.test.com.IItemscomm;

public class Main extends JavaPlugin {

	public void onEnable() {
		System.out.println("§aloaded");
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("items").setExecutor(new IItemscomm());
		getCommand("gm").setExecutor(new GameCommand());
	}

	
}
