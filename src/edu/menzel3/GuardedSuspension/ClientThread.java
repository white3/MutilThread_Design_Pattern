package edu.menzel3.GuardedSuspension;

import java.util.Random;

public class ClientThread extends Thread {
	private final RequestQueueList queueList;
	private final Random random;

	public ClientThread(RequestQueueList queueList, String name, int seed) {
		super(name);
		this.queueList = queueList;
		this.random = new Random(seed);
	}

	@Override
	public void run() {
		RequestQueue queue = queueList.getEmptyQueue();
		for (int i = 0; i < 10000000; i++) {
			Request request = new Request("No." + i + " : " + Thread.currentThread().getName());
			// System.out.println(Thread.currentThread().getName() + " requests " +
			// request);
			if (!queue.putRequest(request)) {
				queue = queueList.getEmptyQueue();
				queue.putRequest(request);
			}

			try {
				Thread.sleep(random.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
