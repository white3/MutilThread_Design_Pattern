package Thread_Specific_Storage;

public class ClientThread extends Thread {
	public ClientThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(getName() + " BEGIN");

		for (int i = 520; i < 530; i++) {
			Log.println("i = " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		Log.close();
		System.out.println(getName() + " END");
	}
}
