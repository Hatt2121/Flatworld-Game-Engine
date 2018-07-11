package items;

public class Foodstuff extends Consumable {

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
	 * Will generate properties based on files on board
	 */
	public void generateProperties() {
		
		
	}
}
