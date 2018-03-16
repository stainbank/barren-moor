package barrenmoor;

class GameEngine {
	MoorFeature treasure;

	GameEngine(){
		generateTreasure();
	}
	
	void generateTreasure() {
		this.treasure = new Treasure(4, 6); // temporary default location
	}
}
