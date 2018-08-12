package board;
import java.util.ArrayList;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class World {
	public String name;
	
	public Board spawnboard;
	public Tag SPAWNTAG = new Tag(0,0);
	
	Board g = new BError(15,15);
	
	public ArrayList<Board> overboard = new ArrayList<Board>();
	public ArrayList<Tag> overtag = new ArrayList<Tag>();
	
	public World() {
		Board a = new Board(15,15,SPAWNTAG);
		spawnboard = a;
		
		overboard.add(a);
		overtag.add(a.tag);
	}
	
	//For checking to see if a tag with associated board exists
	public boolean checkTagList(Tag tag) {
		if(overtag.contains(tag)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkTagList(int posx, int posy) {
		boolean a = false;
		for(int i = 0; i<overtag.size(); i++){
			Tag d = overtag.get(i);
			int j = d.posx;
			int b = d.posy;
			if(j == posx) {
				if (b == posy) {
					a = true;
				}
			}
		}
		return a;
	}
	
	//Debugging
	public boolean tagAndBoardConnection(Tag tag, Board board) {
		if(overtag.indexOf(tag)==overboard.indexOf(board)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean tagAndBoardConnection(Board board) {
		if(overtag.indexOf(board.tag)==overboard.indexOf(board)) {
			return true;
		}else {
			return false;
		}
	}
	
	//Adding a new Board
	public void addBoard(Board board) {
		overboard.add(board);
		overtag.add(board.tag);
	}
	
	public void addBoard(int rows, int columns, Tag tag) {
		Board newboard = new Board(rows, columns, tag);
		overboard.add(newboard);
		overtag.add(newboard.tag);
	}
	
	public void addBoard(Board board, Tag tag) {
		overboard.add(board);
		board.tag = tag;
		overtag.add(tag);
	}
	
	//Returning board from tag list
	public Board returnBoard(Tag tag) {
		int a = overtag.indexOf(tag);
		return overboard.get(a);
	}
	
	public Board returnBoard(int posx, int posy) {
		Board a = g;
		g.setBoard();
		int h = posx;
		int b = posy;
		for(int i = 0; i<overtag.size(); i++) {
			if(overtag.get(i).posx==h) {
				if(overtag.get(i).posy==b) {
				a = overboard.get(i);
				}
			}
		}
		return a;
	}
		
	//Returning tag from board list
	public Tag returnTag(Board board) {
		int a = overboard.indexOf(board);
		return overtag.get(a);
	}
	
	//Return Tag from tag information
	public Tag inftagGet(int posx, int posy) {
		Tag b = null;
		for(int i = 0; i < overtag.size(); i++) {
			if((overtag.get(i).posx==posx)&&(overtag.get(i).posy == posy)) {
				b = overtag.get(i);
			}
		}
		return b;
	}
	
	//Print the Lists
	public void printOvertag() {
		for(int i = 0; i <overtag.size(); i++) {
			System.out.println("Tag of Index-" + i +": " + overtag.get(i).returnCoordinates());
		}
	}
	
	public void printAnsiOvertag() {
		for(int i = 0; i < overtag.size(); i++) {
			AnsiConsole.out.println(Ansi.ansi().fg(Ansi.Color.WHITE).a("Tag of Index-" + i +": " + overtag.get(i).returnCoordinates()));
		}
	}
	
	/**
	 * This method returns true if the first tag in overtag is the spawntag -- which is supposed to generally be (0,0)
	 * @return
	 */
	public boolean debugTwo() {
		int a = overtag.get(0).posx;
		int b = overtag.get(0).posy;
		
		if(a == 0) {
			if (b == 0) {
				return true;
			}
		}
		return false;
	}
	
	public void generate(String[] args) {
		//A bunch of generating stuff
	}
}
