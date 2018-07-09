package main;

import java.util.ArrayList;
import java.util.Arrays;
import items.Item;
import tile.*;

public class Board {
	
	
	public int rows;
	public int columns;
	
	public Tile[][] board;
	public Tag tag;
	//Will use ItemTile eventually
	public ArrayList<Item> specials = new ArrayList<Item>();
	
	public Board(int rows, int columns, Tag tag) {
		this.rows = rows;
		this.columns = columns;
		this.tag = tag;
	}
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}
	
	
	public void setBoard() {
		board = new Tile[rows+2][columns+2];
		
		for(int k = 0; k <board.length; k++) {
			for(int i = 0; i <board[0].length; i++) {
				if (board[k][i]==null) {
					board[k][i] = new SuperStaticTile("0 ");
				}
			}
		}
	}
	
	public void generateOutandIn() {
		for (int c = 0; c<=(rows+1); c++ ) {
			board[c][0] = new SuperStaticTile("| ");
			board[c][(columns+1)]  = new SuperStaticTile("| ");
		}
		for (int d = 0; d<=(columns+1); d++) {
			board[0][d] = new SuperStaticTile("--");
			board[0][1] = new SuperStaticTile("---");
			board[(rows+1)][d] = new SuperStaticTile("--");
			board[(rows+1)][1] = new SuperStaticTile("---");
		}
		
		board[0][0] = new SuperStaticTile("+");
		board[rows+1][columns+1] = new SuperStaticTile("+");
		board[0][columns+1] = new SuperStaticTile("+");
		board[rows+1][0] = new SuperStaticTile("+");
	}
	
	public void printBoard() {
		for(int k = 0; k < board.length; k++) {
			for(int i = 0; i < board[0].length; i++ ) {
					board[k][i].printTile();
			}
			System.out.println();
		}
	}
	
	public void debugSpecialPrint() {
		System.out.println(Arrays.deepToString(board));
	}
}
