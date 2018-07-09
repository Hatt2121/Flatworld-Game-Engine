package tile;

import items.*;

public class ItemTile extends FunctionalTile {

	public Item item;
	
	public ItemTile(Item a) {
		super(a.character);
		this.character = a.character+" ";
		item = a;
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interfac() {
		// TODO Auto-generated method stub

	}

}
