package main;

import items.*;

public class Main {
	public static void main(String[] args) {
		Board spawnboard = new Board(15,15, new Tag (0,0));
		Methods.setupBoard(spawnboard);
		
		Player player =  new Player();
		player.world = new World();
		
		player.world.addBoard(spawnboard);
		player.world.spawntag = spawnboard.tag;
		Item j = new Weapon("Gun");
		j.spawn(player.world);
		player.spawnPlayer(player.world);
		player.fetchPosition(player.world);
	
		Running h = new Running(player);
		h.mainrunner();
	}
}
