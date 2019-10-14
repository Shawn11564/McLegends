package dev.mrshawn.mclegends.files.custom;

import dev.mrshawn.mclegends.files.creators.impl.YMLFile;
import org.bukkit.configuration.file.FileConfiguration;

public class PlayerFile {

	private YMLFile file;
	private FileConfiguration config;


	public PlayerFile(String uuid) {
		file = new YMLFile(uuid, "PlayerData");
	}

}
