package chapter1.Single_Threaded_Execution;

public class Main {

	public static void main(String[] args) {
		System.out.println("Testing Gate, hit Ctrl+C to exit");
		
		Gate gate = new Gate();
		new UserThread("Apple", "Amly", gate).start();
		new UserThread("Banana", "Black", gate).start();
		new UserThread("White3", "White", gate).start();
	}

}
