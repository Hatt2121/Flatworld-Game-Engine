package tile;

import org.fusesource.jansi.Ansi;

import player.Player;

public class PlayerTile extends Tile {

	public Player player;
	
	public PlayerTile(Player player) {
		super(player.character);
		this.player = player;
		
		if(player.color != null) {
			this.color = player.color;
		} else {
			this.color = Ansi.Color.WHITE;
		}
	}

}
