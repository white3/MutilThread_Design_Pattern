package GuardedSuspensionPlus;

import java.util.Random;

public class ServerThread extends Thread {
	private final RequestQueueList queueList;
	private final Random random;

	public ServerThread(RequestQueueList queueList, String name, int seed) {
		super(name);
		this.queueList = queueList;
		this.random = new Random(seed);
	}

	@Override
	public void run() {
		RequestQueue queue = queueList.getRequestQueue();
		Request request;
		while (true) {
			request = queue.getRequest();
			if (request == null) { // 当前缓冲区为空, 切换为下一个缓冲区
				queue = queueList.getRequestQueue();
				try {
					Thread.sleep(random.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			System.out.println(Thread.currentThread().getName() + " requests " + request);
		}
	}
}
