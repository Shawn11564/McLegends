package dev.mrshawn.mclegends.files;

import dev.mrshawn.mclegends.McLegends;
import dev.mrshawn.mclegends.files.custom.PlayerFile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PlayerDataManager {

	private McLegends main;
	private Map<Player, PlayerFile> playerFiles;

	public PlayerDataManager(McLegends main) {
		this.main = main;
		playerFiles = new HashMap<>();
	}

	public void addPlayer(Player player) {
		playerFiles.put(player, new PlayerFile(player.getUniqueId().toString()));
	}

	public void addPlayer(String uuid) {
		playerFiles.put(Bukkit.getPlayer(uuid), new PlayerFile(uuid));
	}

	public PlayerFile getPlayerFile(Player player) {
		return playerFiles.get(player);
	}

	public PlayerFile getPlayerFile(String uuid) {
		return playerFiles.get(Bukkit.getPlayer(uuid));
	}

	public void removePlayer(Player player) {
		playerFiles.remove(player);
	}

	public void removePlayer(String uuid) {
		playerFiles.remove(Bukkit.getPlayer(uuid));
	}

	public boolean playerFileExists(Player player) {
		String uuid = player.getUniqueId().toString();
		return new File(McLegends.getInstance().getDataFolder() + File.separator + "PlayerData" + File.separator + uuid + ".yml").exists();
	}

	public boolean playerFileExists(String uuid) {
		return new File(McLegends.getInstance().getDataFolder() + File.separator + "PlayerData" + File.separator + uuid + ".yml").exists();
	}

}
