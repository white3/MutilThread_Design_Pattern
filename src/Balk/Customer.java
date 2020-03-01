package Balk;

import java.io.IOException;
import java.util.Random;

public class Customer extends Thread {
	private final Random random = new Random();;
	private Data data;

	public Customer(String name, Data data) {
		super(name);
		this.data = data;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; true; i++) {
				data.change("[+] The No." + i + " food.");
				Thread.sleep(random.nextInt(2000));
				data.save();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
