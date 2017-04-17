package chat;

public class UserMessage extends User {
	
	String message;
	
	public UserMessage(User felhasz, String uzenet) {
		super (felhasz.userName, felhasz.password);
		this.message = uzenet;
		
	}

	
}
