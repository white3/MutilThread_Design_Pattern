package Producer_Consumer;

import java.util.Random;

public class EatThreader extends Thread {
	private final Random random;
	private final Table table;

	public EatThreader(String name, Table table, long seed) {
		super(name);
		this.random = new Random(seed);
		this.table = table;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(random.nextInt(1000));
				table.take();
				// System.out.println(Thread.currentThread().getName() + " take " + table.take() + " to eat.");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
