package Thread_Specific_Storage;

public class Main {

	public static void main(String[] args) {
		System.out.println("main BEGIN");

		new ClientThread("Alice").start();
		new ClientThread("Menzel3").start();
		new ClientThread("Bob").start();

		System.out.println("main END");
	}
}
