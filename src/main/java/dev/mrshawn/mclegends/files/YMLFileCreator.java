package dev.mrshawn.mclegends.files;

import dev.mrshawn.mclegends.McLegends;
import dev.mrshawn.mclegends.utils.Chat;

import java.io.File;
import java.io.IOException;

public class YMLFileCreator {

	private File file;
	private File directory;

	public YMLFileCreator(String fileName) {
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + fileName + ".yml");
	}

	public YMLFileCreator(String fileName, String folderName) {
		directory = new File(McLegends.getInstance().getDataFolder() + File.separator + folderName);
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + folderName + File.separator + fileName + ".yml");
	}

	public YMLFileCreator(File file) {
		this.file = file;
	}

	public YMLFileCreator(File file, File directory) {
		this.file = file;
		this.directory = directory;
	}

	public boolean make() {
		if (file.exists()) {
			return false;
		}
		if (directory != null) {
			if (!directory.exists()) {
				if (directory.mkdir()) {
					try {
						if (file.createNewFile()) {
							Chat.log("&aSuccessfully created file: &6" + file.getName());
							return true;
						}
					} catch (IOException e) {
						Chat.log("&4Unable to create file: &6" + file.getName());
						return false;
					}
				} else {
					Chat.log("&4Unable to create folder: &6" + directory.getName());
					return false;
				}
			}
		} else {
			if (!file.exists()) {
				try {
					if (file.createNewFile()) {
						Chat.log("&aSuccessfully created file: &6" + file.getName());
						return true;
					}
				} catch (IOException e) {
					Chat.log("&4Unable to create file: &6" + file.getName());
					return false;
				}
			}
		}
		return false;
	}

}
