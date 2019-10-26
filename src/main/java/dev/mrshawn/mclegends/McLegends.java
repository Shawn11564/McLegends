package dev.mrshawn.mclegends;

import co.aikar.commands.PaperCommandManager;
import dev.mrshawn.mclegends.files.PlayerDataManager;
import dev.mrshawn.mclegends.listeners.JoinLeaveEvent;
import dev.mrshawn.mclegends.utils.SkillConfig;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class McLegends extends JavaPlugin {

	private static McLegends instance;
	private PlayerDataManager playerDataManager;
	private SkillConfig skillConfig;

	@Override
	public void onEnable() {
		registerManagers();
		registerEvents();
		registerCommands();
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	private void registerManagers() {
		instance = this;
		skillConfig = new SkillConfig(this);
		playerDataManager = new PlayerDataManager(this);
	}

	private void registerEvents() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new JoinLeaveEvent(this), this);
	}

	private void registerCommands() {
		PaperCommandManager commandManager = new PaperCommandManager(this);
	}

	public static McLegends getInstance() {
		return instance;
	}
}
