package main;

public class Running {
	Player player;
	Ask a = new Ask();
	
	public Running(Player player) {
		this.player = player;
	}
	
	public void mainrunner() {
		player.name = a.returnString("What do you want to be called?: ");
		System.out.println();
		player.pos.name = a.returnString("What do you want the world to be called?: ");
		
		for(;;) {
			String b = a.whatToDo();
			String o = b.toLowerCase();
			if(o.equals("quit")) {
				break;
			} else {
				String[] n = o.split(" ");
				switch(n.length) {
				case 1:
					String h = n[0];
					one(h);
					postmove();
					break;
				case 2:
					String e = n[0];
					String q = n[1];
					two(e,q);
					postmove();
					break;
				case 3:
					String r = n[0];
					String y = n[1];
					String w = n[2];
					three(r,y,w);
					postmove();
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
		facetwo(e,q);
	}
	
	public void three(String r, String y, String w) {
		movethree(r,y,w);
	}
	
	public void movethree(String r, String y, String w) {
		if(r.equals("move")) {
			Direction m = Direction.fromString(y);
			int j = Integer.valueOf(w);
			
			System.out.println();
			player.move(m, j);
			player.fetchPos(player.pos);
			if(!player.movedtoomuch) {
				player.printCurrentBoard();
				player.printPosition();
			}
		}
	}
	
	public void movetwo(String e, String q) {
		if(e.equals("move")) {
			Direction m = player.dir;
			int j = Integer.valueOf(q);
			
			System.out.println();
			player.move(m, j);
			player.fetchPos(player.pos);
			if(!player.movedtoomuch) {
				player.printCurrentBoard();
				player.printPosition();
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
			System.out.println("------------------------------");
			System.out.println("help");
			System.out.println("print");
			System.out.println("face");
			System.out.println("");
		}
	}
	
	public void printtwo(String e, String q) {
		if(e.equals("print")) {
			switch(q) {
			case"world":
				//This method is currently being worked on
			case"current_position":
				player.printCurrentBoard();
				player.printPosition();
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
			Direction a = Direction.fromString(q);
			player.changeFacingDirection(a);
		}
	}
	
	public void save() {
		
	}
	
	public void postmove() {
		//Npc needs to move
		//Things need to be cleaned up
		//Option to save at any time
	}
}
