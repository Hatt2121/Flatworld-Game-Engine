package tile;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class VoidTile extends Tile implements StaticTile {

	public VoidTile(String character) {
		super(character);
		color = Ansi.Color.WHITE;
	}
	
	public VoidTile(String character, Ansi.Color color) {
		super(character,color);
	}
	
	public void printTile() {
		System.out.print(character);
	}
	
	public void printlnTile() {
		System.out.println(character);
	}
	
	public void printAnsiTile() {
		AnsiConsole.out.print(Ansi.ansi().fg(color).a(character).reset());
	}
	
	public void printlnAnsiTile() {
		AnsiConsole.out.println(Ansi.ansi().fg(color).a(character).reset());
	}
	
	public void getBumped() {}
	
}
