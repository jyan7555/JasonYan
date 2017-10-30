package caveExplorer;

public class CaveRoom {
	private String description;//tells what the room looks like
	private String directions;//tells what you can do
	private String contents;//a symbol representing what's in it
	private String defaultContents;
	//the rooms are organize by direction, 'null' signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}
	//constants
	public static final int NORTH= 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST= 3;
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and content is "contents" becomes an 'X' when you are
		//inside this room, when you leave, it goes back to defaultContents
		
		//note: by default, arrays will populate with null
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}
	public static String toDirection(int dir) {
		String[] directions = {"the North", "theEast", "the South", "the West"};
		return directions[dir];
	}
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for (int i=0; i<doors.length;i++) {
			if ( doors[i] != null) {
				doorFound = true;
				directions += "\n    There is a " + doors[i].getDescription() + " to " + toDirection(i) + ". " + doors[i].getDetails();
			}
			if (!doorFound) {
				directions += "There is no way out. You are trapped in here.";
			}
		}
	}
	public void enter() {
		contents = "X";
	}
	public void leave() {
		contents = defaultContents;
	}
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	private int oppositeDirection(int direction) {
		return (direction +2)%4;
	}
	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
	}
	public void interpretInput(String input) {
		while(isValid(input)) {
			System.out.println("You can you only enter 'w','a','s', or 'd'");
			input = CaveExplorer.in.nextLine();
			//task: convert user input into a direction
		
			String output = "wdsa";
			/*int num = output.indexOf(input);
			int direction = num;*/
			
			goToRoom(output.indexOf(input));
		}
	}
	private void goToRoom(int direction) {
		//first, protect against null pointer exception
		//(user cannot go through non-existent door)
		if (borderingRooms[direction] != null && doors[direction] != null) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
	}
	public static void setUpCaves() {
		
	}
	private boolean isValid(String input) {
		String validEntries = "wdsa";
		return validEntries.indexOf(input) > -1 && input.length() == 1;
	}
	public Door getDoor(int west2) {
		return doors[direction];
	}
}