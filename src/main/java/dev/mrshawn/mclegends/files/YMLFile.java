package dev.mrshawn.mclegends.files;

import dev.mrshawn.mclegends.McLegends;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.List;

public class YMLFile {

	private File file;
	private File directory;
	private FileConfiguration config;

	public YMLFile(String fileName) {
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + fileName + ".yml");
		init();
	}

	public YMLFile(String fileName, String folderName) {
		directory = new File(McLegends.getInstance().getDataFolder() + File.separator + folderName);
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + folderName + File.separator + fileName + ".yml");
		init();
	}

	private void init() {
		if (!file.exists()) {
			YMLFileCreator creator;
			if (directory != null) {
				creator = new YMLFileCreator(file, directory);
			} else {
				creator = new YMLFileCreator(file);
			}
			creator.make();
		}
	}

	public String getString(String path) {
		return config.getString(path);
	}

	public List<String> getStringList(String path) {
		return config.getStringList(path);
	}

	public int getInt(String path) {
		return config.getInt(path);
	}

	public double getDouble(String path) {
		return config.getDouble(path);
	}

	public void setString(String path, String value) {
		config.set(path, value);
	}

	public void setList(String path, String... values) {
		config.set(path, values);
	}

	public void setInt(String path, int value) {
		config.set(path, value);
	}

	public void setDouble(String path, double value) {
		config.set(path, value);
	}

}
