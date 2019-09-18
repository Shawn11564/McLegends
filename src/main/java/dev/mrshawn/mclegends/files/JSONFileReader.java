package dev.mrshawn.mclegends.files;

import dev.mrshawn.mclegends.McLegends;
import dev.mrshawn.mclegends.utils.Chat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFileReader {

	private File file;
	private JSONParser parser;
	private JSONObject jsonObject;

	public JSONFileReader(String fileName) {
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + fileName + ".json");
		init();
	}

	public JSONFileReader(String fileName, String folderName) {
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + folderName + File.separator + fileName + ".json");
		init();
	}

	private void init() {
		parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(file));
			jsonObject = (JSONObject) obj;
		} catch (IOException | ParseException e) {
			Chat.log("&4Unable to parse: &6" + file.getName());
		}
	}

	public String get(String key) {
		return (String) jsonObject.get(key);
	}

	public List<String> getArray(String key) {
		List<String> list = new ArrayList<>();
		JSONArray array = (JSONArray) jsonObject.get(key);
		for (Object o : array) {
			list.add((String) o);
		}
		return list;
	}

}
