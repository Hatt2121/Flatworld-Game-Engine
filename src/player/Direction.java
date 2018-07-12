package player;

public enum Direction {
	NORTH, 
	SOUTH, 
	EAST, 
	WEST;
	
	public static Direction fromString(String str) {
		String s = str.toLowerCase();
		Direction dir;
		switch(s) {
		case("north"):
			dir = Direction.NORTH;
			break;
		case("south"):
			dir = Direction.SOUTH;
			break;
		case("east"):
			dir = Direction.EAST;
			break;
		case("west"):
			dir = Direction.WEST;
			break;
		default:
			dir = null;
		}
		return dir;
	}
}
