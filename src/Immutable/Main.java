package Immutable;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("Menzel3", "menzel3@menzel3.com");
		new Thread(new PrintPersonThread(person)).start();
		new Thread(new PrintPersonThread(person)).start();
		new Thread(new PrintPersonThread(person)).start();
		new Thread(new PrintPersonThread(person)).start();
		new Thread(new PrintPersonThread(person)).start();
	}
}
