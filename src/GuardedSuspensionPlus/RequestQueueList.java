package GuardedSuspensionPlus;

public class RequestQueueList {
	private final RequestQueue[] queuelist;
	private final int lenth;
	private int tail = 0;
	private int head = 1;

	public RequestQueueList(int lenth) {
		super();
		this.queuelist = new RequestQueue[lenth];
		for (int i = 0; i < queuelist.length; i++)
			queuelist[i] = new RequestQueue();
		this.lenth = lenth;
	}

	public synchronized RequestQueue getRequestQueue() {
		if (tail == head) {
//			System.out.println("[-]tail: " + tail);
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return queuelist[tail];
		} else {
			tail = (tail + 1) % lenth;
//			System.out.println("[-]tail: " + tail);
			this.notifyAll();
			return queuelist[tail];
		}

	}

	public synchronized RequestQueue getEmptyQueue() {
		int temp = (head + 1) % lenth;
	
		if (tail == temp) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			this.notifyAll();
		}
		head = temp;
//		System.out.println("[+]head: " + head);
		return queuelist[head];
	}
}
