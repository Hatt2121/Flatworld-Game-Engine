package board;

import tile.*;

public class BError extends Board {

	public BError(int rows, int columns) {
		super(rows, columns);
		this.rows = 51;
		this.columns = 51;
	}
	
	public void setBoard() {
		board = new Tile[rows][columns];
		
		for(int k = 0; k <board.length; k++) {
			for(int i = 0; i <board[0].length; i++) {
				if (board[k][i]==null) {
					board[k][i] = new SuperStaticTile("0 ");
				}
			}
		}
		
		for(int f = 0; f <board.length; f++) {
			board[f][24] = new SuperStaticTile("E ");
			board[f][26] = new SuperStaticTile("R ");
			board[f][25] = new SuperStaticTile("R ");
			board[f][27] = new SuperStaticTile("O ");
			board[f][28] = new SuperStaticTile("R ");
		}
		
	}
	
}
