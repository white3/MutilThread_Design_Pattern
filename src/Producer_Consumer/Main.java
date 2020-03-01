package Producer_Consumer;

public class Main {

	public static void main(String[] args) {
		Table table = new Table(3);
		for (int i = 0; i < 10; i++) 
			new EatThreader("Eater" + i, table, 123 * i).start();
		
		for (int i = 0; i < 3; i++) 
			new MakerThreader("Maker" + i, table, 123 * i).start();
		
	}

}
