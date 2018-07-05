package main;

import java.util.ArrayList;
import java.util.Arrays;
import items.Item;
import tile.*;

public class Board {
	
	
	public int rows;
	public int columns;
	
	public String[][] board;
	public Tag tag;
	public ArrayList<Item> specials = new ArrayList<Item>();
	public ArrayList<Tile> tensils = new ArrayList<Tile>();
	
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
		board = new String[rows+2][columns+2];
		
		for(int k = 0; k <board.length; k++) {
			for(int i = 0; i <board[0].length; i++) {
				if (board[k][i]==null) {
					board[k][i] = "0 ";
				}
			}
		}
	}
	
	public void generateOutandIn() {
		for (int c = 0; c<=(rows+1); c++ ) {
			board[c][0] = "| ";
			board[c][(columns+1)]  = "| ";
		}
		for (int d = 0; d<=(columns+1); d++) {
			board[0][d] = "--";
			board[0][1] = "---";
			board[(rows+1)][d] = "--";
			board[(rows+1)][1] = "---";
		}
		
		board[0][0] = "+";
		board[rows+1][columns+1] = "+";
		board[0][columns+1] = "+";
		board[rows+1][0] = "+";
	}
	
	public void printBoard() {
		for(int k = 0; k < board.length; k++) {
			for(int i = 0; i <board[0].length; i++ ) {
					System.out.print(board[k][i]);
			}
			System.out.println();
		}
	}
	
	public void debugSpecialPrint() {
		System.out.println(Arrays.deepToString(board));
	}
}
