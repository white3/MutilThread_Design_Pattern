package Balk;

public class Main {

	public static void main(String[] args) {
		Data data = new Data("the 2048", "Welcome to the 2048 restaurant");
		new Waiter("white3", data).start();
		new Waiter("white2", data).start();
		new Waiter("white1", data).start();
		new Customer("Menzel3", data).start();
	}
}
