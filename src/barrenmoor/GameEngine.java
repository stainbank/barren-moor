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
		display.display(treasure.toString());
		movePlayer(2,-6);
		display.display(treasure.toString());
	}

	void movePlayer(int easting, int northing){
		treasure.moveRelativeToPlayer(easting, northing);
	}
	
	void generateTreasure() {
		treasure = new Treasure(4, 6); // temporary default location
	}
}
