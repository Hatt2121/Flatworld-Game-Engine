package items;

import jsonreader.ItemReader;

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
	
	public void use() {
		
	}
	
	public void destroyThyself() {
		
	}
	public void generateProperties() {
		
	}

	public void generateProperties(ItemReader itemreader) {
		
		
	}
}
