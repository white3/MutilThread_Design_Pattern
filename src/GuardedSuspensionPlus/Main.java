package GuardedSuspensionPlus;

public class Main {

	public static void main(String[] args) throws InterruptedException {
//		Thread.sleep(10000);
		RequestQueueList queueList = new RequestQueueList(20);
		ClientThread clientThread0 = new ClientThread(queueList, "Menzel5", 1314524);
		clientThread0.start();
		clientThread0.interrupt();
//		new ClientThread(queueList, "Menzel4", 1314523).start();
//		new ClientThread(queueList, "Menzel3", 1314522).start();
//		new ClientThread(queueList, "Menzel2", 1314521).start();
//		new ClientThread(queueList, "Menzel1", 1314520).start();
		new ServerThread(queueList, "white3", 5201314).start();
		new ServerThread(queueList, "white2", 5201314).start();
		new ServerThread(queueList, "white1", 5201314).start();
	}
}
