package jsonreader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.*;
import org.apache.commons.io.FileUtils;

public class JsonReader {
	
	public String json;
	
	public JsonReader(String pathname) {
		File file = new File(pathname);
		String r = "";
		try {
			r = FileUtils.readFileToString(file,"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = r.replaceAll("\\s+","");
		json = str;
	}
	
	public JsonReader(File file) {
		String r = "";
		try {
			r = FileUtils.readFileToString(file,"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str = r.replaceAll("\\s+", "");
		json = str;
	}
	
	public JsonObject getObjectFromElement(String element) {
		Gson gson = new Gson();
		JsonObject jsonobject = gson.fromJson(json, JsonObject.class);
		jsonobject = jsonobject.get(element).getAsJsonObject();
		return jsonobject;
	}
	
	public JsonObject getObjectFromObjectElement(JsonObject jo, String element) {
		return jo.get(element).getAsJsonObject();
	}
	
	public String getStringFromElement(String element) {
		Gson gson = new Gson();
		JsonObject jsonobject = gson.fromJson(json, JsonObject.class);
		String str = jsonobject.get(element).getAsString();
		return str;
		
	}
	
	public int getIntFromElement(String element) {
		Gson gson = new Gson();
		JsonObject jsonobject = gson.fromJson(json, JsonObject.class);
		int a = jsonobject.get(element).getAsInt();
		return a;
	}
	
	public double getDoubleFromElement(String element) {
		Gson gson = new Gson();
		JsonObject jsonobject = gson.fromJson(json, JsonObject.class);
		double a = jsonobject.get(element).getAsDouble();
		return a;
	}
	
	public JsonArray getListFromElement(String element) {
		Gson gson = new Gson();
		JsonObject jsonobject = gson.fromJson(json, JsonObject.class);
		JsonArray a = jsonobject.get(element).getAsJsonArray();
		return a;
	}
	
	public ArrayList<JsonObject> getListFromJsonArray(JsonArray jsonArray) {
		int j = 0;
		ArrayList<JsonObject> x = new ArrayList<JsonObject>();
		do {
			JsonObject y = jsonArray.get(j).getAsJsonObject();
			x.add(y);
		} while(!(jsonArray.isJsonNull()));
		
		return x;
	}
	
	public String getStringFromObject(JsonObject jsonObject, String element) {
		String str = jsonObject.get(element).getAsString();
		return str;
	}
	
	public int getIntFromObject(JsonObject jsonObject, String element) {
		return jsonObject.get(element).getAsInt();
	}
	
	public double getDoubleFromObject(JsonObject jsonobject, String element) {
		double dou = jsonobject.get(element).getAsDouble();
		return dou;
	}
	
	public JsonArray getArrayFromObject(JsonObject jsonObject, String element) {
		JsonArray ja = jsonObject.get(element).getAsJsonArray();
		return ja;
	}
	
	public boolean checkForElement(String element) {
		Gson gson = new Gson();
		JsonObject jo = gson.fromJson(json,JsonObject.class);
		return jo.has(element);
	}
}
