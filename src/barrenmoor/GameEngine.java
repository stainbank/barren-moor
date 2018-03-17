package barrenmoor;

class GameEngine {
	DisplayManager display = new DisplayManager();
	MoorFeature treasure;
	boolean treasureLocationVisible = false;
	Bearing playerEasting = new Bearing('E', 'W');
	Bearing playerNorthing = new Bearing('N', 'S');

	GameEngine(){
		initialiseGame();
	}

	void initialiseGame() {
		generateTreasure();
	}
	
	void activateCheats() {
		treasureLocationVisible = true;
	}
	
	void playGame() {
		display.display("Starting game");
		playScriptedGame();
	}

	void playScriptedGame() {
		makeAndDisplayMove(-2, 6);
	}

	void generateTreasure() {
		treasure = new Treasure(4, 6); // temporary default location
	}
	
	void makeAndDisplayMove(int easting, int northing) {
		movePlayer(easting, northing);
		displayPlayerMovement(easting, northing);
		displayTreasureDistance();
		if (treasureLocationVisible) displayTreasureLocation();
	}

	void movePlayer(int easting, int northing){
		treasure.moveRelativeToPlayer(easting, northing);
	}
	
	void displayPlayerMovement(int easting, int northing){
		boolean eastingChanges = easting != 0;
		boolean northingChanges = northing != 0;
		String eastingMessage = playerEasting.getBearingMessage(easting); 
		String northingMessage = playerNorthing.getBearingMessage(northing);
		String joiner = (eastingChanges && northingChanges) ? ", " : "";
		
		String messageTemplate = "Moved %s%s%s";
		String message = String.format(messageTemplate, eastingMessage, joiner, northingMessage);
		display.display(message);
	}

	void displayTreasureLocation() {
		String messageTemplate = "%s @ %s, %s";
		String message = String.format(messageTemplate, treasure, treasure.northing.getBearingMessage(), treasure.northing.getBearingMessage());		
		display.display(message);
	}
	
	void displayTreasureDistance() {
		double treasureDistance = treasure.getDistanceFromPlayer();
		String treasureDistanceMessage = String.format("%.2f arbitrary units", treasureDistance);
		display.display(treasureDistanceMessage);
	}
}