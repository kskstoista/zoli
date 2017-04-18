package chat;

public class MessageObject implements Comparable<MessageObject> {
	int id;
	String sender;
	String message;
	
	long time;

	public int compareTo(MessageObject other) {
	    return Long.compare(this.time, other.time);
	}

}