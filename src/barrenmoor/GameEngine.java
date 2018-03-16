package barrenmoor;

class GameEngine {
	DisplayManager display = new DisplayManager();
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
		displayPlayerLocation();
	}

	void movePlayer(int easting, int northing){
		treasure.moveRelativeToPlayer(easting, northing);
	}
	
	void displayPlayerLocation() {
		display.display(treasure.toString());
	}
	
	void generateTreasure() {
		treasure = new Treasure(4, 6); // temporary default location
	}
}
