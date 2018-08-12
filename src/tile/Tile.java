package tile;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import board.Board;

public abstract class Tile {
	
	public int positionrows;
	public int positioncolumns;
	
	public String character;
	
	public Tile prevtile;
	
	public Board board;

	public Ansi.Color color;
	
	public Tile() {}
	
	public Tile(String character) {
		this.character = character;
	}
	
	public Tile(String character, Ansi.Color color) {
		this.character = character;
		this.color = color;
	}
	
	public void printTile() {
		System.out.print(character+" ");
	}
	
	public void printlnTile() {
		System.out.println(character+" ");
	}
	
	public void printAnsiTile() {
		AnsiConsole.out.print(Ansi.ansi().fg(color).a(character+" ").reset());
	}
	
	public void printlnAnsiTile() {
		AnsiConsole.out.println(Ansi.ansi().fg(color).a(character+" ").reset());
	}
}
