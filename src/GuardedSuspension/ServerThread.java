package GuardedSuspension;

import java.util.Random;

public class ServerThread extends Thread {
	private final RequestQueue requestQueue;
	private final Random random;

	public ServerThread(RequestQueue requestQueue, String name, int seed) {
		super(name);
		this.requestQueue = requestQueue;
		this.random = new Random(seed);
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Request request = requestQueue.getRequest();
			System.out.println(Thread.currentThread().getName() + " requests " + request);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
