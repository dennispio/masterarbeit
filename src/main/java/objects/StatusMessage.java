package objects;

public class StatusMessage {

	private boolean wasSuccesfull;
	private String message;
	
	public StatusMessage() {
		this.wasSuccesfull = false;
		this.message = "";
	}

	public boolean isWasSuccesfull() {
		return wasSuccesfull;
	}

	public void setWasSuccesfull(boolean wasSuccesfull) {
		this.wasSuccesfull = wasSuccesfull;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
