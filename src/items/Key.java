package items;

import jsonreader.ItemReader;

public class Key extends Item implements Tool {
	public Key(String name) {
		super(name);
	}

	public void use() {
		
	}

	/**
	 * This one could possibly be useless in this class
	 * @return 
	 */
	public void generateProperties() {
		
	}

	
	@Override
	public void generateProperties(ItemReader itemreader) {
		// TODO Auto-generated method stub
		
	}
	
	
}
