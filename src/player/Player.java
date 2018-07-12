package player;
import board.Board;
import board.Tag;
import board.World;
import items.Item;
import main.Ask;
import tile.*;

public class Player {
	
	public boolean movedtoomuch;
	
	//Temporary constant
	//Will be printed on percentage
	public double health = 25;
	public double maxhealth = 25;
	
	//Hungry when hunger is 0
	//
	public double hunger = 25;
	public double maxhunger = 25;
	/**
	 * This String is simply the representation of  itself on the board
	 */
	public String character = "T ";
	
	/**
	 * This is the name of the character or player
	 */
	public String name;
	
	public Tag tag;
	public Board board;
	public World world;
	
	public Inventory inventory = new Inventory();
	public Item equipeditem;
	
	public Direction dir = Direction.NORTH;
	
	public Tile playertile = new PlayerTile(this);
	
	public Player(World a) {
		world = a;
	}
	
	public Player() {}
	
	public void spawn(Board spawn) {
		int b = (spawn.rows/2)+1;
		int c = (spawn.columns/2) + 1;
		playertile.prevtile = spawn.board[b][c];
		spawn.board[b][c] = playertile;
	}
	
	public void spawn(World a) {
		a = world;
		if(a.spawnboard != null) {
			board = a.spawnboard;
			tag = a.SPAWNTAG;
			int b = (board.rows/2) + 1;
			int c = (board.columns/2) + 1;
			
			playertile.prevtile = board.board[b][c];
			board.board[b][c] = playertile;
			playertile.positionrows = b;
			playertile.positioncolumns = c;
		} else {
			System.out.println("There is no Board to spawn to");
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void printCurrentBoard() {
		board.printBoard();
	}
	
	public void printPosition() {
		System.out.println(
				 tag.printCoordinates() +
				"\nPos. Rows: " + playertile.positionrows +
				" Pos. Columns: " + playertile.positioncolumns
		);
		if(dir != null) {
			printFacingDirection();
		}
	}

	public void fetchPosition(Board a) {
		for(int k = 0; k<a.board[0].length; k++) {
			for(int b = 0; b<a.board.length; b++) {
				if(a.board[b][k].equals(playertile)) {
					playertile.positionrows = b;
					playertile.positioncolumns = k;
				}
			}
		}
		System.out.println("Pos Rows: " + playertile.positionrows);
		System.out.println("Pos Columns: " + playertile.positioncolumns);
	}
	
	public void fetchPosition(World a) {
		for(int k = 0; k<a.overboard.size(); k++) {
			Board l = a.overboard.get(k);
			for(int g = 0; g<=l.columns; g++) {
				for(int c = 0;c<=l.rows; c++) {
					if(l.board[c][g].equals(playertile)) {
						tag = l.tag;
						board = l;
						playertile.positionrows = c;
						playertile.positioncolumns = g;
					}
				}
			}
		}
	}
	
	/**
	 * Moving within a board
	 * @param c
	 * @param a
	 * @param distance
	 * 
	 * 
	 */
	public void move(Board c, String a, int distance) {
		c.board[playertile.positionrows][playertile.positioncolumns] = playertile.prevtile;
		switch(a) {
			case "North":
				playertile.positionrows = playertile.positionrows-distance;
				break;
			case "South": 
				playertile.positionrows = playertile.positionrows+distance;
				break;
			case "East": 
				playertile.positioncolumns = playertile.positioncolumns+distance;
				break;
			case "West": 
				playertile.positioncolumns = playertile.positioncolumns-distance;
				break;
			default:
				System.out.println("You did nothing!");
				break;
		}
		playertile.prevtile = c.board[playertile.positionrows][playertile.positioncolumns];
		c.board[playertile.positionrows][playertile.positioncolumns] = playertile;
	}
	
	/** 
	 * This method provides a pacman-style of moving, where if a player moves to far up, the player will go around instead of move to a new board 
	 *
	 *
	 * @param direction
	 * @param distance
	 */
	public void moveModificationOne(Direction direction, int distance) {
		Board c = world.returnBoard(tag);
		c.board[playertile.positionrows][playertile.positioncolumns] = playertile.prevtile;
			switch(direction) {
				case NORTH:
					if (distance>playertile.positionrows-1) {
						playertile.positionrows = c.rows - (distance % (playertile.positionrows-1)) + 1;
					}else {
						playertile.positionrows = playertile.positionrows-distance;
					}
					break;
				case SOUTH:
					if(distance>(c.rows-playertile.positionrows)) {
						playertile.positionrows = (distance % (c.rows-playertile.positionrows));
					} else {
						playertile.positionrows = playertile.positionrows+distance;
					}
					break;
				case EAST:
					if(distance>(c.columns-playertile.positioncolumns)) {
						playertile.positioncolumns = (distance % (c.columns-playertile.positioncolumns));
					} else {
						playertile.positioncolumns = playertile.positioncolumns+distance;
					}
					break;
				case WEST:
					if(distance>(playertile.positioncolumns-1)) {
						playertile.positioncolumns = c.columns - (distance % (playertile.positioncolumns-1));
					} else {
						playertile.positioncolumns = playertile.positioncolumns-distance;
					}
					break;
			}
			playertile.prevtile = c.board[playertile.positionrows][playertile.positioncolumns];
			c.board[playertile.positionrows][playertile.positioncolumns] = playertile;
	}
	/**
	 * Condensed version of the four <i>LARGE</i> methods above, so that it can be called by one method
	 * @param dir
	 * @param distance
	 */
	public void move(Direction dir, int distance) {
		switch(dir) {
			case NORTH:
				moveNorth(distance);
				break;
			case SOUTH:
				moveSouth(distance);
				break;
			case EAST:
				moveEast(distance);
				break;
			case WEST:
				moveWest(distance);
				break;
		}
	}
	
	/**
	 * Move the Player in the North Direction. This method suports cross-board moving
	 * @param distance
	 */
	public void moveNorth(int distance) {
		dir = Direction.NORTH;
		Board j = board;
		j.board[playertile.positionrows][playertile.positioncolumns] = playertile.prevtile;
		movedtoomuch = false;
		if(distance>(playertile.positionrows-1)) {
			if(world.checkTagList(tag.posx,tag.posy+1)) {
				
				Board t = world.returnBoard(tag.posx, tag.posy + 1);
				
				//It's too large for the next board
				if((distance-(playertile.positionrows-1)>t.rows)) {
					System.out.println("Moving Too Much");
					movedtoomuch = true;
				} else {
					playertile.positionrows = t.rows - (distance-(playertile.positionrows));
					
					playertile.prevtile = t.board[playertile.positionrows][playertile.positioncolumns];
					t.board[playertile.positionrows][playertile.positioncolumns] = playertile;
					
					
				}
			} else {
				
				Tag board = new Tag(tag.posx, tag.posy+1);
				int k = (int) (Math.random() * 10) + 5;
				
				if(world.checkTagList(tag.posx+1, tag.posy+1)) {
					k = world.returnBoard(tag.posx+1, tag.posy+1).rows;
				} else if(world.checkTagList(tag.posx-1, tag.posy+1)) {
					k = world.returnBoard(tag.posx-1, tag.posy+1).rows;
				}
				
				Board t = new Board(k, j.columns, board);
				world.addBoard(t);
				
				if(distance-(playertile.positionrows-1)>t.rows) {
					moveNorth((distance-(playertile.positionrows -1))-t.rows);
				} else {
					playertile.positionrows = t.rows - (distance-(playertile.positionrows));
					
					playertile.prevtile = t.board[playertile.positionrows][playertile.positioncolumns];
					t.board[playertile.positionrows][playertile.positioncolumns] = playertile;
				}
				
			}
		} else {
			playertile.positionrows = playertile.positionrows - distance;
			playertile.prevtile = j.board[playertile.positionrows][playertile.positioncolumns];
			j.board[playertile.positionrows][playertile.positioncolumns] = playertile;
		}
	}
	/**
	 * Move the Player in the South Direction. This method supports cross-board moving
	 * @param distance
	 */
	public void moveSouth(int distance) {
		dir = Direction.SOUTH;
		Board j = world.returnBoard(tag);
		j.board[playertile.positionrows][playertile.positioncolumns] = playertile.prevtile;
		movedtoomuch = false;
		if(distance>((j.rows-1)-(playertile.positionrows-1))) {
			if(world.checkTagList(tag.posx,tag.posy-1)) {
				
				Board t = world.returnBoard(tag.posx, tag.posy-1);
				
				//It's too large for the next board
				if((distance-(j.rows - playertile.positionrows-1)>t.rows)) {
					System.out.println("Moving Too Much");
					movedtoomuch = true;
				} else {
					distance = distance - (j.rows  - (playertile.positionrows)); 
					playertile.positionrows = distance;
					
					playertile.prevtile = t.board[playertile.positionrows][playertile.positioncolumns];
					t.board[playertile.positionrows][playertile.positioncolumns] = playertile;
					
					
				}
			} else {
				Tag board = new Tag(tag.posx,tag.posy-1);
				int k = (int) (Math.random() * 9) + 5;
				
				if(world.checkTagList(tag.posx+1, tag.posy-1)) {
					k = world.returnBoard(tag.posx+1, tag.posy).rows;
				} else if(world.checkTagList(tag.posx-1, tag.posy-1)) {
					k = world.returnBoard(tag.posx-1, tag.posy).rows;
				}
				
				Board t = new Board(k, j.columns, board);
				world.addBoard(t);
				
				if((distance-(j.rows - playertile.positionrows-1)>t.rows)) {
					System.out.println("Moving Too Much");
					//distance = distance - (playertile.positionrows-1) - t.rows;
					//go South Method
				} else {
					distance = distance - (j.rows  - (playertile.positionrows)); 
					playertile.positionrows = distance;
					
					playertile.prevtile = t.board[playertile.positionrows][playertile.positioncolumns];
					t.board[playertile.positionrows][playertile.positioncolumns] = playertile;
				}
				
			}
		} else {
			playertile.positionrows = playertile.positionrows + distance;
			playertile.prevtile = j.board[playertile.positionrows][playertile.positioncolumns];
			j.board[playertile.positionrows][playertile.positioncolumns] = playertile;
		}
	}
	/**
	 * Move the Player in the East Diretion. This method supports cross-board moving.
	 * @param distance
	 */
	public void moveEast(int distance) {
		dir = Direction.EAST;
		Board j = world.returnBoard(tag);
		j.board[playertile.positionrows][playertile.positioncolumns] = playertile.prevtile;
		movedtoomuch = false;
		if(distance>((j.columns-1)-(playertile.positioncolumns-1))) {
			if(world.checkTagList(tag.posx+1, tag.posy)) {
				
				Board t = world.returnBoard(tag.posx+1, tag.posy);
				
				if((distance-(j.columns-(playertile.positioncolumns-1))) > t.columns) {
					System.out.println("Moving too much");
					movedtoomuch = true;
				} else {
					playertile.positioncolumns = distance - (j.columns - (playertile.positioncolumns));
					
					playertile.prevtile = t.board[playertile.positionrows][playertile.positioncolumns];
					t.board[playertile.positionrows][playertile.positioncolumns] = playertile;
				}
			} else {
				Tag board = new Tag(tag.posx+1,tag.posy);
				int k = (int) (Math.random() * 9) + 5;
				
				if(world.checkTagList(tag.posx +1, tag.posy + 1)) {
					k = world.returnBoard(tag.posx + 1, tag.posy + 1).columns;
				}else if(world.checkTagList(tag.posx + 1, tag.posy -1)) {
					k = world.returnBoard(tag.posx + 1, tag.posy - 1).columns;
				}
				Board t = new Board(j.rows,k,board);
				world.addBoard(t);
				
				if((distance-(j.columns-(playertile.positioncolumns-1)))> t.columns ) {
					System.out.println("Moving too much");
				} else {
					playertile.positioncolumns = distance - (j.columns - (playertile.positioncolumns));
					
					playertile.prevtile = t.board[playertile.positionrows][playertile.positioncolumns];
					t.board[playertile.positionrows][playertile.positioncolumns] = playertile;
				}		
			}
		} else {
			playertile.positioncolumns = playertile.positioncolumns + distance;
			playertile.prevtile = j.board[playertile.positionrows][playertile.positioncolumns];
			j.board[playertile.positionrows][playertile.positioncolumns] = playertile;
		}
	}
	/**
	 * Move the Player  in the West Direction. This method supports cross-board moving.
	 * @param distance
	 */
	public void moveWest(int distance) {
		dir = Direction.WEST;
		Board j = world.returnBoard(tag);
		j.board[playertile.positionrows][playertile.positioncolumns] = playertile.prevtile;
		movedtoomuch = false;
		if(distance>playertile.positioncolumns-1) {
			if(world.checkTagList(tag.posx-1, tag.posy)) {
				
				Board t = world.returnBoard(tag.posx-1, tag.posy);
				
				if((distance-(playertile.positioncolumns-1)) > t.columns) {
					System.out.println("Moving too much");
					movedtoomuch = true;
				} else {
					playertile.positioncolumns = t.columns - (distance - (playertile.positioncolumns));
					
					playertile.prevtile = t.board[playertile.positionrows][playertile.positioncolumns];
					t.board[playertile.positionrows][playertile.positioncolumns] = playertile;
				}
			} else {
				Tag board = new Tag(tag.posx-1,tag.posy);
				int k = (int) (Math.random() * 9) + 5;
				
				if(world.checkTagList(tag.posx -1, tag.posy + 1)) {
					k = world.returnBoard(tag.posx - 1, tag.posy + 1).columns;
				}else if(world.checkTagList(tag.posx - 1, tag.posy -1)) {
					k = world.returnBoard(tag.posx - 1, tag.posy - 1).columns;
				}
				Board t = new Board(j.rows,k,board);
				world.addBoard(t);
				
				if((distance-(playertile.positioncolumns-1))> t.columns ) {
					System.out.println("Moving too much");
				} else {
					playertile.positioncolumns = t.columns - (distance - (playertile.positioncolumns));
					
					playertile.prevtile = t.board[playertile.positionrows][playertile.positioncolumns];
					t.board[playertile.positionrows][playertile.positioncolumns] = playertile;
				}		
			}
		} else {
			playertile.positioncolumns = playertile.positioncolumns - distance;
			playertile.prevtile = j.board[playertile.positionrows][playertile.positioncolumns];
			j.board[playertile.positionrows][playertile.positioncolumns] = playertile;
		}
	}
	
	
	/**
	 * This method makes the player interact with the object(really tile) in front of it.
	 * And depending on what the object is, the player will interact differently
	 */
	public void interact() {
		Tile a = null;
		String b = null;
		switch(dir) {
		case NORTH:
			a = world.returnBoard(tag).board[playertile.positionrows-1][playertile.positioncolumns];
			b = (a.getClass().getSimpleName());
			break;
		case SOUTH:
			a = world.returnBoard(tag).board[playertile.positionrows+1][playertile.positioncolumns];
			b = (a.getClass().getSimpleName());
			break;
		case EAST:
			a = world.returnBoard(tag).board[playertile.positionrows][playertile.positioncolumns+1];
			b = (a.getClass().getSimpleName());
			break;
		case WEST:
			a = world.returnBoard(tag).board[playertile.positionrows][playertile.positioncolumns-1];
			b = (a.getClass().getSimpleName());
			break;
		}
		switch(b) {
		case "ItemTile":
			ItemTile j = (ItemTile) a;
			inventory.addToInventory(j.t);
			world.returnBoard(tag).board[playertile.positionrows][playertile.positioncolumns] = j.prevtile;
			break;
		}
	}
	
	/** 
	 * This method would allow for the player to interact with the board itself, probably to give some sort of description of the location or some sort
	 * This method is currently an Idea, and hasn't been implemented yet
	 * @deprecated
	 * @param a
	 */
	public void interact(Board a) {}
	
	/**
	 * This method would equip the Item after the player asked what it would like to equip.
	 * This method probably would change to allow the <i>Running</i> class to ask it instead of the <i>Player</i> class.
	 *
	 */
	public void equipItem() {
		Ask b = new Ask();
		inventory.printInventory();
		String c = b.returnString("What do you want to equip");
		for(Item d : inventory.itemlist) {
			if(c.equals(d.name)) {
				equipeditem = d;
				inventory.itemlist.remove(d);
				break;
			}
		}
		
	}
	
	public void printFacingDirection() {
		switch(dir) {
			case WEST:
				System.out.println("Facing West");
				break;
			case EAST:
				System.out.println("Facing East");
				break;
			case NORTH:
				System.out.println("Facing North");
				break;
			case SOUTH:
				System.out.println("Facing South");
				break;
		}
	}
	
	public void changeFacingDirection(Direction towhat) {
		switch(towhat) {
		case NORTH:
			dir = Direction.NORTH;
			System.out.println("Now Facing North");
			break;
		case SOUTH:
			dir = Direction.SOUTH;
			System.out.println("Now Facing South");
			break;
		case EAST:
			dir = Direction.EAST;
			System.out.println("Now Facing East");
			break;
		case WEST:
			dir = Direction.WEST;
			System.out.println("Now Facing West");
			break;
		}
	}
}
