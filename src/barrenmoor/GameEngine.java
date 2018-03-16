package barrenmoor;

class GameEngine {
	MoorFeature treasure;

	GameEngine(){
		initialiseGame();
	}

	void playGame() {
		displayMessage("Starting game");
		displayMessage(treasure.toString());
	}
	
	void initialiseGame() {
		generateTreasure();
	}

	void generateTreasure() {
		this.treasure = new Treasure(4, 6); // temporary default location
	}
	
	void displayMessage(String messageToUser) {
		System.out.println(messageToUser);
	}	
}
