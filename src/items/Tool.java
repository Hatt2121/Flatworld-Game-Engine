package items;

public abstract class Tool extends Item {
	
	public Tool(String name) {
		super(name);
	}
	
	public abstract void use();

}
