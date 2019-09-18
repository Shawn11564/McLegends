package dev.mrshawn.mclegends.files;

import dev.mrshawn.mclegends.McLegends;
import dev.mrshawn.mclegends.utils.Chat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONFile {

	private File file;
	private BufferedWriter writer;
	private JSONParser parser;
	private JSONObject jsonObject;

	public JSONFile(String fileName) {
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + fileName + ".json");
		init();
	}

	public JSONFile(String fileName, String folderName) {
		file = new File(McLegends.getInstance().getDataFolder() + File.separator + folderName + File.separator + fileName + ".json");
		init();
	}

	private void init() {
		parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(file));
			jsonObject = (JSONObject) obj;
			writer = new BufferedWriter(new FileWriter(file));
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

	public void set(String key, String newValue) {
		if (get(key) != null) {
			jsonObject.remove(key);
		}
		jsonObject.put(key, newValue);
		write();
	}

	public void setArray(String key, String... newValues) {
		if (get(key) != null) {
			jsonObject.remove(key);
		}
		JSONArray array = new JSONArray();
		array.addAll(Arrays.asList(newValues));
		jsonObject.put(key, array);
		write();
	}

	public void write() {
		try {
			writer.write(jsonObject.toJSONString());
			writer.flush();
		} catch (final IOException e) {
			Chat.log("&4Unable to write to: &6:" + file.getName());
		}
	}

	public boolean save() {
		try {
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
