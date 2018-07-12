package tile;

import player.Player;

public class PlayerTile extends Tile {

	public Player player;
	
	public PlayerTile(Player player) {
		super(player.character);
		this.player = player;
	}

}
