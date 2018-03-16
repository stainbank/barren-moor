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
		displayTreasureLocation();
		displayTreasureDistance();
	}

	void generateTreasure() {
		treasure = new Treasure(4, 6); // temporary default location
	}

	void movePlayer(int easting, int northing){
		treasure.moveRelativeToPlayer(easting, northing);
	}

	static class movementMapping{
		static String northingToDirection(int northing) {
			return (northing > 0) ? "N" : "S";
		}

		static String eastingToDirection(int easting) {
			return (easting > 0) ? "E" : "W";
		}
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
