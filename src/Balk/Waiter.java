package Balk;

import java.io.IOException;

public class Waiter extends Thread {
	private final Data data;

	public Waiter(String name, Data data) {
		super(name);
		this.data = data;
	}

	@Override
	public void run() {
		try {
			while (true) {
				data.save();
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
