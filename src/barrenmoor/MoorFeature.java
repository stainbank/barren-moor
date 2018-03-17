package barrenmoor;

abstract class MoorFeature {
	/*Easting and Northing are traditional cartographic terms meaning
	 * _distance East_ and _distance North_ from Cartesian map origin (0,0).
	 * Here they represent the distances East and North (in arbitrary units)
	 * of a feature from the player. This tuple is referred to as the feature's
	 * "location", which changes as the player moves. In effect, the player
	 * is fixed and the world moves around them.
	 */
	Bearing easting = new Bearing('E', 'W');
	Bearing northing = new Bearing('N', 'S');
	
	MoorFeature(int initialEasting, int initialNorthing){
		easting.add(initialEasting);
		northing.add(initialNorthing);
	}
	
	double getDistanceFromPlayer() {
		return Math.sqrt(Math.pow(easting.getBearing(), 2) + Math.pow(northing.getBearing(), 2));
	}
	
	void moveRelativeToPlayer(int easting, int northing) {
		this.easting.add(easting);
		this.northing.add(northing);
	}
}
