package tile;

public abstract class ContainerTile<T> extends FunctionalTile {

	public T t;
	
	public ContainerTile() {
		super();
	}

	public ContainerTile(String character) {
		super(character);
	}
	
	public void set(T t) {
		this.t = t;
		obj = t;
	}
	
	public T get() {
		return t;
	}

}
