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
	
	public JsonObject getObjectFromElement(String element) {
		Gson gson = new Gson();
		JsonObject jsonobject = gson.fromJson(json, JsonObject.class);
		jsonobject = jsonobject.get(element).getAsJsonObject();
		return jsonobject;
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
	
	public ArrayList<JsonObject> getListFromJsonArray(JsonArray jasonArray) {
		int j = 0;
		ArrayList<JsonObject> x = new ArrayList<JsonObject>();
		do {
			JsonObject y = jasonArray.get(j).getAsJsonObject();
			x.add(y);
		} while(!(jasonArray.isJsonNull()));
		
		return x;
	}
	
	public String getStringFromObject(JsonObject jasonObject, String element) {
		String str = jasonObject.get(element).getAsString();
		return str;
	}
	
	public int getIntFromObject(JsonObject jasonObject, String element) {
		int in = jasonObject.get(element).getAsInt();
		return in;
	}
	
	public double getDoubleFromObject(JsonObject jsonobject, String element) {
		double dou = jsonobject.get(element).getAsDouble();
		return dou;
	}
	
	public JsonArray getArrayFromJsonObject(JsonObject jasonObject) {
		JsonArray ja = jasonObject.getAsJsonArray();
		return ja;
	}
	
	public boolean checkForElement(String element) {
		Gson gson = new Gson();
		JsonObject jo = gson.fromJson(json,JsonObject.class);
		return jo.has(element);
	}
}
