package items;

public abstract class Consumable extends Item {

	/**
	 * For invoking random Items
	 */
	public Consumable() {}
	
	public Consumable(String name) {
		super(name);
	}

	public Consumable(String name, String character) {
		super(name, character);
	}

	public abstract void generateProperties();
	
}
