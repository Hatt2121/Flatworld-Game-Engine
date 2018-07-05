package main;

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
	
	public String printCoordinates() {
		String a = "("+posx+","+posy+")";
		return a;
	}
}
