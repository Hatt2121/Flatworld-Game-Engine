package board;

import java.util.Arrays;

import tile.*;

public class Board {
	
	
	public int rows;
	public int columns;
	
	public Tile[][] board;
	public Tag tag;
	
	public Board(int rows, int columns, Tag tag) {
		this.rows = rows;
		this.columns = columns;
		this.tag = tag;
		setBoard();
		create();
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
					board[k][i] = new VoidTile("0 ");
					board[k][i].positionrows = k;
					board[k][i].positioncolumns = i;
				}
			}
		}
	}
	
	public void create() {
		for (int c = 0; c<=(rows+1); c++ ) {
			board[c][0] = new VoidTile("| ");
			board[c][(columns+1)]  = new VoidTile("|");
		}
		for (int d = 0; d<=(columns+1); d++) {
			board[0][d] = new VoidTile("--");
			board[0][1] = new VoidTile("---");
			board[(rows+1)][d] = new VoidTile("--");
			board[(rows+1)][1] = new VoidTile("---");
		}
		
		board[0][0] = new VoidTile("+");
		board[rows+1][columns+1] = new VoidTile("+");
		board[0][columns+1] = new VoidTile("+");
		board[rows+1][0] = new VoidTile("+");
	}
	
	public void printBoard() {
		for(int k = 0; k < board.length; k++) {
			for(int i = 0; i < board[0].length; i++ ) {
					board[k][i].printTile();
			}
			System.out.println();
		}
	}
	
	public void printAnsiBoard() {
		for(int k = 0; k < board.length; k++) {
			for(int i = 0; i < board[0].length; i++ ) {
					board[k][i].printAnsiTile();
			}
			System.out.println();
		}
	}
	
	public void debugSpecialPrint() {
		System.out.println(Arrays.deepToString(board));
	}
}
