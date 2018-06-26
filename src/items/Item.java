package items;
import main.*;

public class Item {
	public int positionrows;
	public int positioncolumns;
	
	public double weight = 1;
	public double size = 2;
	public double density = 3;
	
	public String name;
	public String character;
	public String prevtile;
	
	public Board curboard;
	
	//public Value value;
	
	public Item(String name) {
		this.name = name;
	}
	
	public void spawnItem(World a) {
		int b = (int) Math.random() * a.overboard.size();
		Board y = a.overboard.get(b);
		
		positionrows = (int) (Math.random() * y.rows) + 1;
		positioncolumns = (int) (Math.random() * y.columns)+ 1;
		
		y = a.overboard.get(0);
		positionrows = 4;
		positioncolumns = 5;
		
		prevtile = y.board[positionrows][positioncolumns];
		y.board[positionrows][positioncolumns] = character;
		
		y.specials.add(this);
		curboard = y;
	}
}
