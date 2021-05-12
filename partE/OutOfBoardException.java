

public class OutOfBoardException extends Exception {

	private static final long serialVersionUID = 1L;
	String message;

	public OutOfBoardException(String string) {
		message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
