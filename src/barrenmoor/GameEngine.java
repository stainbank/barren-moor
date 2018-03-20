package barrenmoor;

import java.util.Scanner;

class GameEngine {
	DisplayManager display = new DisplayManager();
	MoorFeature treasure;
	double unitModifier = 1;
	String unitName = "arbitrary units";
	boolean treasureLocationVisible = false;
	MoorFeature player = new Player();
	Scanner scanner = new Scanner(System.in);
	boolean gameRunning;

	GameEngine(){
		initialiseGame();
	}

	void initialiseGame() {
		generateTreasure();
		gameRunning = true;
	}
	
	void activateCheats() {
		treasureLocationVisible = true;
	}
	
	void playGame() {
		display.display("Starting game");
		while (gameRunning) {
			runTurn();
		}
		displayGameOver();
	}
	
	void generateTreasure() {
		treasure = new Treasure(4, 6); // temporary default location
	}
	
	void runTurn() {
		String startTurnMessage = "New turn, please enter command:";
		display.display(startTurnMessage);

		int[] playerMove = getValidPlayerMove();
		if (!gameRunning) return;
		makeAndDisplayPlayerMove(playerMove[0], playerMove[1]);
	}

	int[] getValidPlayerMove() {
		boolean invalidInput = true;
		int[] playerMove = new int[2];
		while (invalidInput) {
			String userCommand = getUserCommand();
			if (isExitRequested(userCommand)) {
				gameRunning = false;
				break;
			}
			try {
				playerMove = translateUserCommandToPlayerMove(userCommand);
				invalidInput = false;
			} catch (InvalidInputException e) {
				displayInvalidInput(userCommand);
			}
		}
		return playerMove;
	}
	
	String getUserCommand(){
		return scanner.next();
	}
	
	boolean isExitRequested(String userCommand) {
		switch (userCommand.toLowerCase()) {
		case "q": return true;
		case "quit": return true;
		case "exit": return true;
		default : return false;
		}
	}
	
	int[] translateUserCommandToPlayerMove(String userCommand) throws InvalidInputException {
		CommandParser commandParser = new CommandParser(userCommand);
		commandParser.parseCommand();
		return commandParser.getBearingChanges();
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
	
	void displayInvalidInput(String invalidInput) {
		display.display(String.format("Invalid input: %s", invalidInput));
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
	
	void displayGameOver() {
		String gameOverMessage = "Game over :)";
		display.display(gameOverMessage);
	}
}