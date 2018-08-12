package jsonreader;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class WeaponReader extends ItemReader {
	
	public WeaponReader(String filename) {
		super(filename);
	}
	
	public WeaponReader(JsonReader jr) {
		this.jr = jr;
	}
	
	public int returnAOEType() {
		return jr.getIntFromObject(jr.getObjectFromElement("combat"), "aoe_type");
	}
	
	public double returnDamage() {
		return jr.getDoubleFromObject(jr.getObjectFromElement("combat"), "damage");
	}
	
	public JsonObject getAbility(int index) {
		JsonArray ja = jr.getArrayFromObject(jr.getObjectFromElement("combat"), "special_abilties");
		ArrayList<JsonObject> al = jr.getListFromJsonArray(ja);
		return al.get(index);
	}
	
	public String getAbilityName(JsonObject ability) {
		return ability.get("ability_name").getAsString();
	}
	
	public String getAbilityDescription(JsonObject ability) {
		return ability.get("ability_description").getAsString();
	}
	
	public String getAbilityEffectCode(JsonObject ability) {
		return ability.get("ability_effect_code").getAsString();
	}
}
