package barrenmoor;

class CommandParser {
	private String remainingUserCommand;
	private int[] bearingChanges = new int[2];

	CommandParser(String userCommand) {
		userCommand = userCommand.toUpperCase();
		remainingUserCommand = userCommand;
	}
	
	void parseCommand(){
		while (!remainingUserCommand.isEmpty()) {
			parseNextToken();
		}
	}

	void parseNextToken(){
		int nSteps = 1;
		for (int i = 0; i < 2; i++) {
			char token = remainingUserCommand.charAt(i);
			try {
				nSteps = Integer.parseInt(String.valueOf(token));
			} catch (NumberFormatException e) {
				switch (token) {
					case 'E': bearingChanges[0] += nSteps;
							  break;
					case 'N': bearingChanges[1] += nSteps;
							  break;
					case 'W': bearingChanges[0] -= nSteps;
							  break;
					case 'S': bearingChanges[1] -= nSteps;
							  break;
					default : System.out.println(token + "is not a valid token");; // TODO throw exception
				}
					remainingUserCommand = remainingUserCommand.substring(i + 1);
					return;
			}
		}
	}

	int[] getBearingChanges() {
		return bearingChanges;
	}
}
