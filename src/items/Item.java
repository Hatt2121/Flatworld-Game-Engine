package items;

import tile.*;
import board.*;

public abstract class Item {
	public boolean inenvironment;
	
	public double weight;
	public double size;
	public double density;
	
	public String name;
	public String character = "r";
	
	public Value value;
	
	public Tile itemtile;
	
	public Item() {}
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(String name, String character) {
		this.name = name;
		this.character = character;
	}
	
	/**
	 * This method features some parts to 
	 * @param a
	 */
	public void spawn(World a) {
		generateProperties();
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
	
	public void printStats() {
		System.out.println(name+" " +character+" "+value.value+" "+weight+" "+size+" "+density);
	}
	
	public abstract void generateProperties();
	//Call This and then spawn item

}
