package Main;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ConcurrentSemaphore {

	public static void main(String[] args) {
		BoundedResource boundedResource = new BoundedResource(5);
		for (int i = 0; i < 100; i++) {
			new UserThread(boundedResource).start();
		}
	}

}

class Log {
	public static void println(String s) {
		System.out.println(Thread.currentThread().getName() + ": " + s);
	}
}

class BoundedResource {
	private final Semaphore semaphore;
	private final int permits;
	private final static Random random = new Random(12638912);

	public BoundedResource(int permits) {
		this.semaphore = new Semaphore(permits);
		this.permits = permits;
	}

	public void use() throws InterruptedException {
		semaphore.acquire();
		try {
			doUse();
		} finally {
			semaphore.release();
		}
	}

	private void doUse() throws InterruptedException {
		Log.println("[+]BEGIN: used = " + (permits - semaphore.availablePermits()) + " avaliable = "
				+ semaphore.availablePermits());
		Thread.sleep(random.nextInt(500));
		Log.println("[-]END: used = " + (permits - semaphore.availablePermits()) + " avaliable = "
				+ semaphore.availablePermits());
	}
}

class UserThread extends Thread {
	private final static Random random = new Random(26535);
	private final BoundedResource resource;

	public UserThread(BoundedResource resource) {
		super();
		this.resource = resource;
	}

	@Override
	public void run() {
		try {
			while (true) {
				this.resource.use();
				Thread.sleep(random.nextInt(200));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}