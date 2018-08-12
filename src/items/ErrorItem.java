package items;

import org.fusesource.jansi.Ansi;

import jsonreader.ItemReader;

public class ErrorItem extends Item {

	public ErrorItem() {
		this.color = Ansi.Color.RED;
		this.character = "E";
		this.name = "Error";
		this.density = 0;
		this.weight = 0;
		this.value = 0;
	}
	
	public void generateProperties() {}

	public void generateProperties(ItemReader itemreader) {
		
		
	}

}
