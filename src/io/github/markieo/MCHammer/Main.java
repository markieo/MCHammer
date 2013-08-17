package io.github.markieo.MCHammer;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	public void onEnable(){
		loadConfig();
		
		getLogger().info("MCHammer has been enabled!");
		getCommand("hammer").setExecutor(new CommandExec(this));
		getServer().getPluginManager().registerEvents(new HammerListener(), this);
	}
	public void onDisable(){
		getLogger().info("MCHammer has been disabled!");
	}
	public void loadConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
}
