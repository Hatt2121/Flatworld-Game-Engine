package main;

public class Running {
	Player player;
	Ask a = new Ask();
	
	public Running(Player player) {
		this.player = player;
	}
	
	public void mainrunner() {
		for(;;) {
			String b = a.whatToDo();
			if(b.equals("quit")) {
				break;
			} else {
				String[] n = b.split(" ");
				switch(n.length) {
				case 1:
					String h = n[0];
					
					helpone(h);
					
					break;
				case 2:
					String e = n[0];
					String q = n[1];
					
					help(e,q);
					movetwo(e,q);
					
					break;
				case 3:
					String r = n[0];
					String y = n[1];
					String w = n[2];
					
					movethree(r,y,w);
					
					break;
				}
			}
		}
	}
	
	public static Direction convertDirection(String str) {
		switch(str) {
		case "north":
			return Direction.NORTH;
		case "south":
			return Direction.SOUTH;
		case "east":
			return Direction.EAST;
		case "west":
			return Direction.WEST;
		default:
			return null;
		}
	}
	
	public void movethree(String r, String y, String w) {
		if(r.equals("move")) {
			Direction m = convertDirection(y);
			int j = Integer.valueOf(w);
			
			System.out.println();
			player.move(m, j);
			player.fetchWPos(player.pos);
			if(!player.movedtoomuch) {
				player.printBoardPos();
				player.printPos();
				player.printFacingDirection();
			}
		}
	}
	
	public void movetwo(String e, String q) {
		if(e.equals("move")) {
			Direction m = player.dir;
			int j = Integer.valueOf(q);
			
			System.out.println();
			player.move(m, j);
			player.fetchWPos(player.pos);
			if(!player.movedtoomuch) {
				player.printBoardPos();
				player.printPos();
				player.printFacingDirection();
			}
		}
	}
	
	public void help(String e, String q) {
		if(e.equals("help")) {
			switch(q) {
			default:
				System.out.println("Not a function.");
			}
		}
	}
	
	public void helpone(String h) {
		if(h.equals("help")) {
			System.out.println("To get help, you need to write the funtion name after a space, after the help function.");
			System.out.println();
			System.out.println("Here is the list of functions:");
			System.out.println("-------------------------------");
			//Continue printing the list of functions
			//To make it temporarily look more pretty, I'm going to print a new line:
			System.out.println();
			System.out.println("Wow, that's a lot of functions that you could use.");
		}
	}
}
