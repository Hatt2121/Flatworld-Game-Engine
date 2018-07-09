package tile;

import items.Item;

public class ItemTile extends ContainerTile<Item> {
	
	public ItemTile() {}
	
	public ItemTile(Item a) {
		super(a.character+" ");
		t = a;
	}
	
	public void interact() {
		// TODO Auto-generated method stub
		
	}
	
	public void interfac() {
		// TODO Auto-generated method stub
		
	}

}
