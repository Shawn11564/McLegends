package dev.mrshawn.mclegends.files.creators;

import dev.mrshawn.mclegends.McLegends;
import dev.mrshawn.mclegends.utils.Chat;

import java.io.File;
import java.io.IOException;

public class YMLFileCreator {

	private File file;
	private File directory;

	/**
	 *
	 * @param fileName Name of the file to create
	 */
	public YMLFileCreator(String fileName) {
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + fileName + ".yml");
	}

	/**
	 *
	 * @param fileName Name of the file to create
	 * @param folderName Subfolder that the file should be created in
	 */
	public YMLFileCreator(String fileName, String folderName) {
		directory = new File(McLegends.getInstance().getDataFolder() + File.separator + folderName);
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + folderName + File.separator + fileName + ".yml");
	}

	/**
	 *
	 * @param file Create a new YML file with a predefined file name
	 */
	public YMLFileCreator(File file) {
		this.file = file;
	}

	/**
	 *
	 * @param file Create a new YML file with a predefined file name
	 * @param directory Predefined subfolder to put the file in
	 */
	public YMLFileCreator(File file, File directory) {
		this.file = file;
		this.directory = directory;
	}

	/**
	 *
	 * @return Returns true if the file was able to be created and false if it wasn't created
	 */
	public boolean make() {
		if (file.exists()) {
			return false;
		}
		if (directory != null) { // Run this block if a subfolder is provided
			if (!directory.exists()) {
				if (directory.mkdir()) { // Create the folder if it doesn't exist already
					try {
						if (file.createNewFile()) { // Create the file
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
		} else { // Run this block if there is no subfolder provided
			if (!file.exists()) {
				try {
					if (file.createNewFile()) { // Create the file
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
