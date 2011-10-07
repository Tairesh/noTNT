package ru.tairesh.bukkit;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class noTNT extends JavaPlugin {

	private Logger Log = Logger.getLogger("Minecraft");
	
	private noTNTBlockListener blockListener = new noTNTBlockListener(this);
	
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_PLACE, this.blockListener, Priority.Highest, this);
		pm.registerEvent(Event.Type.BLOCK_BREAK, this.blockListener, Priority.Highest, this);
		
		this.logMessage("Enabled.");
	}

	public void onDisable() {
		this.logMessage("Disabled.");
	}
	
	protected void logMessage(String msg) {
		PluginDescriptionFile pdFile = this.getDescription();
		this.Log.info(pdFile.getName() + " " + pdFile.getVersion() + ": " + msg);
	}
	
}
