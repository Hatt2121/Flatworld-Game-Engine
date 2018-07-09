package items;
import main.*;
import tile.*;

public class Item {
	public boolean inenvironment;
	
	public int positionrows;
	public int positioncolumns;
	
	public double weight;
	public double size;
	public double density;
	
	public String name;
	public String character;
	public Tile prevtile;
	
	public Board curboard;
	
	public Value value;
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(String name, String character) {
		this.name = name;
		this.character = character;
	}
	
	public void spawnItem(World a) {
		int b = (int) Math.random() * a.overboard.size();
		Board y = a.overboard.get(b);
		
		positionrows = (int) (Math.random() * y.rows) + 1;
		positioncolumns = (int) (Math.random() * y.columns)+ 1;
		
		int n = (int) (Math.random() * 2) + 1;
		weight = n;
		size = n;
		density = n;
		value = new Value(n);
		
		character = "r";
		//Change this
		
		prevtile = y.board[positionrows][positioncolumns];
		y.board[positionrows][positioncolumns] = new ItemTile(this);
		
		/*
		 * For now, I'm going to randomize the properties just to test things out
		 */
		
		y.specials.add(this);
		curboard = y;
		inenvironment = true;
	}
	
	public void printStats() {
		System.out.println(name+" " +character+" "+value.value+" "+weight+" "+size+" "+density);
	}
}
