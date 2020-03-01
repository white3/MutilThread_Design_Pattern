package Producer_Consumer;

public class Table {
	private final String buffer[];
	private int tail;
	private int head;
	private int count;

	public Table(int count) {
		this.buffer = new String[count];
		this.count = 0;
		this.head = 0;	// the next position to put
		this.tail = 0;	// the next position to take
	}

	public synchronized void put(String cake) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " puts " + cake);
		while(count >= buffer.length) {
			wait();
		}
		buffer[head] = cake;
		head = (head + 1) % buffer.length;
		count++;
		notifyAll();
	}
	
	public synchronized String take() throws InterruptedException {
		while(count<=0) {
			wait();
		}
		String cake = buffer[tail];
		tail = (tail + 1) % buffer.length;
		count--;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + " takes " + cake);
		return cake;
	}
}
