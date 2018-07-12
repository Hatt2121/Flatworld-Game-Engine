package main;

import board.World;
import player.Player;

public class Main {
	public static void main(String[] args) {
		Player a = new Player();
		a.world = new World();
		a.spawn(a.world);
		
		Running b = new Running(a);
		b.mainrunner();
	}
}
