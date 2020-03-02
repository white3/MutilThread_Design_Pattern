package Thread_Per_Messaage;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("MAIN BEGIN");
		Host host = new Host();

		host.request(10, 'A');
		host.request(10, 'B');
		host.request(10, 'C');
		host.request(10, 'X');
		host.request(10, 'Y');
		host.request(10, 'Z');

		System.out.println("MAIN END");
	}
}
