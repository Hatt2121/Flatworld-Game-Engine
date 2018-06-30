package main;

public class Running {
	Player player;
	Ask a = new Ask();
	
	public Running(Player player) {
		this.player = player;
	}
	
	public void mainrunner() {
		player.name = a.returnString("What do you want to be called?: ");
		player.pos.name = a.returnString("What do you want the world to be called?: ");
		
		for(;;) {
			String b = a.whatToDo();
			if(b.equals("quit")) {
				break;
			} else {
				String[] n = b.split(" ");
				switch(n.length) {
				case 1:
					String h = n[0];
					one(h);
					//Post move
					break;
				case 2:
					String e = n[0];
					String q = n[1];
					two(e,q);
					//Post move
					break;
				case 3:
					String r = n[0];
					String y = n[1];
					String w = n[2];
					three(r,y,w);
					//post move
					break;
				}
			}
		}
	}
	
	public void one(String h) {
		helpone(h);
	}
	
	public void two(String e, String q) {
		helptwo(e,q);
		movetwo(e,q);
		printtwo(e,q);
	}
	
	public void three(String r, String y, String w) {
		movethree(r,y,w);
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
			}
		}
	}
	
	public void helptwo(String e, String q) {
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
			//These will be entered manually
			System.out.println("help: displays this message use help [function] to figure out what that function does in more depth");
			System.out.println("print: prints what you need");
			System.out.println("");
			System.out.println("Wow, that's a lot of functions that you could use.");
		}
	}
	
	public void printtwo(String e, String q) {
		if(e.equals("print")) {
			switch(q) {
			case"world":
				//This method is currently being worked on
			case"current_position":
				player.printBoardPos();
				player.printPos();
				break;
			case"inventory":
				//This part is in progress
			case"player_stats":
				System.out.println("Health: " + player.health);
				System.out.println("Health Percentage: " +((int) (player.health/player.maxhealth)*100) + "%");
				System.out.println();
				System.out.println("Hunger: " + player.hunger);
				System.out.println("Hunger Percentage: " + ((int) (player.hunger/player.maxhunger)*100) + "%");
				//More will come as more features are added (Specifically Temperature)
			}
		}
	}
	
	public void facetwo(String e, String q) {
		if(e.equals("face")) {
			switch(q) {
			case"north":
				player.dir = Direction.NORTH;
				break;
			case"south":
				player.dir = Direction.SOUTH;
				break;
			case"east":
				player.dir = Direction.EAST;
				break;
			case"west":
				player.dir = Direction.WEST;
				break;
			}
		}
	}
}
