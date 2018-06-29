package main;

public class Test {
	public static void main(String[] args) {
		Board spawnboard = new Board(15,15, new Tag (0,0));
		Methods.setupBoard(spawnboard);
		
		Player player =  new Player();
		player.pos = new World();
		
		player.pos.addBoard(spawnboard);
		player.pos.spawntag = spawnboard.tag;
		player.spawnPlayer(player.pos);
		player.fetchWPos(player.pos);
	
		Running h = new Running(player);
		h.mainrunner();
		
	}
}
