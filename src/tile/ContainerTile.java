package tile;

import org.fusesource.jansi.Ansi;

public abstract class ContainerTile<T> extends Tile implements FunctionalTile {

	public T t;
	
	public ContainerTile() {
		super();
	}

	public ContainerTile(String character) {
		super(character);
	}
	
	public ContainerTile(String character, Ansi.Color color) {
		super(character,color);
	}
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}

}
