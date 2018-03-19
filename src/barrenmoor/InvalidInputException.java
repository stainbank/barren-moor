package barrenmoor;

public class InvalidInputException extends Exception {
	InvalidInputException(String message){
		super(message);
	}

	InvalidInputException(char character){
		super(String.valueOf(character));
	}
}
