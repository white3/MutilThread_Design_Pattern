package Guarded_Timed;

import java.util.concurrent.TimeoutException;

public class Main {

	public static void main(String[] args) {
		Host host = new Host(10000);
		try {
			host.execute();
			System.out.println("execute BEGIN: ");
		} catch (TimeoutException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
