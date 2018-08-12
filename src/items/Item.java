package items;

import tile.*;
import board.*;
import items.weapons.*;
import jsonreader.*;

import org.fusesource.jansi.Ansi;

public abstract class Item {
	public boolean inenvironment;
	
	public double weight;
	public double size;
	public double density;
	
	public String name;
	public String character;
	
	public double value;
	
	public Ansi.Color color;
	
	public Tile itemtile;
	
	public Item() {}
	
	public Item(String character) {
		this.character = character;
	}
	
	public Item(String character,String name) {
		this.name = name;
		this.character = character;
	}
	
	public Item(String character, Ansi.Color color) {
		this.character = character;
		this.color = color;
	}
	
	/**
	 * This method features some parts to 
	 * @param a
	 */
	public void spawn(World a) {
		itemtile = new ItemTile(this);
		int b = (int) Math.random() * a.overboard.size();
		Board y = a.overboard.get(b);
		
		itemtile.positionrows = (int) (Math.random() * y.rows) + 1;
		itemtile.positioncolumns = (int) (Math.random() * y.columns)+ 1;
		
		itemtile.prevtile = y.board[itemtile.positionrows][itemtile.positioncolumns];
		y.board[itemtile.positionrows][itemtile.positioncolumns] = itemtile;
		
		itemtile.board = y;
		inenvironment = true;
	}
	
	public void RandomSpawn(World a) {
		Item g = generateRandom();
		itemtile = new ItemTile(g);
		int b = (int) Math.random() * a.overboard.size();
		Board y = a.overboard.get(b);
		
		itemtile.positionrows = (int) (Math.random() * y.rows) + 1;
		itemtile.positioncolumns = (int) (Math.random() * y.columns)+ 1;
		
		itemtile.prevtile = y.board[itemtile.positionrows][itemtile.positioncolumns];
		y.board[itemtile.positionrows][itemtile.positioncolumns] = itemtile;
		
		itemtile.board = y;
		inenvironment = true;
	}
	
	public void printStats() {
		System.out.println(name+" " +character+" "+value+" "+weight+" "+size+" "+density);
	}
	
	public Item generateRandom() {
		Item h = new ErrorItem();
		ItemReader a = new /*Random*/ ItemReader();
		String type = a.returnSuperType();
		switch(type) {
		case"weapon":
			String subtype = a.returnSubType();
			if(subtype.equals("melee")) {
				h = new MeleeWeapon("/");
				h.generateProperties(a);
			} else if(subtype.equals("range")) {
				h = new RangeWeapon("r");
				h.generateProperties();
			}
		}
		return h;
	}

	public abstract void generateProperties();
	public abstract void generateProperties(ItemReader itemreader);

}
