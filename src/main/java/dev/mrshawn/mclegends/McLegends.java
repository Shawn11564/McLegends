package dev.mrshawn.mclegends;

import org.bukkit.plugin.java.JavaPlugin;

public final class McLegends extends JavaPlugin {

	private static McLegends instance;

	@Override
	public void onEnable() {
		instance = this;

	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static McLegends getInstance() {
		return instance;
	}
}
