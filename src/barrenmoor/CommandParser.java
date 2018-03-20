package barrenmoor;

class CommandParser {
	private String remainingUserCommand;
	private int[] bearingChanges = new int[2];

	CommandParser(String userCommand) {
		userCommand = userCommand.toUpperCase();
		remainingUserCommand = userCommand;
	}
	
	void parseCommand() throws InvalidInputException {
		while (!remainingUserCommand.isEmpty()) {
			parseNextToken();
		}
	}

	void parseNextToken() throws InvalidInputException {
		String digits = "";
		boolean isDigit = true;
		int i;
		for (i = 0; isDigit && i < remainingUserCommand.length(); i++) {
			char token = remainingUserCommand.charAt(i);
			if (Character.isDigit(token)){
				digits += String.valueOf(token);
			} else {
				int nSteps = nStepsFromDigits(digits);
				applySteps(nSteps, token);
				isDigit = false;
			}
		}
		remainingUserCommand = remainingUserCommand.substring(i);
		return;
	}	
	
	int nStepsFromDigits(String digits){
		return (digits.isEmpty()) ? 1 : Integer.parseInt(digits);
	}
	
	void applySteps(int nSteps, char direction) throws InvalidInputException {
		switch (direction) {
			case 'E': bearingChanges[0] += nSteps;
					  break;
			case 'N': bearingChanges[1] += nSteps;
					  break;
			case 'W': bearingChanges[0] -= nSteps;
					  break;
			case 'S': bearingChanges[1] -= nSteps;
					  break;
			default : throw new InvalidInputException(String.valueOf(direction));
		}
	}
	
	boolean isDigit(char token){
		boolean isDigit;
		try {
			Integer.parseInt(String.valueOf(token));
			isDigit = true;
		} catch (NumberFormatException e) {isDigit = false;}
		return isDigit;
	}
	
	int[] getBearingChanges() {
		return bearingChanges;
	}
}
