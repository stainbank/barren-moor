package barrenmoor;

class GameEngine {
	DisplayManager display = new DisplayManager();
	MoorFeature treasure;

	GameEngine(){
		initialiseGame();
	}

	void playGame() {
		display.display("Starting game");
		display.display(treasure.toString());
	}
	
	void initialiseGame() {
		generateTreasure();
	}

	void generateTreasure() {
		treasure = new Treasure(4, 6); // temporary default location
	}
}
