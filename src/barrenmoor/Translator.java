package barrenmoor;
import java.util.HashMap;

class Translator {
	static HashMap<String, Integer> directionToBearing = new HashMap<String, Integer>();
	static HashMap<Integer, String> eastingToDirection = new HashMap<Integer, String>();
	static HashMap<Integer, String> northingToDirection = new HashMap<Integer, String>();

	Translator(){
		directionToBearing.put("E", 1);
		directionToBearing.put("N", 1);
		directionToBearing.put("W", -1);
		directionToBearing.put("S", -1);
		
		eastingToDirection.put(1, "E");
		northingToDirection.put(1, "N");
		eastingToDirection.put(-1, "W");
		northingToDirection.put(-1, "S");
	}
}
