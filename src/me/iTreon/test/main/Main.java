package me.iTreon.test.main;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.iTreon.test.Events.Event;
import me.iTreon.test.Events.TeleportHandler;
import me.iTreon.test.com.GameCommand;
import me.iTreon.test.com.HealCommand;
import me.iTreon.test.com.IItemscomm;
import me.iTreon.test.com.MuteCommand;
import me.iTreon.test.com.RulesCommand;
import me.iTreon.test.com.TeleportCommand;
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
		getCommand("rules").setExecutor(new MuteCommand(this, m));
		getCommand("tp").setExecutor(new TeleportCommand(this, m));
		
		// Events
		if (config.getBoolean("JumpAndRun.enabled"))
			new JumpandRun(this);
		
		if (config.getBoolean("JoinLeaveMessages.enabled"))
			new Event(this);
		
		if (config.getBoolean("TeleportHandler.HorsesAndLamas.enabled"))
			new TeleportHandler(this, m);
		
		System.out.println(ChatColor.stripColor(m.getPrefix() + " Geladen"));
	}
	
	private void loadConfig() {
		config.addDefault("general.prefix", ChatColor.DARK_RED + "[" + this.getName() + "]");
		config.addDefault("JumpAndRun.enabled", false);
		config.addDefault("JoinLeaveMessages.enabled", false);
		config.addDefault("TeleportHandler.HorsesAndLamas.enabled", true);
		config.addDefault("teleport.time", 100);
		config.options().copyDefaults(true);
		saveConfig();
	}

	private void createRules() {
	}
}
