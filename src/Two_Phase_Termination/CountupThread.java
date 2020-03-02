package Two_Phase_Termination;

public class CountupThread extends Thread {
	private volatile boolean shutdownRequest = false;
	private long counter = 0;

	public void shutdownRequest() {
		shutdownRequest = true;
		interrupt();
	}

	public boolean isShutdownRequest() {
		return shutdownRequest;
	}

	@Override
	public void run() {
		try {
			while (!isShutdownRequest()) {
				doWork();
			}
		} catch (InterruptedException e) {
		} finally {
			doShutdown();
		}
	}

	private void doWork() throws InterruptedException {
		System.out.println("work: counter = " + ++counter);
		Thread.sleep(500);
	}

	private void doShutdown() {
		System.out.println("doshutdown: counter = " + counter);
	}
}
