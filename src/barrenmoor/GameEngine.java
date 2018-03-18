package barrenmoor;

class GameEngine {
	DisplayManager display = new DisplayManager();
	MoorFeature treasure;
	double unitModifier = 1;
	String unitName = "arbitrary units";
	boolean treasureLocationVisible = false;
	MoorFeature player = new Player();

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
		runTurn();
	}
	
	void generateTreasure() {
		treasure = new Treasure(4, 6); // temporary default location
	}
	
	void runTurn() {
		String simulatedUserCommand = "1NE4S"; // -> 1E, 3S
		int[] playerMove = translateUserCommandToPlayerMove(simulatedUserCommand);
		int eastingChange = playerMove[0];
		int northingChange = playerMove[1];
		makeAndDisplayPlayerMove(eastingChange, northingChange);
	}

	void makeAndDisplayPlayerMove(int eastingChange, int northingChange) {
		movePlayer(eastingChange, northingChange);
		displayPlayerMovement(eastingChange, northingChange);
		displayTreasureDistance();
		if (treasureLocationVisible) displayTreasureLocation();
	}

	void movePlayer(int eastingChange, int northingChange){
		treasure.moveRelativeToPlayer(eastingChange, northingChange);
	}
	
	void displayPlayerMovement(int eastingChange, int northingChange){
		boolean eastingChanges = eastingChange != 0;
		boolean northingChanges = northingChange != 0;
		String eastingMessage = player.easting.getBearingMessage(eastingChange);
		String northingMessage = player.northing.getBearingMessage(northingChange);
		String joiner = (eastingChanges && northingChanges) ? ", " : "";
		
		String messageTemplate = "Moved %s%s%s";
		String message = String.format(messageTemplate, eastingMessage, joiner, northingMessage);
		display.display(message);
	}

	void displayTreasureLocation() {
		String messageTemplate = "%s @ %s, %s";
		String message = String.format(messageTemplate, treasure, treasure.easting.getBearingMessage(), treasure.northing.getBearingMessage());
		display.display(message);
	}
	
	void displayTreasureDistance() {
		double treasureDistance = treasure.getDistanceFromPlayer();
		String treasureDistanceMessage = String.format("%.2f %s", treasureDistance * unitModifier, unitName);
		display.display(treasureDistanceMessage);
	}
}