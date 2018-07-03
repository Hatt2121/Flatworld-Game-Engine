package main;

import items.Item;

public class Main {
	public static void main(String[] args) {
		Board spawnboard = new Board(15,15, new Tag (0,0));
		Methods.setupBoard(spawnboard);
		
		Player player =  new Player();
		player.pos = new World();
		
		player.pos.addBoard(spawnboard);
		player.pos.spawntag = spawnboard.tag;
		Item j = new Item("Sword");
		j.spawnItem(player.pos);
		player.spawnPlayer(player.pos);
		player.fetchPos(player.pos);
	
		Running h = new Running(player);
		h.mainrunner();
		
	}
}
