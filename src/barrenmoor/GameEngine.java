package barrenmoor;
import java.util.HashMap;

class GameEngine {
	DisplayManager display = new DisplayManager();
	MoorFeature treasure;
	static HashMap<String, Integer> directionToBearing = new HashMap<String, Integer>();
	static HashMap<Integer, String> eastingToDirection = new HashMap<Integer, String>();
	static HashMap<Integer, String> northingToDirection = new HashMap<Integer, String>();

	GameEngine(){
		initialiseGame();
		buildDirectionMaps();
	}

	void initialiseGame() {
		generateTreasure();
	}
	
	void buildDirectionMaps() {
		directionToBearing.put("E", 1);
		directionToBearing.put("N", 1);
		directionToBearing.put("W", -1);
		directionToBearing.put("S", -1);
		
		eastingToDirection.put(1, "E");
		northingToDirection.put(1, "N");
		eastingToDirection.put(-1, "W");
		northingToDirection.put(-1, "S");
	}

	void playGame() {
		display.display("Starting game");
		playScriptedGame();
	}

	void playScriptedGame() {
		movePlayer(-2, 6);
		displayTreasureLocation();
		displayTreasureDistance();
	}

	void generateTreasure() {
		treasure = new Treasure(4, 6); // temporary default location
	}

	void movePlayer(int easting, int northing){
		treasure.moveRelativeToPlayer(easting, northing);
	}

	void displayTreasureLocation() {
		String message = String.format("%s @ %dE, %dN", treasure, treasure.getEasting(), treasure.getNorthing());
		display.display(message);
	}
	
	void displayTreasureDistance() {
		double treasureDistance = treasure.getDistanceFromPlayer();
		String treasureDistanceMessage = String.format("%.2f arbitrary units", treasureDistance);
		display.display(treasureDistanceMessage);
	}
}