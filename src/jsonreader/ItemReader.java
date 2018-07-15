package jsonreader;

import com.google.gson.JsonObject;

public class ItemReader {
	
	JsonReader jr;
	
	public ItemReader(String filename) {
		String s = "src/assets/Items/";
		String str = s + filename;
		jr = new JsonReader(str);
	}
	
	public String returnName() {
		return jr.getStringFromElement("name");
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
}
