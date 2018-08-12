package board;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class Tag {
	public int posx;
	public int posy;
	
	public Tag(String a) {
		String[] b = a.split(",");
		posx = Integer.valueOf(b[0]);
		posy = Integer.valueOf(b[1]);
	}
	
	public Tag(int x, int y) {
		posx = x;
		posy = y;
	}
	
	public String returnCoordinates() {
		String a = "("+posx+","+posy+")";
		return a;
	}
	
	public void printAnsiCoordinates() {
		String a = "("+posx+","+posy+")";
		AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.BLUE).a(a));
	}
}
