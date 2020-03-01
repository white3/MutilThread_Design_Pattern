package SingleThreadedExecution;

public class Main {

	public static void main(String[] args) {
		System.out.println("Testing Gate, hit Ctrl+C to exit");
		
		// UnsafeGate gate = new UnsafeGate(); // Unsafe code
		SafeGate gate = new SafeGate();
		new UserThread("Apple", "Amly", gate).start();
		new UserThread("Banana", "Black", gate).start();
		new UserThread("White3", "White", gate).start();
	}

}
