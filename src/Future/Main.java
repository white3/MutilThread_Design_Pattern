package Future;

public class Main {

	public static void main(String[] args) {
		System.out.println("main BEGIN");
		Host host = new Host();
		Data data1 = host.request(5, 'A');
		Data data2 = host.request(10, 'B');
		Data data3 = host.request(15, 'C');

		System.out.println("main otherJob BEGIN");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main otherJob END");

		System.out.println(data1.getContent());
		System.out.println(data2.getContent());
		System.out.println(data3.getContent());
		System.out.println("main END");
	}

}
