package main;

import org.fusesource.jansi.Ansi;

import board.World;
import items.*;
import player.*;
import tile.PlayerTile;

public class Main {
	public static void main(String[] args) {
		Player a = new Player(Ansi.Color.GREEN);
		PlayerTile c = new PlayerTile(a);
		
		a.world = new World();
		
		Item h = new ErrorItem();	
		h.generateRandom();
		h.RandomSpawn(a.world);
		
		a.spawn(a.world);
		
		Running b = new Running(a);
		b.mainrunner();
		c.printAnsiTile();
		
		
	}
}
