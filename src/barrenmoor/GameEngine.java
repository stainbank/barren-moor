package barrenmoor;

class GameEngine {
	DisplayManager display = new DisplayManager();
	Translator translator = new Translator();
	MoorFeature treasure;
	boolean treasureLocationVisible = false;

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
		displayTreasureDistance();
		if (treasureLocationVisible) displayTreasureLocation();
	}

	void movePlayer(int easting, int northing){
		treasure.moveRelativeToPlayer(easting, northing);
	}

	void displayTreasureLocation() {
		int easting = treasure.getEasting();
		int northing = treasure.getNorthing();

		String messageTemplate = "%s @ %d%s, %d%s";
		String message = String.format(messageTemplate, treasure,
				Math.abs(northing), translator.translateNorthing(northing),
				Math.abs(easting), translator.translateEasting(easting));
		display.display(message);
	}
	
	void displayTreasureDistance() {
		double treasureDistance = treasure.getDistanceFromPlayer();
		String treasureDistanceMessage = String.format("%.2f arbitrary units", treasureDistance);
		display.display(treasureDistanceMessage);
	}
}