package Producer_Consumer;

import java.util.Random;

public class MakerThreader extends Thread {
	private final Random random;
	private final Table table;
	private static int id = 0;

	public MakerThreader(String name, Table table, long seed) {
		super(name);
		this.random = new Random(seed);
		this.table = table;
	}

	@Override
	public void run() {

		try {
			while (true) {
				Thread.sleep(random.nextInt(1000));
				String cake = "[Cake No." + nextId() + " by " + Thread.currentThread().getName() + "]";
				// System.out.println(Thread.currentThread().getName() + " make cakes: " + cake);
				table.put(cake);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static synchronized int nextId() {
		return id++;
	}

}
