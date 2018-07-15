package items;

public class Foodstuff extends Item implements Consumable,Tool {

	/**
	 * For invoking random generation
	 */
	public Foodstuff() {}
	
	public Foodstuff(String name) {
		super(name);
	}

	public Foodstuff(String name, String character) {
		super(name,character);
	}

	/**
	 * Work in Progress: 
	 * Will generate properties based on files in assets.Items
	 */
	public void generateProperties() {
		
		
	}
	public void use() {
		
	}
	
	public void destroyThyself() {
		
	}
}
