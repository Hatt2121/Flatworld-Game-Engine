package tile;

import items.Item;

public class ItemTile extends ContainerTile<Item> {
	
	public ItemTile() {}
	
	public ItemTile(Item a) {
		super(a.character+" ");
		t = a;
	}
	
	public void interact() {
		
	}
	
	public void interfac() {
		System.out.println("This Item, " + t.name + " is all alone, would you pick it up?");
	}

}
