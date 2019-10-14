package dev.mrshawn.mclegends;

import co.aikar.commands.PaperCommandManager;
import dev.mrshawn.mclegends.files.PlayerDataManager;
import dev.mrshawn.mclegends.listeners.JoinLeaveEvent;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class McLegends extends JavaPlugin {

	private static McLegends instance;
	private PlayerDataManager playerDataManager;

	@Override
	public void onEnable() {
		registerClasses();
		registerEvents();
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public void registerClasses() {
		instance = this;
		playerDataManager = new PlayerDataManager(this);
	}

	public void registerEvents() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new JoinLeaveEvent(this), this);
	}

	public void registerCommands() {
		PaperCommandManager commandManager = new PaperCommandManager(this);
	}

	public static McLegends getInstance() {
		return instance;
	}
}
