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
			printAllowedEntry();
			input = CaveExplorer.in.nextLine();
			//task: convert user input into a direction
		
			String output = validKeys();
			/*int num = output.indexOf(input);
			int direction = num;*/
			
			respondToKey(output.indexOf(input));
		}
	}
	public String validKeys() {
		return "wdsa";
	}
	public void printAllowedEntry() {
		System.out.println("You can you only enter 'w','a','s', or 'd'");
	}
	public void respondToKey(int direction) {
		//first, protect against null pointer exception
		//(user cannot go through non-existent door)
		if (direction <4) {
			if (borderingRooms[direction] != null && doors[direction] != null) {
				CaveExplorer.currentRoom.leave();
				CaveExplorer.currentRoom = borderingRooms[direction];
				CaveExplorer.currentRoom.enter();
				CaveExplorer.inventory.updateMap();
			}
		}
		else {
			performAction(direction);
		}
	}
	public void performAction(int direction) {
		System.out.println("That key does nothing.");
	}
	public static void setUpCaves() {
		//ALL OF THIS CODE CAN BE CHANGED
		//1. Decide how big your caves should be
		CaveExplorer.caves = new CaveRoom[5][5];
		//2. Populate with caves and a defualt description: hint: when starting, use coordinates (helps debugging)
		for(int row = 0; row < CaveExplorer.caves.length; row++) {
			//PLEASE PAY ATTENTION TO THE DIFFERENCE:
			for(int col = 0; col < CaveExplorer.caves[row].length; col++) {
				//create a "default" cave
				CaveExplorer.caves[row][col] = 
						new CaveRoom("This cave has coords ("+row+","+col+")");
			}
		}
		//3. Replace default rooms with custom rooms
		//--- WE WILL DO LATER

		//4. Set your starting room:
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		//5. Set up dooors
		CaveRoom[][] c = CaveExplorer.caves;
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		/**
		 * Special requests:
		 * moving objects in caves
		 * what happens when you lose?
		 * can another object move toward you?
		 */

	}
	private boolean isValid(String input) {
		String validEntries = validKeys();
		return validEntries.indexOf(input) > -1 && input.length() == 1;
	}
	public Door getDoor(int west2) {
		return doors[west2];
	}
}