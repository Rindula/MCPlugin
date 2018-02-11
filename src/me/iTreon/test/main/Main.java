package me.iTreon.test.main;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.iTreon.test.Events.Event;
import me.iTreon.test.Events.TeleportHandler;
import me.iTreon.test.com.GameCommand;
import me.iTreon.test.com.HealCommand;
import me.iTreon.test.com.IItemscomm;
import me.iTreon.test.com.RulesCommand;
import me.iTreon.test.jump.JumpandRun;

public class Main extends JavaPlugin {

	FileConfiguration config = this.getConfig();
	
	public void onEnable() {
		
		Messager m = new Messager(this);
		
		loadConfig();
		createRules();
		// Commands
		getCommand("heal").setExecutor(new HealCommand(this, m));
		getCommand("items").setExecutor(new IItemscomm(this, m));
		getCommand("gm").setExecutor(new GameCommand(this, m));
		getCommand("rules").setExecutor(new RulesCommand(this, m));
		
		// Events
		new JumpandRun(this);
		new Event(this);
		new TeleportHandler(this, m);
		
		System.out.println(ChatColor.stripColor(m.getPrefix() + " Geladen"));
	}
	
	private void loadConfig() {
		config.addDefault("general.prefix", ChatColor.DARK_RED + "[" + this.getName() + "]");
		config.options().copyDefaults(true);
		saveConfig();
	}

	private void createRules() {
	}
}
