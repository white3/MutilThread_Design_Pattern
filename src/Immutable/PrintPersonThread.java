package Immutable;

public class PrintPersonThread implements Runnable{
	private Person person;
	
	public PrintPersonThread(Person person) {
		super();
		this.person = person;
	}

	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread() + "prints " + person.toString());
		}
	}
}
