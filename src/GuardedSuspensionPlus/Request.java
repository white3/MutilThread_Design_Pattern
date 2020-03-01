package GuardedSuspensionPlus;

public class Request {
	private final String message;

	public Request(String name) {
		super();
		this.message = name;
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Request [message=" + message + "]";
	}
		
}
