package jsonreader;

import java.io.File;

import com.google.gson.JsonObject;

public class ItemReader {
	
	public JsonReader jr;
	public String json;
	
	public ItemReader(String filename) {
		String s = "src/assets/items/";
		String str = s + filename;
		jr = new JsonReader(str);
	}
	
	/**
	 * Generates a reader by random file inside of assets.items folder
	 */
	public ItemReader() {
		String s = "src/assets/items/";
		File a = new File(s);
		File[] u = a.listFiles();
		int y = (int) Math.random() * (u.length-1);
		File h = u[y];
		jr = new JsonReader(h);
	}
	
	public double returnWeightDoubles(String element) {
		JsonObject jo = jr.getObjectFromElement("weight");
		return jr.getDoubleFromObject(jo, element);
	}
	
	public double returnWeightMinimum() {
		return returnWeightDoubles("minimum");
	}
	
	public double returnWeightMaximum() {
		return returnWeightDoubles("maximum");
	}
	
	public double returnDensity() {
		return jr.getDoubleFromElement("density");
	}
	
	public double returnValueDoubles(String element) {
		JsonObject jo = jr.getObjectFromElement("value");
		return jr.getDoubleFromObject(jo,element);
	}
	
	public double returnValueMaximum() {
		return returnValueDoubles("maximum");
	}
	
	public double returnValueMinimum() {
		return returnValueDoubles("minimum");
	}
	
	public String returnCharacter() {
		return jr.getStringFromElement("character");
	}
	
	public String returnTypeStrings(String element) {
		JsonObject jo = jr.getObjectFromElement("type");
		return jr.getStringFromObject(jo, element);
	}
	
	public String returnSuperType() {
		return returnTypeStrings("super_type");
	}
	
	public String returnSubType() {
		return returnTypeStrings("sub_type");
	}
	
	public String returnMainMaterial() {
		return returnTypeStrings("main_material");
	}
	
	public String returnName() {
		String s = jr.getStringFromElement("name");
		s  = s.replaceAll("_", " ");
		return s;
	}
}
