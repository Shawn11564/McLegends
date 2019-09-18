package dev.mrshawn.mclegends.files;

import dev.mrshawn.mclegends.McLegends;
import dev.mrshawn.mclegends.utils.Chat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class JSONFileCreator {

	private File file, directory;
	private JSONObject jsonObject;

	public JSONFileCreator(String fileName) {
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + fileName + ".json");
	}

	public JSONFileCreator(String fileName, String folderName) {
		directory = new File(McLegends.getInstance().getDataFolder() + File.separator + folderName);
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + folderName + File.separator + fileName + ".json");
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
							jsonObject = new JSONObject();
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
						jsonObject = new JSONObject();
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

	public void put(String title, String value) {
		jsonObject.put(title, value);
	}

	public void putArray(String title, String... values) {
		JSONArray array = new JSONArray();
		array.addAll(Arrays.asList(values));
		jsonObject.put(title, array);
	}

	public boolean save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(jsonObject.toJSONString());
			writer.close();
			Chat.log("&aSuccessfully saved: &6" + file.getName());
			return true;
		} catch (final IOException e) {
			Chat.log("&4Unable to save: &6:" + file.getName());
			return false;
		}
	}

}
