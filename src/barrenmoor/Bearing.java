package barrenmoor;

class Bearing {
	private int bearing = 0;
	private char positiveDirection;
	private char negativeDirection;

	Bearing(char positiveDirection, char negativeDirection){
		this.positiveDirection = positiveDirection;
		this.negativeDirection = negativeDirection;
	}
	
	void add(int bearingChange) {
		bearing += bearingChange;
	}
	
	char getDirection(int signum){
		return (signum > 0) ? positiveDirection : negativeDirection;
	}
	
	int getBearing() {
		return bearing;
	}
	
	String getBearingMessage(int bearingChange) {
		return String.format("%d%s", Math.abs(bearingChange), getDirection((int)Math.signum(bearingChange)));
	}

	String getBearingMessage() {
		return getBearingMessage(bearing);
	}
}
