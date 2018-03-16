package barrenmoor;

public abstract class MoorFeature {
	/*Northing and Easting are traditional cartographic terms meaning
	 * _distance North_ and _distance East_ from Cartesian map origin (0,0).
	 * Here they represent distance North/East from player in arbitrary units.
	 */
	int northing;
	int easting;
}
