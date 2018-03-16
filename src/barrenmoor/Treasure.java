package barrenmoor;

class Treasure extends MoorFeature {
	Treasure(int easting, int northing) {
		this.easting = easting;
		this.northing = northing;
	}
	
	public String toString(){
		return String.format("Treasure @ (%d, %d)", easting, northing);
	}
}
