package main;

public class InBoard extends Board{

	public InBoard(int rows, int columns, Tag tag) {
		super(rows, columns,tag);
		this.rows = rows;
		this.columns = columns;
		this.tag = tag;
	}
	
	public void generateOutandIn() {
		
		for(int c = 1; c < (rows+1); c++) {
			board[c][0] = "[";
			board[c][(columns+1)]  = "]";
		}
		
		for(int g = 2; g < (rows); g++) {
			board[g][0] = "|";
			board[g][(columns+1)] = "|";
		}
		for (int d = 1; d<(columns+1); d++) {
			board[0][d] = "==";
			board[(rows+1)][d] = "==";
		}
		
		board[0][0] = "+";
		board[rows+1][columns+1] = "+";
		board[0][columns+1] = "+";
		board[rows+1][0] = "+";
	}
}
