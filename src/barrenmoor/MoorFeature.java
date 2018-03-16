package barrenmoor;

public abstract class MoorFeature {
	/*Easting and Northing are traditional cartographic terms meaning
	 * _distance East_ and _distance North_ from Cartesian map origin (0,0).
	 * Here they represent the distances East and North (in arbitrary units)
	 * of a feature from the player.
	 * In effect, the player is fixed and the world moves around them.
	 */
	int easting;
	int northing;
	
	public double getDistanceFromPlayer() {
		return Math.sqrt(Math.pow(easting, 2) + Math.pow(northing, 2));
	}

}
