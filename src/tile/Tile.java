package tile;

public abstract class Tile {
	
	public int positionrows;
	public int positioncolumns;
	
	public String character;
	
	public Object obj;
	
	public Tile prevtile;
	
	public Tile() {}
	
	public Tile(Object obj) {
		this.obj = obj; 
	}
	
	public Tile(String character) {
		this.character = character;
	}
	
	public Tile(String character, Object obj) {
		this.obj = obj;
		this.character = character;
	}
	
	public void printTile() {
		System.out.print(character);
	}
	
	public void printlnTile() {
		System.out.println(character);
	}
}
