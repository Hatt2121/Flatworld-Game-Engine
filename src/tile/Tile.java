package tile;

public abstract class Tile {
	public int positionrows;
	public int positioncolumns;
	
	public String character;
	
	public Tile() {}
	
	public Tile(String character) {
		this.character = character;
	}
	
	public void printTile() {
		System.out.print(character);
	}
	
	public void printlnTile() {
		System.out.println(character);
	}
}
