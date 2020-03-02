package Guarded_Suspension;

public class Main {

	public static void main(String[] args) {
		System.out.println("main BEGIN");
		
		RequestQueue requestQueue = new RequestQueue();
		new ClientThread(requestQueue, "Menzel3", 1314520).start();;
		new ServerThread(requestQueue, "white3", 5201314).start();
		System.out.println("main END");
	}
}
