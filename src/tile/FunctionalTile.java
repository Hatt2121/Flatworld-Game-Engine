package tile;

public abstract class FunctionalTile extends Tile {
	
	public FunctionalTile(String character) {
		super(character);
	}
	
	public abstract void interact();
	public abstract void interfac();
}
