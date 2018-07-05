package items;
import main.*;

public class Item {
	public boolean inenvironment;
	
	public int positionrows;
	public int positioncolumns;
	
	public double weight;
	public double size;
	public double density;
	
	public String name;
	public String character;
	public String prevtile;
	
	public Board curboard;
	
	public Value value;
	
	public Item(String name) {
		this.name = name;
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
		
		prevtile = y.board[positionrows][positioncolumns];
		y.board[positionrows][positioncolumns] = character+" ";
		
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
