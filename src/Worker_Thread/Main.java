package Worker_Thread;

public class Main {

	public static void main(String[] args) {
		Channel channel = new Channel(5);
		channel.startWorkers();
		new ClientThread("Alice", channel).start();
		new ClientThread("Black", channel).start();
		new ClientThread("Chris", channel).start();
	}

}
