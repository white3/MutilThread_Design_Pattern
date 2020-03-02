package Worker_Thread;

import java.util.Random;

public class Request {
	private static final Random random = new Random();
	private final String name;	// 委托者
	private final int number;	// 请求的编号
	
	public Request(String name, int i) {
		this.name = name;
		this.number = i;
	}
	
	public void execute() {
		System.out.println(Thread.currentThread().getName() + " execute " + this);
		try {
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "Request [name=" + name + ", number=" + number + "]";
	}
	

}
