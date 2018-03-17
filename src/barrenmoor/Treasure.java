package barrenmoor;

class Treasure extends MoorFeature {
	Treasure(int initialEasting, int initialNorthing) {
		super(initialEasting, initialNorthing);
	}
	
	public String toString(){
		return String.format("Treasure");
	}
}
