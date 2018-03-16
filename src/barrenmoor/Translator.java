package barrenmoor;
import java.util.HashMap;

class Translator {
	static HashMap<String, Integer> directionToBearingSign = new HashMap<String, Integer>();
	static HashMap<Integer, String> eastingToDirection = new HashMap<Integer, String>();
	static HashMap<Integer, String> northingToDirection = new HashMap<Integer, String>();
	static {
		directionToBearingSign.put("E", 1);
		directionToBearingSign.put("N", 1);
		directionToBearingSign.put("W", -1);
		directionToBearingSign.put("S", -1);

		eastingToDirection.put(1, "E");
		northingToDirection.put(1, "N");
		eastingToDirection.put(-1, "W");
		northingToDirection.put(-1, "S");
	}
	
	int translateDirection(String direction) {
		return directionToBearingSign.get(direction);
	}
	
	String translateEasting(int easting) {
		return eastingToDirection.get(Integer.signum(easting));
	}

	String translateNorthing(int northing) {
		return northingToDirection.get(Integer.signum(northing));
	}
}
