package main;
import items.Item;

public class Player {
	
	/**
	 * track where a player is on a board
	 */
	public int positionrows;
	public int positioncolumns;
	
	//Temporary constant
	//Will be printed on percentage
	public double health = 25;
	public double maxhealth = 25;
	
	//Hungry when hunger is 0
	//
	public double hunger = 25;
	public double maxhunger = 25;
	
	public boolean movedtoomuch;
	
	/**
	 * This String is simply the representation of  itself on the board
	 */
	public String character = "T ";
	/**
	 * This String is for moving, because I can't actually delete the tile below the player
	 */
	public String prevtile;
	/**
	 * This is the name of the character or player
	 */
	public String name;
	
	public Tag curtag;
	public World pos;
	
	public Inventory inventory = new Inventory();
	public Item equipeditem;
	
	public Direction dir = Direction.NORTH;
	
	public Player(World a) {
		pos = a;
	}
	
	public Player() {}
	
	public void spawnPlayer(Board spawn) {
		int b = (spawn.rows/2)+1;
		int c = (spawn.columns/2) + 1;
		prevtile = spawn.board[b][c];
		spawn.board[b][c] = character;
	}
	
	public void spawnPlayer(World a) {
		pos = a;
		if(a.checkTagList(a.spawntag)) {
			Board spawn = a.returnBoard(a.spawntag);
			curtag = a.spawntag;
			int b = (spawn.rows/2)+1;
			int c = (spawn.columns/2) +1;
			prevtile = spawn.board[b][c];
			spawn.board[b][c] = character;
		} else {
			System.out.println("There is no World");
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void printCurrentBoard() {
		pos.returnBoard(curtag.posx, curtag.posy).printBoard();
	}
	
	public void printPosition() {
		System.out.println(
				 curtag.tagCoordinates() +
				"\nPos. Rows: " + positionrows +
				" Pos. Columns: " + positioncolumns
		);
		if(dir != null) {
			printFacingDirection();
		}
	}

	public void fetchPos(Board a) {
		for(int k = 0; k<a.board[0].length; k++) {
			for(int b = 0; b<a.board.length; b++) {
				if(a.board[b][k].equals(character)) {
					positionrows = b;
					positioncolumns = k;
				}
			}
		}
		System.out.println("Pos Rows: " + positionrows);
		System.out.println("Pos Columns: " + positioncolumns);
	}
	
	public void fetchPos(World a) {
		for(int k = 0; k<a.overboard.size(); k++) {
			for(int g = 0; g<=a.overboard.get(k).columns; g++) {
				for(int c = 0;c<=a.overboard.get(k).rows; c++) {
					Board h = a.overboard.get(k);
					if(h.board[c][g].equals(character)) {
						curtag = h.tag;
						positionrows = c;
						positioncolumns = g;
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
		c.board[positionrows][positioncolumns] = prevtile;
		switch(a) {
			case "North":
				positionrows = positionrows-distance;
				break;
			case "South": 
				positionrows = positionrows+distance;
				break;
			case "East": 
				positioncolumns = positioncolumns+distance;
				break;
			case "West": 
				positioncolumns = positioncolumns-distance;
				break;
			default:
				System.out.println("You did nothing!");
				break;
		}
		prevtile = c.board[positionrows][positioncolumns];
		c.board[positionrows][positioncolumns] = character;
	}
	
	/** 
	 * This method provides a pacman-style of moving, where if a player moves to far up, the player will go around instead of move to a new board 
	 *
	 * @param direction
	 * @param distance
	 */
	public void moveMod(Direction direction, int distance) {
		Board c = pos.returnBoard(curtag);
		c.board[positionrows][positioncolumns] = prevtile;
			switch(direction) {
				case NORTH:
					if (distance>positionrows-1) {
						positionrows = c.rows - (distance % (positionrows-1)) + 1;
					}else {
						positionrows = positionrows-distance;
					}
					break;
				case SOUTH:
					if(distance>(c.rows-positionrows)) {
						positionrows = (distance % (c.rows-positionrows));
					} else {
						positionrows = positionrows+distance;
					}
					break;
				case EAST:
					if(distance>(c.columns-positioncolumns)) {
						positioncolumns = (distance % (c.columns-positioncolumns));
					} else {
						positioncolumns = positioncolumns+distance;
					}
					break;
				case WEST:
					if(distance>(positioncolumns-1)) {
						positioncolumns = c.columns - (distance % (positioncolumns-1));
					} else {
						positioncolumns = positioncolumns-distance;
					}
					break;
			}
			prevtile = c.board[positionrows][positioncolumns];
			c.board[positionrows][positioncolumns] = character;
	}
	
	public void moveNorth(int distance) {
		dir = Direction.NORTH;
		Board j = pos.returnBoard(curtag);
		j.board[positionrows][positioncolumns] = prevtile;
		movedtoomuch = false;
		if(distance>(positionrows-1)) {
			if(pos.checkTagList(curtag.posx,curtag.posy+1)) {
				
				Board t = pos.returnBoard(curtag.posx, curtag.posy + 1);
				
				//It's too large for the next board
				if((distance-(positionrows-1)>t.rows)) {
					System.out.println("Moving Too Much");
					movedtoomuch = true;
				} else {
					positionrows = t.rows - (distance-(positionrows));
					
					prevtile = t.board[positionrows][positioncolumns];
					t.board[positionrows][positioncolumns] = character;
					
					
				}
			} else {
				
				Tag board = new Tag(curtag.posx, curtag.posy+1);
				int k = (int) (Math.random() * 10) + 5;
				
				if(pos.checkTagList(curtag.posx+1, curtag.posy+1)) {
					k = pos.returnBoard(curtag.posx+1, curtag.posy+1).rows;
				} else if(pos.checkTagList(curtag.posx-1, curtag.posy+1)) {
					k = pos.returnBoard(curtag.posx-1, curtag.posy+1).rows;
				}
				
				Board t = new Board(k, j.columns, board);
				Methods.setupBoard(t);
				pos.addBoard(t);
				
				if(distance-(positionrows-1)>t.rows) {
					moveNorth((distance-(positionrows -1))-t.rows);
				} else {
					positionrows = t.rows - (distance-(positionrows));
					
					prevtile = t.board[positionrows][positioncolumns];
					t.board[positionrows][positioncolumns] = character;
				}
				
			}
		} else {
			positionrows = positionrows - distance;
			prevtile = j.board[positionrows][positioncolumns];
			j.board[positionrows][positioncolumns] = character;
		}
	}
	
	public void moveSouth(int distance) {
		dir = Direction.SOUTH;
		Board j = pos.returnBoard(curtag);
		j.board[positionrows][positioncolumns] = prevtile;
		movedtoomuch = false;
		if(distance>((j.rows-1)-(positionrows-1))) {
			if(pos.checkTagList(curtag.posx,curtag.posy-1)) {
				
				Board t = pos.returnBoard(curtag.posx, curtag.posy-1);
				
				//It's too large for the next board
				if((distance-(j.rows - positionrows-1)>t.rows)) {
					System.out.println("Moving Too Much");
					movedtoomuch = true;
				} else {
					distance = distance - (j.rows  - (positionrows)); 
					positionrows = distance;
					
					prevtile = t.board[positionrows][positioncolumns];
					t.board[positionrows][positioncolumns] = character;
					
					
				}
			} else {
				Tag board = new Tag(curtag.posx,curtag.posy-1);
				int k = (int) (Math.random() * 9) + 5;
				
				if(pos.checkTagList(curtag.posx+1, curtag.posy-1)) {
					k = pos.returnBoard(curtag.posx+1, curtag.posy).rows;
				} else if(pos.checkTagList(curtag.posx-1, curtag.posy-1)) {
					k = pos.returnBoard(curtag.posx-1, curtag.posy).rows;
				}
				
				Board t = new Board(k, j.columns, board);
				Methods.setupBoard(t);
				pos.addBoard(t);
				
				if((distance-(j.rows - positionrows-1)>t.rows)) {
					System.out.println("Moving Too Much");
					//distance = distance - (positionrows-1) - t.rows;
					//go South Method
				} else {
					distance = distance - (j.rows  - (positionrows)); 
					positionrows = distance;
					
					prevtile = t.board[positionrows][positioncolumns];
					t.board[positionrows][positioncolumns] = character;
				}
				
			}
		} else {
			positionrows = positionrows + distance;
			prevtile = j.board[positionrows][positioncolumns];
			j.board[positionrows][positioncolumns] = character;
		}
	}
	
	public void moveEast(int distance) {
		dir = Direction.EAST;
		Board j = pos.returnBoard(curtag);
		j.board[positionrows][positioncolumns] = prevtile;
		movedtoomuch = false;
		if(distance>((j.columns-1)-(positioncolumns-1))) {
			if(pos.checkTagList(curtag.posx+1, curtag.posy)) {
				
				Board t = pos.returnBoard(curtag.posx+1, curtag.posy);
				
				if((distance-(j.columns-(positioncolumns-1))) > t.columns) {
					System.out.println("Moving too much");
					movedtoomuch = true;
				} else {
					positioncolumns = distance - (j.columns - (positioncolumns));
					
					prevtile = t.board[positionrows][positioncolumns];
					t.board[positionrows][positioncolumns] = character;
				}
			} else {
				Tag board = new Tag(curtag.posx+1,curtag.posy);
				int k = (int) (Math.random() * 9) + 5;
				
				if(pos.checkTagList(curtag.posx +1, curtag.posy + 1)) {
					k = pos.returnBoard(curtag.posx + 1, curtag.posy + 1).columns;
				}else if(pos.checkTagList(curtag.posx + 1, curtag.posy -1)) {
					k = pos.returnBoard(curtag.posx + 1, curtag.posy - 1).columns;
				}
				Board t = new Board(j.rows,k,board);
				Methods.setupBoard(t);
				pos.addBoard(t);
				
				if((distance-(j.columns-(positioncolumns-1)))> t.columns ) {
					System.out.println("Moving too much");
				} else {
					positioncolumns = distance - (j.columns - (positioncolumns));
					
					prevtile = t.board[positionrows][positioncolumns];
					t.board[positionrows][positioncolumns] = character;
				}		
			}
		} else {
			positioncolumns = positioncolumns + distance;
			prevtile = j.board[positionrows][positioncolumns];
			j.board[positionrows][positioncolumns] = character;
		}
	}
	
	public void moveWest(int distance) {
		dir = Direction.WEST;
		Board j = pos.returnBoard(curtag);
		j.board[positionrows][positioncolumns] = prevtile;
		movedtoomuch = false;
		if(distance>positioncolumns-1) {
			if(pos.checkTagList(curtag.posx-1, curtag.posy)) {
				
				Board t = pos.returnBoard(curtag.posx-1, curtag.posy);
				
				if((distance-(positioncolumns-1)) > t.columns) {
					System.out.println("Moving too much");
					movedtoomuch = true;
				} else {
					positioncolumns = t.columns - (distance - (positioncolumns));
					
					prevtile = t.board[positionrows][positioncolumns];
					t.board[positionrows][positioncolumns] = character;
				}
			} else {
				Tag board = new Tag(curtag.posx-1,curtag.posy);
				int k = (int) (Math.random() * 9) + 5;
				
				if(pos.checkTagList(curtag.posx -1, curtag.posy + 1)) {
					k = pos.returnBoard(curtag.posx - 1, curtag.posy + 1).columns;
				}else if(pos.checkTagList(curtag.posx - 1, curtag.posy -1)) {
					k = pos.returnBoard(curtag.posx - 1, curtag.posy - 1).columns;
				}
				Board t = new Board(j.rows,k,board);
				Methods.setupBoard(t);
				pos.addBoard(t);
				
				if((distance-(positioncolumns-1))> t.columns ) {
					System.out.println("Moving too much");
				} else {
					positioncolumns = t.columns - (distance - (positioncolumns));
					
					prevtile = t.board[positionrows][positioncolumns];
					t.board[positionrows][positioncolumns] = character;
				}		
			}
		} else {
			positioncolumns = positioncolumns - distance;
			prevtile = j.board[positionrows][positioncolumns];
			j.board[positionrows][positioncolumns] = character;
		}
	}
	
	
	/**
	 * Don't interact with a border, it wouldn't work.
	 * Most likely the player wouldn't try to interact with the border
	 * 
	 */
	public void interact() {
		boolean g;
		Ask b = new Ask();
		switch(dir) {
			case WEST:
				for(Item a: pos.returnBoard(curtag).specials) {
					if(a.positionrows == positionrows && a.positioncolumns == positioncolumns - 1) {
						g = b.yeno("Do You want to pick up this Item?");
						if(g) {
							inventory.addToInventory(a);
							pos.returnBoard(curtag).board[a.positionrows][a.positioncolumns] = a.prevtile;
							pos.returnBoard(curtag).specials.remove(pos.returnBoard(curtag).specials.indexOf(a));
							break;
						}
					}
				}
				break;
			case EAST:
				for(Item a: pos.returnBoard(curtag).specials) {
					if(a.positionrows == positionrows && a.positioncolumns == positioncolumns + 1) {
						g = b.yeno("Do You want to pick up this Item?");
						if(g) {
							inventory.addToInventory(a);
							pos.returnBoard(curtag).board[a.positionrows][a.positioncolumns] = a.prevtile;
							pos.returnBoard(curtag).specials.remove(pos.returnBoard(curtag).specials.indexOf(a));
							break;
						}
					}
				}
				break;
			case NORTH:
				for(Item a: pos.returnBoard(curtag).specials) {
					if(a.positionrows == positionrows-1 && a.positioncolumns == positioncolumns) {
						g = b.yeno("Do You want to pick up this Item?");
						if(g) {
							inventory.addToInventory(a);
							pos.returnBoard(curtag).board[a.positionrows][a.positioncolumns] = a.prevtile;
							pos.returnBoard(curtag).specials.remove(pos.returnBoard(curtag).specials.indexOf(a));
							break;
						}
					}
				}
				break;
			case SOUTH:
				for(Item a: pos.returnBoard(curtag).specials) {
					if(a.positionrows == positionrows+1 && a.positioncolumns == positioncolumns) {
						g = b.yeno("Do You want to pick up this Item?");
						if(g) {
							inventory.addToInventory(a);
							pos.returnBoard(curtag).board[a.positionrows][a.positioncolumns] = a.prevtile;
							pos.returnBoard(curtag).specials.remove(pos.returnBoard(curtag).specials.indexOf(a));
							break;
						}
					}
				}
				break;
		}
	}
	
	public void interact(Board a) {
		
	}
	
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
