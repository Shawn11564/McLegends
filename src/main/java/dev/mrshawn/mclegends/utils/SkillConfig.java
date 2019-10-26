package dev.mrshawn.mclegends.utils;

import dev.mrshawn.mclegends.McLegends;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SkillConfig {

	private McLegends main;
	private FileConfiguration config;
	private Map<String, ConfigurationSection> sections;

	public SkillConfig(McLegends main) {
		this.main = main;
		config = YamlConfiguration.loadConfiguration(new File(main.getDataFolder() + File.separator + "skills.yml"));
		sections = new HashMap<>();
		for (String title : config.getKeys(false)) {
			sections.put(title, config.getConfigurationSection(title));
		}
	}

	public boolean isEnabled(String skill) {
		return sections.get(skill).getBoolean("enabled");
	}

	public boolean enabledForPVP(String skill) {
		return sections.get(skill).getBoolean("enabled-for-pvp");
	}

	public boolean enabledForPVE(String skill) {
		return sections.get(skill).getBoolean("enabled-for-pve");
	}

	public int getMaxLevel(String skill) {
		return sections.get(skill).getInt("maxlevel");
	}

}
