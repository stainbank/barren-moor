package barrenmoor;

class GameEngine {
	DisplayManager display = new DisplayManager();
	Translator translator = new Translator();
	MoorFeature treasure;

	GameEngine(){
		initialiseGame();
	}

	void initialiseGame() {
		generateTreasure();
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
		int easting = treasure.getEasting();
		int northing = treasure.getNorthing();
		String northingDirection = translator.translateNorthing(northing);
		String eastingDirection = translator.translateEasting(easting);

		String messageTemplate = "%s @ %d%s, %d%s";
		String message = String.format(messageTemplate, treasure,
				Math.abs(northing), northingDirection,
				Math.abs(easting), eastingDirection);
		display.display(message);
	}
	
	void displayTreasureDistance() {
		double treasureDistance = treasure.getDistanceFromPlayer();
		String treasureDistanceMessage = String.format("%.2f arbitrary units", treasureDistance);
		display.display(treasureDistanceMessage);
	}
}